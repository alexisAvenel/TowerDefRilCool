package towerdefense.bo;

import towerdefense.img.LogicalPath;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by romain on 12/01/16.
 */
public class Tower extends Entity {

    public static final int cost = 60;
    private BufferedImage img;

    public Tower(int x, int y, int width, int height) {
        super(x, y, width, height);
        try {
            img = ImageIO.read(LogicalPath.class.getResource("tower.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(img, x, y, width, height, null);
    }

    @Override
    public void update() {

    }


}
