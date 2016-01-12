package towerdefense.manager;

import com.sun.org.apache.xpath.internal.SourceTree;
import towerdefense.bo.Base;
import towerdefense.bo.Entity;
import towerdefense.bo.ResourceDispenser;
import towerdefense.util.Functions;

import java.util.ArrayList;

public class EntityManager {
    private static ArrayList<Entity> entities = new ArrayList<>();

    public static ArrayList<Entity> getClone() {
        return (ArrayList<Entity>) entities.clone();
    }

    public static void init(){
        entities.add(new Base((UIManager.getWindow().getBoard().getWidth()/2)+100,(UIManager.getWindow().getBoard().getHeight()/2)-50, 100, 100));
        entities.add(new ResourceDispenser(
                UIManager.getWindow().getBoard().getWidth()-80,
                UIManager.getWindow().getBoard().getHeight()-100,
                50,
                50,
                Functions.randInt(1000, 3000))
        );
        System.out.println(UIManager.getWindow().getBoard().getWidth());
    }

    public static void entityManagement() {
        for(Entity entity: getClone()) {
            entity.update();
        }
    }
}