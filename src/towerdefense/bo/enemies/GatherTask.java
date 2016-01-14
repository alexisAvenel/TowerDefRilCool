package towerdefense.bo.enemies;

/**
 * Created by Alexis on 13/01/2016.
 */
public class GatherTask extends BaseTask {
    public static final long timeToGather = 5000;
    private long startTime;

    public GatherTask(Enemy enemy) {
        super(enemy);
        startTime = -1;
        enemy.setGathering();
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
                notifyObservers(enemy);
                done = true;
            }
        }
    }
}
