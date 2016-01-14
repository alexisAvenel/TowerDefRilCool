package towerdefense.manager;

import towerdefense.bo.Base;
import towerdefense.bo.Entity;
import towerdefense.bo.ResourceDispenser;
import towerdefense.bo.Tower;
import towerdefense.bo.enemies.Enemy;
import towerdefense.bo.enemies.EnemyManager;
import towerdefense.bo.peon.PeonManager;
import towerdefense.util.Functions;
import towerdefense.bo.peon.Peon;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {
    public static ArrayList<Entity> entities = new ArrayList<>();
    public static PeonManager peonManager = new PeonManager();
    public static EnemyManager enemyManger = new EnemyManager();
    public static ArrayList<Tower> towers = new ArrayList<>();
    public static ArrayList<Enemy> enemies = new ArrayList<>();

    public static ArrayList<Entity> getClone() {
        return (ArrayList<Entity>) entities.clone();
    }

    public static ArrayList<Entity> getTowers() {
        return (ArrayList<Entity>) towers.clone();
    }

    public static void init() {
        entities.add(new Base());

        entities.add(new ResourceDispenser());

        Peon p = peonManager.createPeon(((Base) entities.get(0)).getEntree());
        entities.add(p);
    }

    public static void addTower(Tower tower){
        entities.add(tower);
        towers.add(tower);
    }

    public static void entityManagement() {
        for(Entity entity: getClone()) {
            entity.update();
        }
    }

    public static Base getBase(){
        return ((Base) EntityManager.entities.get(0));
    }

    public static void addEnemy(Enemy enemy) {
        entities.add(enemy);
        enemies.add(enemy);
    }
}