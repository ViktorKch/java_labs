
package java_laba_2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

abstract public class Drawable {

    public abstract void Draw(Graphics2D g, float t);

    public boolean isInside(float x, float y)
    {
        return (x > rectX1()) && (x < rectX1() + animW)
                && (y > rectY1()) && (y < rectY1() + animH);
    }

    public void DrawRect(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;


        int l = 10;
        Color c = (Color)g2d.getPaint();
        g2d.setPaint(Color.BLACK);

        g2d.drawLine((int)rectX1(), (int)rectY1(), (int)rectX1() + l, (int)rectY1());
        g2d.drawLine((int)rectX1(), (int)rectY1(), (int)rectX1(), (int)rectY1() + l);

        g2d.drawLine((int)rectX2(), (int)rectY1(), (int)rectX2() - l, (int)rectY1());
        g2d.drawLine((int)rectX2(), (int)rectY1(), (int)rectX2(), (int)rectY1() + l);

        g2d.drawLine((int)rectX1(), (int)rectY2(), (int)rectX1() + l, (int)rectY2());
        g2d.drawLine((int)rectX1(), (int)rectY2(), (int)rectX1(), (int)rectY2() - l);

        g2d.drawLine((int)rectX2(), (int)rectY2(), (int)rectX2() - l, (int)rectY2());
        g2d.drawLine((int)rectX2(), (int)rectY2(), (int)rectX2(), (int)rectY2() - l);



        g2d.setPaint(c);
    }

    // исходные положение и размеры
    protected float centerX = 50, centerY = 50;

    protected float rectWidth = 50, rectHeight = 50;
    // анимированинные положение и размеры
    protected float animW, animH, animCX, animCY;

    public float rectX1() { return centerX - animW/2;}
    public float rectY1() { return centerY - animH/2;}
    public float rectX2() { return centerX + animW/2;}
    public float rectY2() { return centerY + animH/2;}



    protected Color color = Color.RED;

}
