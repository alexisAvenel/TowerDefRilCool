package towerdefense.bo.enemies;

import java.awt.*;

/**
 * Created by Alexis on 13/01/2016.
 */
public class MoveTask  extends BaseTask {
    //Atributes

    private Point target;

    //Constructors
    public MoveTask(Enemy enemy, Point target) {
        super(enemy);
        this.target = target;
    }

    //Getters - Setters
    public Point getTarget() {
        return target;
    }

    public void setTarget(Point target) {
        this.target = target;
        setNewSpeed(target);
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    //Methods
    @Override
    public void execute() {
        if(target != null && !done){
            setNewSpeed(target);
            double d = new Point((int) enemy.getCenterX(), (int) enemy.getCenterY()).distance(target.getX(), target.getY());
            if(d < enemy.width / 4) {
                task_notify();
                return;
            }
            enemy.setPosition( new Point((int) Math.round(enemy.getX() + enemy.getSpeed().get(0)),
                    (int) Math.round(enemy.getY() + enemy.getSpeed().get(1))));
        }
    }

    private void setNewSpeed(Point p) {
        double angle = Math.atan2(p.y - enemy.getCenterY(), p.x - enemy.getCenterX());
        enemy.setSpeed( enemy.MAG_SPEED * Math.cos(angle),  enemy.MAG_SPEED * Math.sin(angle));
        enemy.setWalking(angle);
    }

    protected void task_notify() {
        if(! done) {
            setChanged();
            notifyObservers();
            done = true;
        }
    }
}
