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
        Player player = new Player();
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

        //looping trough list and printing corresponding images
        for (GameObject [] row: gameObjects) {
            for (GameObject gameObject: row) {
                switch (gameObject.getType()) {
                    case PLAYER: {
                        characterPositionX = gameObject.getX();
                        characterPositionY = gameObject.getY();
                        super.paintComponent(g);
                        g.drawImage(playerImage, characterPositionX, characterPositionY, 50, 50, null);
                        loop();
                    }
                    case FOREST: {
                        super.paintComponent(g);
                        g.drawImage(forestImage, gameObject.getX(), gameObject.getY(), 50, 50, null);
                        loop();
                    }
                    case LOOT: {
                        super.paintComponent(g);
                        g.drawImage(lootImage, gameObject.getX(), gameObject.getY(), 50, 50, null);
                        loop();
                    }
                    case ENEMY: {
                        super.paintComponent(g);
                        g.drawImage(enemyImage, gameObject.getX(), gameObject.getY(), 50, 50, null);
                        loop();
                    }
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