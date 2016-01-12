package towerdefense.view;

import towerdefense.manager.EntityManager;
import towerdefense.bo.Entity;

import javax.swing.*;
import java.awt.*;

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
        g2.setColor(Color.green);
        g2.fillRect(0, 0, getWidth(), getHeight());

        for(Entity entity : EntityManager.getClone()) {
            entity.draw(g2);
        }

    }
}
