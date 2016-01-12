package towerdefense.manager;

import towerdefense.bo.Base;
import towerdefense.bo.Entity;

import java.util.ArrayList;

public class EntityManager {
    private static ArrayList<Entity> entities = new ArrayList<>();

    public static ArrayList<Entity> getClone() {
        return (ArrayList<Entity>) entities.clone();
    }

    public static void init(){
        entities.add(new Base((UIManager.getWindow().getBoard().getWidth()/2)+100,(UIManager.getWindow().getBoard().getHeight()/2)-50, 100, 100));

    }

    public static void entityManagement() {
        for(Entity entity: getClone()) {
            entity.update();
        }
    }
}