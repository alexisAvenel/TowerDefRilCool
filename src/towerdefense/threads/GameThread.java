package towerdefense.threads;


import towerdefense.manager.EntityManager;
import towerdefense.manager.UIManager;

public class GameThread {
    public static void LaunchRepaintThread() {
        new Thread(()-> {
            while (true){
                Repaint();
            }
        }).start();

        new Thread(()-> {
            while (true){
                Manage();
            }
        }).start();
    }

    private static void Manage() {
        EntityManager.entityManagement();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void Repaint() {
        UIManager.getWindow().refreshBoard();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
