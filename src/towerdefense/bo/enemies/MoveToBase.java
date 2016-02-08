package towerdefense.bo.enemies;

import towerdefense.bo.Base;

/**
 * Created by Alexis on 13/01/2016.
 */
public class MoveToBase  extends MoveTask {
    private Base base;

    public MoveToBase(Enemy enemy, Base base) {
        super(enemy, base.getEnemyEntry());
        this.base = base;
    }

    protected void task_notify() {
        if(!done) {
            setChanged();
            notifyObservers(base);
            done = true;
        }
    }
}
