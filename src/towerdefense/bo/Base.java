package towerdefense.bo;

import towerdefense.manager.UIManager;

import java.awt.*;

/**
 * Created by Aurélien on 12/01/2016.
 */
public class Base extends Entity {
    private int entreeX;
    private int entreeY;
    private int stock;
    public Base(int x, int y, int width, int height) {
        super(x, y, width, height);
        entreeX= x+width;
        entreeY=y+(height/2);
        stock = 100;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void update() {

    }

    public void addResource(Ressource r){
        stock+=r.getQuantity();
    }

    public void removeRessource(Ressource r){
        if((stock - r.getQuantity()) >= 0){
            stock -= r.getQuantity();
        }
    }

    public int getEntreeX() {
        return entreeX;
    }

    public int getEntreeY() {
        return entreeY;
    }

    public int getStock() {
        return stock;
    }
}
