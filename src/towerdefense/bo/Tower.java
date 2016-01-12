package towerdefense.bo;

import java.awt.*;

/**
 * Created by romain on 12/01/16.
 */
public class Tower extends Entity {



    public Tower(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.black);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void update() {

    }
}
