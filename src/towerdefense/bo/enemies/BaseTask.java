package towerdefense.bo.enemies;

import java.util.Observable;

/**
 * Created by Alexis on 13/01/2016.
 */
public abstract class BaseTask extends Observable implements ITask {
    protected Enemy enemy;
    protected boolean done;

    public BaseTask(Enemy enemy) {
        this.enemy = enemy;
        done = false;
    }

    @Override
    public abstract void execute();
}
