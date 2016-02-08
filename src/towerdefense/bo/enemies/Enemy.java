package towerdefense.bo.enemies;

import towerdefense.bo.Base;
import towerdefense.bo.Entity;
import towerdefense.util.Functions;
import towerdefense.util.Pair;
import towerdefense.util.Sprite;

import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Alexis on 13/01/2016.
 */
public class Enemy  extends Entity {
    public static final int WIDTH = 70;
    public static final int HEIGHT = 70;
    private int spriteW;
    private int spriteH;
    public static final float MAG_SPEED = 2;
    public static final int ATTACK_POINT = 10;
    private ITask ITask;
    private Vector<java.lang.Double> speed;
    private Sprite sprite;

    private ArrayList<Pair<Integer, Integer>> walkingSprites;
    private ArrayList<Pair<Integer, Integer>> attackingSprites;
    private ArrayList<Pair<Integer, Integer>> actualSprites;
    private int spriteIndex = 0;
    private int spriteDirection = 0;
    private long timeStamp = 0 ;

    public Enemy(int x, int y) {
        super(x, y, WIDTH, HEIGHT);

        speed = new Vector<>();
        speed.add((double) 0);
        speed.add((double) 0);

        spriteW = 76;
        spriteH = 60;

        sprite = new Sprite("enemy_spritesheet.png", spriteW, spriteH);
        walkingSprites = new ArrayList<>();
        attackingSprites = new ArrayList<>();
        actualSprites = walkingSprites;
    }

    public void setPosition(Point p) {
        x = p.x;
        y = p.y;
    }

    public Point getPosition() { return new Point(x, y); }

    public int getAttackBasePoint() { return ATTACK_POINT; }

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
        g.drawImage(sprite.getSprite(spriteDirection,spriteIndex), x, y, width, height, null);
    }

    @Override
    public void update() {
        if(ITask != null) {
            ITask.execute();
        }
    }

    public void setWalking(double angle) {
        setSpriteH(59);
        long tmp = System.currentTimeMillis();
        if(tmp - timeStamp > 125) {
            timeStamp = tmp;
            spriteIndex = (spriteIndex+ 1) % 5;

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

    public void attackBase(Base base) {
        base.removeLifePoint(ATTACK_POINT);
    }

    public void setAttacking(long elapsed) {
        actualSprites = attackingSprites;
        elapsed = elapsed % 500;
        if(elapsed < 125) {
            spriteIndex = 5;
        } else if (elapsed < 250) {
            spriteIndex = 6;
        } else if (elapsed < 375) {;
            spriteIndex = 7;
        } else {
            spriteIndex = 8;
        }
    }

    public void setSpriteH(int spriteH) {
        this.spriteH = spriteH;
    }
}
