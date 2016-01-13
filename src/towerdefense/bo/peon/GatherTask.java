package towerdefense.bo.peon;

import towerdefense.bo.ResourceDispenser;

/**
 * Created by FZAB on 13/01/2016.
 */
public class GatherTask extends BaseTask {
    public static final long timeToGather = 5000;
    private ResourceDispenser resourceDispenser;

    private long startTime;

    public GatherTask(Peon peon, ResourceDispenser resourceDispenser) {
        super(peon);
        startTime = -1;
        this.resourceDispenser = resourceDispenser;
        peon.setGathering();
    }

    @Override
    public void execute() {
        if(!done) {
            if (startTime < 0) {
                startTime = System.currentTimeMillis();
            }
            long elapsed = System.currentTimeMillis() - startTime;

            if (elapsed >= timeToGather) {
                setChanged();
                notifyObservers(resourceDispenser);
                done = true;
            }
        }
    }
}
