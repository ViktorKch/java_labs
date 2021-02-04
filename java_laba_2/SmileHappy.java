
package java_laba_2;

import java.awt.Color;
import java.awt.Graphics2D;

public class SmileHappy extends Drawable{

    public SmileHappy() { color = Color.YELLOW;}

    @Override
    public void Draw(Graphics2D g, float t)
    {
        Graphics2D g2d =  g;
        x+=t;
        animH = Math.round(rectHeight*( 1.f - 0.5f*Math.sin(x)));
        animW = Math.round(rectHeight*( 1.f - 0.5f*Math.sin(x)));
        g2d.fillOval((int)rectX1(), (int)(rectY1()), (int)animW, (int)animH);
        Color c = (Color)g2d.getPaint();
        g2d.setPaint(Color.BLACK);
        float margin = 0.2f;
        // рот
        g2d.drawArc((int)(rectX1()+ animW*margin), (int)(rectY1()+ animH*margin),
                (int)(animW*(1.0f-2*margin)), (int)(animH*(1.0f-2*margin)), 180, 180);
        // глаза
        g2d.drawLine((int)(rectX1()+ 1.5*animW*margin),
                (int)(rectY1()+ animH*margin),
                (int)(rectX1()+ 1.5*animW*margin),
                (int)(rectY1()+ 2*animH*margin));
        g2d.drawLine((int)(rectX1()+ animW *(1-1.5*margin)) ,
                (int)(rectY1()+ animH*margin),
                (int)(rectX1()+ animW *(1-1.5*margin)),
                (int)(rectY1()+ 2*animH*margin));
        g2d.setPaint(c);


    }

    float cY = 0;
    float x = 0.0f;
}
