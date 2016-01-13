package towerdefense.view;

import towerdefense.img.LogicalPath;
import towerdefense.manager.EntityManager;
import towerdefense.bo.Entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Alexis on 12/01/2016.
 */
public class Board extends JPanel {
    public Board() {
        super(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //g2.setColor(Color.green);
        //g2.fillRect(0, 0, getWidth(), getHeight());

        BufferedImage img = null;
        try {
            img = ImageIO.read(LogicalPath.class.getResource("bg_towerDef.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        g2.drawImage(img, 0,0, getWidth(), getHeight(), null);

        for(Entity entity : EntityManager.getClone()) {
            entity.draw(g2);
        }

    }
}
