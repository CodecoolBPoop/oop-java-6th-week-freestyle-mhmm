import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GamePanel extends JPanel implements Runnable{

    boolean isRunning = true;
    Thread t;
    static int rectX = 250;
    static int rectY = 250;
    Action upAction;
    Action downAction;
    Action leftAction;
    Action rightAction;

    public GamePanel()
    {
        setFocusable(true);
        upAction = new UpAction();
        t = new Thread(this);
        t.run();
        downAction = new DownAction();
        leftAction = new LeftAction();
        rightAction = new RightAction();

        this.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upMotion");
        this.getActionMap().put("upMotion",upAction);

        this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downMotion");
        this.getActionMap().put("downMotion",downAction);

        this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftMotion");
        this.getActionMap().put("leftMotion", leftAction);

        this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightMotion");
        this.getActionMap().put("rightMotion",rightAction);

    }
    public void run()
    {
        loop();
    }
    public void loop()
    {
        if(isRunning)
        {
            Thread t = Thread.currentThread();
            try
            {
                t.sleep(5);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            repaint();
        }

    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawRect(rectX, rectY, 50, 50);
        loop();
    }
    static class UpAction extends AbstractAction
    {
        public void actionPerformed(ActionEvent e)
        {
            rectY -= 50;
        }
    }

    static class DownAction extends AbstractAction
    {
        public void actionPerformed(ActionEvent e)
        {
            rectY += 50;
        }
    }

    static class LeftAction extends AbstractAction
    {
        public void actionPerformed(ActionEvent e)
        {
            rectX -= 50;
        }
    }

    static class RightAction extends AbstractAction
    {
        public void actionPerformed(ActionEvent e)
        {
            rectX += 50;
        }
    }
}