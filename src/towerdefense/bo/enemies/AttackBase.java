package towerdefense.bo.enemies;

import towerdefense.bo.Base;

/**
 * Created by Alexis on 14/01/2016.
 */
public class AttackBase extends AttackTask {

    public static final long timeToGather = 5000;
    private long startTime;
    private Base base;

    public AttackBase(Enemy enemy, Base base) {
        super(enemy, base.getEnemyEntry());
        this.base = base;
        startTime = -1;
    }

    @Override
    public void execute() {
        if(!done) {
            if(base.getLifePoint() == 0) {
                setChanged();
                notifyObservers(base);
            }
            else
            {
                if (startTime < 0) {
                    startTime = System.currentTimeMillis();
                }
                long elapsed = System.currentTimeMillis() - startTime;
                enemy.setAttacking(elapsed);

                if (elapsed >= timeToGather) {
                    enemy.attackBase(base);
                    startTime = -1;
                }
            }
        }
    }

    protected void task_notify() {
        if(!done) {
            setChanged();
            notifyObservers(base);
            done = true;
        }
    }
}
