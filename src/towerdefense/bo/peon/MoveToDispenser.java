package towerdefense.bo.peon;

import towerdefense.bo.ResourceDispenser;

/**
 * Created by FZAB on 13/01/2016.
 */
public class MoveToDispenser extends MoveTask{
    private ResourceDispenser resourceDispenser;

    public MoveToDispenser(Peon peon, ResourceDispenser resourceDispenser) {
        super(peon, resourceDispenser.getEntryPoint());

    }

    protected void task_notify() {
        if(!done) {
            setChanged();
            notifyObservers(resourceDispenser);
            done = true;
        }
    }
}
