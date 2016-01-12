package towerdefense.manager;

import towerdefense.bo.Entity;

import java.util.ArrayList;

public class EntityManager {
    private static ArrayList<Entity> entities = new ArrayList<>();

    public static ArrayList<Entity> getClone() {
        return (ArrayList<Entity>) entities.clone();
    }

    public static void entityManagement() {

    }
}