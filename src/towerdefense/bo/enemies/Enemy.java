package towerdefense.bo.enemies;

import towerdefense.bo.Entity;
import towerdefense.bo.enemies.ITask;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Alexis on 13/01/2016.
 */
public class Enemy  extends Entity {
    public static final int SIZE = 10;
    public static final float MAG_SPEED = 2;

    private towerdefense.bo.enemies.ITask ITask;

    private Vector<java.lang.Double> speed;

    public Enemy(int x, int y) {
        super(x, y, SIZE, SIZE);

        speed = new Vector<>();
        speed.add((double) 0);
        speed.add((double) 0);
    }

    public void setPosition(Point p) {
        x = p.x;
        y = p.y;
    }

    public Vector<java.lang.Double> getSpeed() {
        return this.speed;
    }

    public void setSpeed(double x, double y) {
        speed.set(0, x);
        speed.set(1, y);
    }

    public ITask getTask() {
        return ITask;
    }

    public void setTask(ITask ITask) {
        this.ITask = ITask;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
        g.setColor(Color.blue);
        String pos = new String(x + " - " + y );

        g.drawString(pos, (int) getCenterX(), (int) getCenterY() );
    }

    @Override
    public void update() {
        if(ITask != null) {
            ITask.execute();
        }
    }

    public void setWalking() {

    }

    public void setGathering() {

    }

}
