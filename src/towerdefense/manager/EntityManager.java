package towerdefense.manager;

import towerdefense.bo.Base;
import towerdefense.bo.Entity;

import java.util.ArrayList;

public class EntityManager {
    public static ArrayList<Entity> entities = new ArrayList<>();

    public static ArrayList<Entity> getClone() {
        return (ArrayList<Entity>) entities.clone();
    }

    public static void init(){
        entities.add(new Base());
    }

    public static void entityManagement() {
        for(Entity entity: getClone()) {
            entity.update();
        }
    }
}