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


public class GamePanel extends JPanel implements Runnable {

    private boolean isRunning = true;
    private Thread t;
    private static int characterPositionX = 1;
    private static int characterPositionY = 1;
    private Action upAction;
    private Action downAction;
    private Action leftAction;
    private Action rightAction;
    private final String IMG_DIR_PATH = System.getProperty("user.dir") + "/img";
    public GameObject[][] gameObjects;
    private Player player = new Player(1, 1);
    private Level levelOne = new LevelOne(player);

    GamePanel() {
        setFocusable(true);
        upAction = new UpAction(player, levelOne);
        downAction = new DownAction(player, levelOne);
        leftAction = new LeftAction(player, levelOne);
        rightAction = new RightAction(player, levelOne);

        this.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upMotion");
        this.getActionMap().put("upMotion", upAction);

        this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downMotion");
        this.getActionMap().put("downMotion", downAction);

        this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftMotion");
        this.getActionMap().put("leftMotion", leftAction);

        this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightMotion");
        this.getActionMap().put("rightMotion", rightAction);

        t = new Thread(this);
        t.run();

    }

    public void run() {
        loop();
    }

    private void loop() {
        if (isRunning) {
            Thread t = Thread.currentThread();
            try {
                t.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }

    }

    public void paintComponent(Graphics g) {
        //filling our 2d list

        gameObjects = ((LevelOne) levelOne).getLevel();

        //creating images
        BufferedImage playerImage = null;
        BufferedImage forestImage = null;
        BufferedImage lootImage = null;
        BufferedImage enemyImage = null;
        BufferedImage floorImage = null;

        try {
            playerImage = ImageIO.read(new File(IMG_DIR_PATH + "/character.png"));
            forestImage = ImageIO.read(new File(IMG_DIR_PATH + "/forest.png"));
            lootImage = ImageIO.read(new File(IMG_DIR_PATH + "/loot.png"));
            enemyImage = ImageIO.read(new File(IMG_DIR_PATH + "/enemy.png"));
            floorImage = ImageIO.read(new File(IMG_DIR_PATH + "/floor.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        super.paintComponent(g);

        //looping trough the 2d list and printing corresponding images
        for (int i = 0; i < gameObjects.length; i++) {
            for (int j = 0; j < gameObjects[i].length; j++) {
                GameObject currentObject = gameObjects[i][j];

                switch (currentObject.getType()) {
                    case FOREST:
                        g.drawImage(forestImage, i * 50, j * 50, 50, 50, null);
                        break;
                    case ENEMY:
                        g.drawImage(enemyImage, i * 50, j * 50, 50, 50, null);
                        break;
                    case PLAYER:
                        g.drawImage(playerImage, currentObject.getX() * 50, currentObject.getY() * 50, 50, 50, null);
                        break;
                    case LOOT:
                        g.drawImage(lootImage, i * 50, j * 50, 50, 50, null);
                        break;
                    default:
                        g.drawImage(floorImage, i * 50, j * 50, 50, 50, null);
                        break;
                }
            }
        }
        loop();
    }

    //arrow controls
    static class UpAction extends AbstractAction {
        Player player;
        Level level;

        UpAction(Player player, Level level) {
            this.player = player;
            this.level = level;
        }

        public void actionPerformed(ActionEvent e) {
            level.move(player.getX(), player.getY() - 1, player);
        }
    }

    static class DownAction extends AbstractAction {
        Player player;
        Level level;

        DownAction(Player player, Level level) {
            this.player = player;
            this.level = level;
        }

        public void actionPerformed(ActionEvent e) {
            level.move(player.getX(), player.getY() + 1, player);
        }
    }

    static class LeftAction extends AbstractAction {
        Player player;
        Level level;

        LeftAction(Player player, Level level) {
            this.player = player;
            this.level = level;
        }

        public void actionPerformed(ActionEvent e) {
            level.move(player.getX() - 1, player.getY(), player);
        }
    }

    static class RightAction extends AbstractAction {
        Player player;
        Level level;

        RightAction(Player player, Level level) {
            this.player = player;
            this.level = level;
        }

        public void actionPerformed(ActionEvent e) {
            level.move(player.getX() + 1, player.getY(), player);
        }
    }
}