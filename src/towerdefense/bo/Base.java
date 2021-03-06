package towerdefense.bo;

import towerdefense.img.LogicalPath;
import towerdefense.manager.UIManager;
import towerdefense.util.Sprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Aurélien on 12/01/2016.
 */
public class Base extends Entity {
    private Point entree = new Point();
    private Point enemyEntry = new Point();
    private int x;
    private int y;
    public static final int SIZE = 150;
    private int stock;
    private int lifePoint;
    private BufferedImage img;

    public Base() {
        super(0,0,SIZE ,SIZE);
        x=(UIManager.getWindow().getBoard().getWidth()/2)+(SIZE/2);
        y=(UIManager.getWindow().getBoard().getHeight()/2)-(SIZE/2);

        entree.x= x+SIZE;
        entree.y= y+(SIZE/2);

        enemyEntry.x= x;
        enemyEntry.y= y+(SIZE/2);

        stock = 100;
        lifePoint = 100;

        img = new Sprite("chateau.png").getImg();
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(img, x, y, SIZE, SIZE, null);
    }

    @Override
    public void update() {

    }

    public void addResource(Ressource r){
        stock+=r.getQuantity();
    }

    public boolean removeRessource(Ressource r){
        if((stock - r.getQuantity()) >= 0){
            stock -= r.getQuantity();
            return true;
        }
        else {
            return false;
        }
    }

    public boolean removeLifePoint(int quantity){
        if((lifePoint - quantity) >= 0){
            lifePoint -= quantity;
            return true;
        }
        else {
            return false;
        }
    }

    public int getLifePoint() { return lifePoint; }

    public int getStock() {
        return stock;
    }

    public Point getEntree() {
        return entree;
    }

    public Point getEnemyEntry() {
        return enemyEntry;
    }

}
