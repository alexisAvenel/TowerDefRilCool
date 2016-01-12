package towerdefense.bo;

import java.awt.*;
import java.util.Random;

/**
 * Created by Alexis on 12/01/2016.
 */
public class ResourceDispenser extends Entity {

    private int quantity;
    private int entryPointX;
    private int entryPointY;

    public ResourceDispenser(int x, int y, int width, int height, int quantity) {
        super(x, y, width, height);
        this.quantity = quantity;
    }

    public ResourceDispenser(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.orange);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void update() {

    }
}
