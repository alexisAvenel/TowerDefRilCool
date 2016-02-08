package towerdefense.bo.enemies;

import towerdefense.bo.Base;
import towerdefense.bo.ResourceDispenser;
import towerdefense.bo.Ressource;
import towerdefense.bo.peon.*;
import towerdefense.bo.peon.BaseTask;
import towerdefense.manager.EntityManager;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Alexis on 13/01/2016.
 */
public class EnemyManager implements Observer {
    private ArrayList<Enemy> enemies;

    public EnemyManager() {
        enemies = new ArrayList<>();
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public Enemy createEnemy(Point p) {
        Enemy enemy = new Enemy(p.x, p.y);
        enemies.add(enemy);
        if(enemies.size() <= 1) {
            EntityManager.addEnemy(enemy);
        }
        MoveToBase base = new MoveToBase(enemy, EntityManager.getBase());
        base.addObserver(this);
        enemy.setTask(base);

        return enemy;
    }

    @Override
    public void update(Observable o, Object arg) {

        if(o instanceof AttackBase) {
            System.out.println("Base détruite !");
            return;
        }

        if(o instanceof MoveToBase) {
            MoveToBase task = (MoveToBase) o;

            AttackBase ab = new AttackBase(task.enemy, (Base) arg);
            ab.addObserver(this);
            task.enemy.setTask(ab);

            return;
        }

    }
}
