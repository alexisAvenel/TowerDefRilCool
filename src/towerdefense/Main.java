package towerdefense;

import towerdefense.manager.EntityManager;
import towerdefense.manager.UIManager;
import towerdefense.threads.GameThread;


public class Main {

    public static void main(String[] args) {
        EntityManager.init();

        UIManager.getWindow();
        GameThread.LaunchRepaintThread();
    }
}
