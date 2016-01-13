package towerdefense.bo;

import javafx.scene.control.Tooltip;
import towerdefense.manager.UIManager;

import java.awt.*;
import java.util.Random;

/**
 * Created by Alexis on 12/01/2016.
 */
public class ResourceDispenser extends Entity {

    private int x;
    private int y;
    private static int width = 40;
    private static int height = 40;
    private Point p = new Point();

    public ResourceDispenser() {

        super(0, 0, width, height);
        x = UIManager.getWindow().getBoard().getWidth()-80;
        y = UIManager.getWindow().getBoard().getHeight()/2 - height/2;
        p.setLocation(0, height/2);
    }

    @Override
    public void draw(Graphics2D g) {
        x = UIManager.getWindow().getBoard().getWidth()-80;
        y = UIManager.getWindow().getBoard().getHeight()/2 - height/2;
        g.setColor(Color.orange);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void update() {

    }

    public Point getP() {
        return p;
    }
}
