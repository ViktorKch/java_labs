
package java_laba_2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Surface extends javax.swing.JPanel implements MouseListener {

    private ArrayList<Drawable> objects = new ArrayList<>();
    public long timestep = 1000/60;
    private long prev_t = 0;

    void DrawObjects(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        long t = System.currentTimeMillis();
        while (t-prev_t < timestep) t = System.currentTimeMillis();

        float dt = (float)(t-prev_t)/1000.f;
        for (Drawable o : objects)
        {
            ThreadedDrawable td = new ThreadedDrawable(o,dt);
            td.start();
            try { td.join(); } catch(Exception ex) {}
            g2d.drawImage(td.get(), 0, 0, null);
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

        int x = e.getX() - 10;
        int y = e.getY() - 40;

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

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}
