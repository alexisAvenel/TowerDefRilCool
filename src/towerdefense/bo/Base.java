package towerdefense.bo;

import towerdefense.manager.UIManager;

import java.awt.*;

/**
 * Created by Aurélien on 12/01/2016.
 */
public class Base extends Entity {
    private int entreeX;
    private int entreeY;

    private int x;
    private int y;

    private static final int SIZE = 100;

    private int stock;
    public Base() {
        super(0,0,SIZE ,SIZE);
        x=(UIManager.getWindow().getBoard().getWidth()/2)+SIZE;
        y=(UIManager.getWindow().getBoard().getHeight()/2)-(SIZE/2);
        entreeX= x+SIZE;
        entreeY=y+(SIZE/2);
        stock = 100;
    }

    @Override
    public void draw(Graphics2D g) {
        x=(UIManager.getWindow().getBoard().getWidth()/2)+SIZE;
        y=(UIManager.getWindow().getBoard().getHeight()/2)-(SIZE/2);
        g.setColor(Color.blue);
        g.fillRect(x, y, SIZE, SIZE);
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
