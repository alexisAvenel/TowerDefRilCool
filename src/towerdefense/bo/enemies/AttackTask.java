package towerdefense.bo.enemies;

import towerdefense.manager.EntityManager;

import java.awt.*;

/**
 * Created by Alexis on 14/01/2016.
 */
public class AttackTask extends BaseTask {

    private Point target;

    public AttackTask(Enemy enemy, Point target) {
        super(enemy);
        this.target = target;
    }

    public Point getTarget() {
        return target;
    }

    public void setTarget(Point target) {
        this.target = target;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public void execute() {
        if(enemy != null && !done){
            // retirer point de vie à la base
            task_notify();
            return;
        }
    }

    protected void task_notify() {
        if(! done) {
            setChanged();
            notifyObservers();
            done = true;
        }
    }
}
