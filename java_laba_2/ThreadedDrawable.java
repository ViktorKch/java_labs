package java_laba_2;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class ThreadedDrawable extends Thread {


    private Drawable _d;
    float dt;
    private BufferedImage img;
    public ThreadedDrawable(Drawable d, float delta)
    {
        super();
        _d = d;
        dt = delta;
    }
    public void paint()
    {

        BufferedImage out = new BufferedImage(800,600,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = out.createGraphics();
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHints(rh);
        g.setPaint(_d.color);
        _d.Draw(g, dt);
        _d.DrawRect(g);

        img = out;

    }

    @Override
    public void run() {
        paint();

    }

    public BufferedImage get()
    {
        return img;
    }
}
