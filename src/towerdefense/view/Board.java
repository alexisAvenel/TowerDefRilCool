package towerdefense.view;

import towerdefense.img.LogicalPath;
import towerdefense.manager.EntityManager;
import towerdefense.bo.Entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Alexis on 12/01/2016.
 */
public class Board extends JPanel {
    public Board() {
        super(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                for (Entity entity : EntityManager.entities) {

                    if (entity.contains(me.getPoint())) {//check if mouse is clicked within shape
                        entity.onClick(me);
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

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
