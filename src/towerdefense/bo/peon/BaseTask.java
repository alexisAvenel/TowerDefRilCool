package towerdefense.bo.peon;

import java.util.Observable;

/**
 * Created by FZAB on 13/01/2016.
 */
public abstract class BaseTask extends Observable implements ITask {
    protected Peon peon;
    protected boolean done;

    public BaseTask(Peon peon) {
        this.peon = peon;
        done = false;
    }

    @Override
    public abstract void execute();
}
