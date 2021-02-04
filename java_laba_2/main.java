
package java_laba_2;

import java.awt.Dimension;
import javax.swing.JFrame;


public class main {

    public static void main(String []args){
        Surface s = new Surface();
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(new Dimension(800, 600));
        frame.add(s);
        frame.addMouseListener(s);
        frame.addKeyListener(s);
        frame.addWindowListener(new HelpListener());

        while (!s.isExit())
            s.Update();

    }
}
