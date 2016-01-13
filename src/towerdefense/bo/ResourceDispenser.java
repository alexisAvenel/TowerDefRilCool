package towerdefense.bo;

import towerdefense.img.LogicalPath;
import towerdefense.manager.UIManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceDispenser extends Entity {

    private static final int width = 60;
    private static final int height = 60;
    private static final int x = UIManager.getWindow().getBoard().getWidth() - width - 40;
    private static final int y = UIManager.getWindow().getBoard().getHeight()/2 - height/2;
    private Point p = new Point();
    private BufferedImage img;

    public ResourceDispenser() {
        super(x, y, width, height);
        p.x = x;
        p.y = y+(height/2);
        try {
            img = ImageIO.read(LogicalPath.class.getResource("ressource.png"));
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

    public Point getEntryPoint() {
        return p;
    }
}
