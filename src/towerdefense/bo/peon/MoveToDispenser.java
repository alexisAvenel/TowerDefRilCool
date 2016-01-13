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
        System.out.println("notify : " + countObservers());
        System.out.println(done);

        if(!done) {
            System.out.println("notifying");
            setChanged();
            notifyObservers(resourceDispenser);
            done = true;
        }
    }
}
