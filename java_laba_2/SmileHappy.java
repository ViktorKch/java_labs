
package java_laba_2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class SmileHappy extends Drawable{
    
    public SmileHappy() { color = Color.YELLOW;}
    
    @Override
    public void Draw(Graphics g) 
    {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.fillOval((int)rectX1(), (int)rectY1(), (int)rectWidth, (int)rectHeight);
        
        Color c = (Color)g2d.getPaint();
        g2d.setPaint(Color.BLACK);
        
        float margin = 0.2f;
        // рот
        g2d.drawArc((int)(rectX1()+ rectWidth*margin), (int)(rectY1()+ rectHeight*margin), 
                (int)(rectWidth*(1.0f-2*margin)), (int)(rectHeight*(1.0f-2*margin)), 180, 180);
        
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
  

}
