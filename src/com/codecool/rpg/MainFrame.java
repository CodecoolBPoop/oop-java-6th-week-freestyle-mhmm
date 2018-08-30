package com.codecool.rpg;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainFrame{

    JFrame frame = new JFrame("Adventures of Punk Rock Stickman");
    GamePanel gamepanel = new GamePanel();

    public MainFrame()
    {
        gamepanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(740,1080);
        frame.setLocationRelativeTo(null);
        frame.add(gamepanel);
        gamepanel.requestFocusInWindow();
        gamepanel.createButtons(frame, gamepanel);
    }
    public static void main(String[] args)
    {
        new MainFrame();
    }


}