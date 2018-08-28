import javax.swing.*;

public class MainFrame{

    JFrame frame = new JFrame("Adventures of Punk Rock Stickman");
    GamePanel gamepanel = new GamePanel();

    public MainFrame()
    {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.add(gamepanel);
        gamepanel.requestFocusInWindow();
    }
    public static void main(String[] args)
    {
        new MainFrame();
    }


}