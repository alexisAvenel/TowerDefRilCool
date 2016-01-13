package towerdefense.bo.peon;

import towerdefense.bo.Base;

/**
 * Created by FZAB on 13/01/2016.
 */
public class MoveToBase extends MoveTask{
    private Base base;

    public MoveToBase(Peon peon, Base base) {
        super(peon, base.getEntree());

    }

    protected void task_notify() {
        if(!done) {
            setChanged();
            notifyObservers(base);
            done = true;
        }
    }
}
