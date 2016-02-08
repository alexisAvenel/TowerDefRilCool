package towerdefense.threads;


import towerdefense.manager.EntityManager;
import towerdefense.manager.UIManager;
import towerdefense.util.Functions;

import javax.rmi.CORBA.Util;
import java.awt.*;

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

        new Thread(()-> {
            while (true){
                PopEnemy();
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

    private static void PopEnemy() {
        EntityManager.enemyManger.createEnemy(
                new Point(
                        -80,
                        Functions.randInt(
                                UIManager.getWindow().getBoard().getHeight()/2 - 70,
                                UIManager.getWindow().getBoard().getHeight()/2 - 20
                        )
                )
        );

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
