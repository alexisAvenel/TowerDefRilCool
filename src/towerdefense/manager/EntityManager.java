package towerdefense.manager;

import com.sun.org.apache.xpath.internal.SourceTree;
import towerdefense.bo.Base;
import towerdefense.bo.Entity;
import towerdefense.bo.ResourceDispenser;
import towerdefense.util.Functions;

import java.util.ArrayList;

public class EntityManager {
    public static ArrayList<Entity> entities = new ArrayList<>();

    public static ArrayList<Entity> getClone() {
        return (ArrayList<Entity>) entities.clone();
    }

    public static void init(){
        entities.add(new Base());
        entities.add(new ResourceDispenser(
                UIManager.getWindow().getBoard().getWidth()-80,
                UIManager.getWindow().getBoard().getHeight()-100,
                50,
                50,
                Functions.randInt(1000, 3000))
        );
    }

    public static void entityManagement() {
        for(Entity entity: getClone()) {
            entity.update();
        }
    }
}