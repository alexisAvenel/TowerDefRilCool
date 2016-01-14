package towerdefense.bo.enemies;

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
        EntityManager.addEnemy(enemy);
        MoveToBase base = new MoveToBase(enemy, EntityManager.getBase());
        base.addObserver(this);
        enemy.setTask(base);

        return enemy;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
