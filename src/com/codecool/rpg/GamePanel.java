package com.codecool.rpg;

import com.codecool.rpg.GameObjects.Characters.Player;
import com.codecool.rpg.GameObjects.GameObject;
import com.codecool.rpg.GameObjects.Items.Item;
import com.codecool.rpg.map.Level;
import com.codecool.rpg.map.LevelOne;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class GamePanel extends JPanel implements Runnable {

    private final String IMG_DIR_PATH = System.getProperty("user.dir") + "/img";
    private static final int FIELD_SIZE = 80;
    private final int STAT_SPACING = 50;
    private Player player = new Player(1, 1);
    private Level levelOne = new LevelOne(player);

    GamePanel() {
        setFocusable(true);
        Action upAction = new UpAction(player, levelOne);
        Action downAction = new DownAction(player, levelOne);
        Action leftAction = new LeftAction(player, levelOne);
        Action rightAction = new RightAction(player, levelOne);

        this.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upMotion");
        this.getActionMap().put("upMotion", upAction);

        this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downMotion");
        this.getActionMap().put("downMotion", downAction);

        this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftMotion");
        this.getActionMap().put("leftMotion", leftAction);

        this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightMotion");
        this.getActionMap().put("rightMotion", rightAction);

        Thread t = new Thread(this);
        t.run();
        createInventoryButton(this);
    }

    public void run() {
        loop();
    }

    private void loop() {
        boolean isRunning = true;
        if (isRunning) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    public void paintComponent(Graphics g) {

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

        //filling our 2d list
        GameObject[][] gameObjects = ((LevelOne) levelOne).getLevel();
        super.paintComponent(g);

        //looping trough the 2d list and printing corresponding images
        for (int i = 0; i < gameObjects.length; i++) {
            for (int j = 0; j < gameObjects[i].length; j++) {
                GameObject currentObject = gameObjects[i][j];

                switch (currentObject.getType()) {
                    case FOREST:
                        g.drawImage(forestImage, i * FIELD_SIZE, j * FIELD_SIZE, FIELD_SIZE, FIELD_SIZE, null);
                        break;
                    case ENEMY:
                        g.drawImage(enemyImage, i * FIELD_SIZE, j * FIELD_SIZE, FIELD_SIZE, FIELD_SIZE, null);
                        break;
                    case PLAYER:
                        g.drawImage(playerImage, currentObject.getX() * FIELD_SIZE, currentObject.getY() * FIELD_SIZE, FIELD_SIZE, FIELD_SIZE, null);
                        break;
                    case LOOT:
                        g.drawImage(lootImage, i * FIELD_SIZE, j * FIELD_SIZE, FIELD_SIZE, FIELD_SIZE, null);
                        break;
                    default:
                        g.drawImage(floorImage, i * FIELD_SIZE, j * FIELD_SIZE, FIELD_SIZE, FIELD_SIZE, null);
                        break;
                }
            }
        }
        loop();

        //printing stats to the game
        displayStats(g);

    }

    private void displayStats(Graphics g) {
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.drawString("HP: " + Integer.toString(player.getHitPoint()), 645, STAT_SPACING);
        g.drawString("DMG: " + player.damageToString(), 645, STAT_SPACING*2);
        g.drawString("STR: " + Integer.toString(player.getStrength()), 645, STAT_SPACING*3);
        g.drawString("DEX: " + Integer.toString(player.getAgility()), 645, STAT_SPACING*4);
        g.drawString("INT: " + Integer.toString(player.getIntelligence()), 645, STAT_SPACING*5);
        g.drawString("GOLD: " + Integer.toString(player.getGold()), 645, STAT_SPACING*6);
    }

    private void createInventoryButton(JPanel panel) {
        JButton inventoryButton = new JButton("Inventory");
        panel.setLayout(null);
        inventoryButton.setBounds(640, STAT_SPACING*7, 90, 30);
        panel.add(inventoryButton);
        inventoryButton.setRequestFocusEnabled(false);
        inventoryButton.addActionListener((event) -> {
                //creating inventory frame
                JFrame inventoryFrame = getInventoryFrame();

                //getting and printing the items
                JList<String> labels = getInventoryItems(inventoryFrame);

                //creating Equip button
                creatingEquipButton(inventoryFrame, labels);
        });
    }

    private void creatingEquipButton(JFrame inventoryFrame, JList<String> labels) {
        JButton equipButton = new JButton("Equip");
        equipButton.setSize(80, 30);
        equipButton.setVisible(true);
        inventoryFrame.add(equipButton, BorderLayout.SOUTH);
        equipButton.addActionListener(equipActionListener(labels));
    }

    private JList<String> getInventoryItems(JFrame inventoryFrame) {
        List<Item> items = player.getItems();
        JList<String> labels = createLabels(items);
        labels.setFont(new Font("TimesRoman", Font.BOLD, 20));
        labels.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        inventoryFrame.add(labels);
        return labels;
    }

    private JFrame getInventoryFrame() {
        JFrame inventoryFrame = new JFrame("Inventory");
        inventoryFrame.setLayout(new BorderLayout());
        inventoryFrame.setVisible(true);
        inventoryFrame.setSize(500,500);
        inventoryFrame.setLocationRelativeTo(null);
        return inventoryFrame;
    }

    private JList<String> createLabels(List<Item> items){
        DefaultListModel<String> itemList = new DefaultListModel<>();
        for (Item item: items) {
            itemList.addElement(item.getName());
        }
        return new JList<>(itemList);
    }

    private ActionListener equipActionListener(JList list) {
        return (event) ->{
                String itemName = (String) list.getSelectedValue();
                Item toEquip = player.getItemByName(itemName);
                player.equipItem(toEquip);
        };
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