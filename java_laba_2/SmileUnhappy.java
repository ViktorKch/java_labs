
package java_laba_2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class SmileUnhappy extends Drawable implements Serializable {

    public SmileUnhappy() { color = Color.RED;}
    float cY = 0;
    float x = 0.0f;
    @Override
    public void Draw(Graphics2D g, float t)
    {
        Graphics2D g2d = g;

        animH = rectHeight;
        animW = rectWidth;
        x += t;
        g2d.setTransform(AffineTransform.getRotateInstance(x,centerX,centerY));

        g2d.fillOval((int)rectX1(), (int)rectY1(), (int)rectWidth, (int)rectHeight);

        Color c = (Color)g2d.getPaint();
        g2d.setPaint(Color.BLACK);

        float margin = 0.2f;
        // рот
        g2d.drawArc((int)(rectX1()+ rectWidth*margin), (int)(centerY+ rectHeight*margin),
                (int)(rectWidth*(1.0f-2*margin)), (int)(rectHeight*(1.0f-2*margin)/2), 30, 120);

        // глаза
        g2d.drawLine((int)(rectX1()+ 1.5*rectWidth*margin),
                (int)(rectY1()+ rectHeight*margin),
                (int)(rectX1()+ 1.5*rectWidth*margin),
                (int)(rectY1()+ 2*rectHeight*margin));
        g2d.drawLine((int)(rectX1()+ rectWidth *(1-1.5*margin)) ,
                (int)(rectY1()+ rectHeight*margin),
                (int)(rectX1()+ rectWidth *(1-1.5*margin)),
                (int)(rectY1()+ 2*rectHeight*margin));
        g2d.setPaint(c);

    }


    @Override
    void writeText(BufferedWriter bwriter) throws IOException {
        bwriter.write(Float.toString(x) + '\n');
        bwriter.write(Float.toString(centerX)+ '\n');
        bwriter.write(Float.toString(centerY)+ '\n');
    }


    @Override
    void readText(BufferedReader breader) throws IOException {

        String str_x = breader.readLine();
        String str_centerX = breader.readLine();
        String str_centerY = breader.readLine();
        x = Float.parseFloat(str_x);
        centerX = Float.parseFloat(str_centerX);
        centerY = Float.parseFloat(str_centerY);
    }

    @Override
    void writeBinary(DataOutputStream dos) throws IOException {
        dos.writeFloat(x);
        dos.writeFloat(centerX);
        dos.writeFloat(centerY);
    }

    @Override
    void readBinary(DataInputStream dis) throws IOException {
        x = dis.readFloat();
        centerX = dis.readFloat();
        centerY = dis.readFloat();
    }

}
