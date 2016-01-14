package towerdefense.bo.peon;

import towerdefense.bo.Entity;
import towerdefense.bo.Ressource;
import towerdefense.util.Pair;
import towerdefense.util.Sprite;
import towerdefense.util.Functions;

import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;
import java.lang.*;

/**
 * Created by FZAB on 12/01/2016.
 */
public class Peon extends Entity {
    public static final int SIZE = 50;
    public static final float MAG_SPEED = 2;

    private ITask ITask;

    private Vector<java.lang.Double> speed;

    private Ressource ressource;

    private Sprite sprite;

    private ArrayList<Pair<Integer, Integer>> walkingSprites;
    private ArrayList<Pair<Integer, Integer>> gatheringSprites;
    private ArrayList<Pair<Integer, Integer>> actualSprites;
    private int spriteIndex = 0;
    private int spriteDirection = 0;
    private long timeStamp = 0 ;

    public Peon(int x, int y) {
        super(x, y, SIZE, SIZE);
        ressource = new Ressource("ressource", 0);

        speed = new Vector<>();
        speed.add((double) 0);
        speed.add((double) 0);

        sprite = new Sprite("peon_spritesheet.png", 50);

        walkingSprites = new ArrayList<>();
        gatheringSprites = new ArrayList<>();
        actualSprites = walkingSprites;

    }

    public Ressource getRessource() {
        return ressource;
    }

    public void setRessource(Ressource ressource) {
        this.ressource = ressource;
    }

    public void emptyRessource() {
        this.ressource.setQuantity(0);
    }

    public void setPosition(Point p) {
        x = p.x;
        y = p.y;
    }

    public Vector<java.lang.Double> getSpeed() {
        return this.speed;
    }

    public void setSpeed(double x, double y) {
        speed.set(0, x);
        speed.set(1, y);
    }

    public ITask getTask() {
        return ITask;
    }

    public void setTask(ITask ITask) {
        this.ITask = ITask;
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(sprite.getSprite(spriteIndex, spriteDirection), x, y, width, height, null);
    }

    @Override
    public void update() {
        if(ITask != null) {
            ITask.execute();
        }
    }

    public void setWalking(double angle) {

        long tmp = System.currentTimeMillis();
        if(tmp - timeStamp > 125) {
            timeStamp = tmp;
            spriteIndex = (spriteIndex+ 1) % 4;

            actualSprites = walkingSprites;

            double degAngle = Math.abs(Math.toDegrees(angle));
            if(Functions.isBetween(degAngle, 0, 45 ) || angle > 315) {
                spriteDirection = 2;
            } else if (Functions.isBetween(degAngle, 46, 135)){
                spriteDirection = 3;
            } else if (Functions.isBetween(degAngle, 136, 225)) {
                spriteDirection = 1;
            } else {
                spriteDirection = 0;
            }
        }
    }

    public void setGathering(double percent) {
        actualSprites = gatheringSprites;
        if(percent < 25) {
            spriteIndex = 4;
        } else if (percent < 50) {
            spriteIndex = 5;
        } else if (percent < 75) {
            spriteIndex = 6;
        } else {
            spriteIndex = 7;
        }
    }
}
