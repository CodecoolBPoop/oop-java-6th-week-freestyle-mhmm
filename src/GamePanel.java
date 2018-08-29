import GameObjects.Characters.Player;
import GameObjects.GameObject;
import map.Level;
import map.LevelOne;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GamePanel extends JPanel implements Runnable{

    private boolean isRunning = true;
    private Thread t;
    private static int characterPositionX;
    private static int characterPositionY;
    private Action upAction;
    private Action downAction;
    private Action leftAction;
    private Action rightAction;
    private final String IMG_DIR_PATH = System.getProperty("user.dir") + "/img";
    private GameObject[][] gameObjects;

    GamePanel()
    {
        setFocusable(true);
        upAction = new UpAction();
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

        t = new Thread(this);
        t.run();

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

    public void paintComponent(Graphics g) {
        //filling our 2d list
        Player player = new Player(1,1);
        Level levelOne = new LevelOne(player);
        gameObjects = ((LevelOne) levelOne).getLevel();

        //creating images
        BufferedImage playerImage = null;
        BufferedImage forestImage = null;
        BufferedImage lootImage = null;
        BufferedImage enemyImage = null;

        try  {
            playerImage  = ImageIO.read(new File(IMG_DIR_PATH + "/character.png"));
            forestImage  = ImageIO.read(new File(IMG_DIR_PATH + "/forest.png"));
            lootImage  = ImageIO.read(new File(IMG_DIR_PATH + "/loot.png"));
            enemyImage  = ImageIO.read(new File(IMG_DIR_PATH + "/enemy.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        super.paintComponent(g);

        //looping trough the 2d list and printing corresponding images
        for (int i= 0; i < gameObjects.length; i++) {
            for (int j= 0; j < gameObjects[i].length; j++) {
                switch (gameObjects[i][j].getType()) {
                    case FOREST:
                        g.drawImage(forestImage, i*50, j*50, 50, 50, null);
                        break;
                    case ENEMY:
                        g.drawImage(enemyImage, i*50, j*50, 50, 50, null);
                        break;
                    case PLAYER:
                        g.drawImage(playerImage, i*50, j*50, 50, 50, null);
                        loop();
                        break;
                    case LOOT:
                        g.drawImage(lootImage, i*50, j*50, 50, 50, null);
                        break;
                    default:
                        g.drawImage(lootImage, i*50, j*50, 50, 50, null);
                        break;
                }
            }
        }
    }

    //arrow controls
    static class UpAction extends AbstractAction
    {
        public void actionPerformed(ActionEvent e)
        {
            if (characterPositionY > 0) {
                characterPositionY -= 50;}
        }
    }

    static class DownAction extends AbstractAction
    {
        public void actionPerformed(ActionEvent e)
        {
            if (characterPositionY < 450) {
                characterPositionY += 50;}
        }
    }

    static class LeftAction extends AbstractAction
    {
        public void actionPerformed(ActionEvent e)
        {
            if (characterPositionX > 0) {
                characterPositionX -= 50;}        }
    }

    static class RightAction extends AbstractAction
    {
        public void actionPerformed(ActionEvent e)
        {
            if (characterPositionX < 450) {
                characterPositionX += 50;}
        }
    }
}