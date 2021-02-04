
package java_laba_2;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.io.*;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.Timer;

public class Surface extends javax.swing.JPanel implements MouseListener, KeyListener, ActionListener {


    private  Timer timer = new Timer(15, this);
    Surface()
    {
        timer.start();
        this.setBackground(new Color(255, 255, 255));
    }
    public  CopyOnWriteArrayList<Drawable> objects = new  CopyOnWriteArrayList<>();
    private long prev_t = 0;

    void DrawObjects(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        long t = System.currentTimeMillis();

        float dt = (float)(t-prev_t)/1000.f;
        for (Drawable o : objects)
        {
            g2d.setPaint(o.color);
            o.Draw(g2d, dt);
            o.DrawRect(g2d);

        }

        prev_t = t;
    }


    void DrawRects(Graphics g) {}

    public Drawable pickObject(float x, float y) {

        for (Drawable o : objects)
        {
            if (o.isInside(x, y))
                return o;
        }
        return null;
    }

    public void addObject(Drawable o)
    {
        objects.add(o);
    }
    public void deleteObject(Drawable o)
    {
        objects.remove(o);
    }

    @Override
    public void paintComponent(Graphics g) {

        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        super.paintComponent(g);
        DrawObjects(g);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int x = e.getX() ;
        int y = e.getY() ;

        if (e.getButton() == MouseEvent.BUTTON1)
        {

            System.out.println("CLICKED : " + Integer.toString(x) + ' ' + Integer.toString(y));

            Drawable o = this.pickObject(x,y);
            if (o!=null) {
                objects.remove(o);
                System.out.println(" > DELETED");
            }
            else
            {
                Random r = new Random();
                boolean i =  r.nextBoolean();
                if (i) {
                    SmileHappy s = new SmileHappy();
                    s.centerX = x;
                    s.centerY = y;
                    this.addObject(s);}
                else
                {
                    SmileUnhappy s = new SmileUnhappy();
                    s.centerX = x;
                    s.centerY = y;
                    this.addObject(s);
                }
                System.out.println(" > ADDED");
            }
        }

        this.repaint();
    }

    void Update() { repaint(); }
    boolean isExit() { return false;}

    void WriteText(String filename)
    {
        System.out.println("SAVING AS TEXT");
        try {
            BufferedWriter bwriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("text.txt"), "UTF-8"));
            int count = objects.size();
            bwriter.write(Integer.toString(count) + '\n');
            for (Drawable o : objects)
            {
                String name = o.getClass().getName();
                bwriter.write(name + '\n');
                o.writeText(bwriter);
            }
            bwriter.flush();
            bwriter.close();
        }
        catch (IOException e) { e.printStackTrace(); }
    }

    void ReadText(String filename)
    {
        System.out.println("LOADING FROM TEXT");
        try {
            objects.clear();
            BufferedReader breader = new BufferedReader(new InputStreamReader(new FileInputStream("text.txt"), "UTF-8"));
            String scount = breader.readLine();
            int count = Integer.parseInt(scount);
            System.out.println(Integer.toString(count));

            for (int i = 0; i < count; i++)
            {
                String name = breader.readLine();

                Class<?> clazz = Class.forName(name);
                Drawable o = (Drawable)clazz.newInstance();
                o.readText(breader);
                objects.add(o);
            }

            breader.close();
        }
        catch (Exception e) { e.printStackTrace(); }

    }

    void WriteBinary(String filename)
    {
        System.out.println("SAVING AS BINARY");

        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename));
            int count = objects.size();
            dos.writeInt(count);
            for (Drawable o : objects)
            {
                String name = o.getClass().getName();
                dos.writeInt(name.length());
                dos.writeChars(name);
                o.writeBinary(dos);
            }
            dos.close();
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    void ReadBinary(String filename)
    {
        System.out.println("LOADING FROM BINARY");
        try {
            objects.clear();
            DataInputStream dis = new DataInputStream(new FileInputStream(filename));
            int count = dis.readInt();

            for (int i = 0; i < count; i++)
            {
                int nameLength = dis.readInt();
                StringBuilder sb  = new StringBuilder();
                for (int j = 0; j < nameLength; j++)
                    sb.append(dis.readChar());
                String name = sb.toString();

                Class<?> clazz = Class.forName(name);
                Drawable o = (Drawable)clazz.newInstance();
                o.readBinary(dis);
                objects.add(o);
            }
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    void Serialize(String filename)
    {
        System.out.println("SERIALIZING");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(objects);
            oos.flush();
            oos.close();
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    void Deserialize(String filename)
    {
        System.out.println("DESERIALIZING");
        try {
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(filename));
            objects = ( CopyOnWriteArrayList<Drawable>)oin.readObject();
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    void SerializeXML(String filename)
    {
        System.out.println("SERIALIZING TO XML");
        try {
            XStream x = new XStream(new DomDriver());
            x.toXML(objects, new FileOutputStream(new File(filename)));
        }
        catch (Exception e) { e.printStackTrace(); }

    }

    void DeserializeXML(String filename)
    {
        System.out.println("DESERIALIZING FROM XML");
        try {
            XStream x = new XStream(new DomDriver());
            objects = ( CopyOnWriteArrayList<Drawable>)x.fromXML(new File(filename));
        }
        catch (Exception e) { e.printStackTrace(); }
    }
    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_F1 ) { WriteText("text.txt"); }
        else if(code ==KeyEvent.VK_F2 ) { ReadText("text.txt"); }
        else if(code ==KeyEvent.VK_F3) { WriteBinary("bin.dat"); }
        else if(code ==KeyEvent.VK_F4) { ReadBinary("bin.dat"); }
        else if(code ==KeyEvent.VK_F5) { Serialize("ser.dat"); }
        else if(code ==KeyEvent.VK_F6) { Deserialize("ser.dat"); }
        else if(code ==KeyEvent.VK_F7) { SerializeXML("ser.xml"); }
        else if(code ==KeyEvent.VK_F8) { DeserializeXML("ser.xml"); }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer)
        {
            // System.out.println("UPDATE");
            Update();
        }
    }
}
