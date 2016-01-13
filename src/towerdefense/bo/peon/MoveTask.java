package towerdefense.bo.peon;

import java.awt.*;

/**
 * Created by FZAB on 13/01/2016.
 */
public class MoveTask extends BaseTask {
    //Atributes

    private Point target;

    //Constructors
    public MoveTask(Peon peon, Point target) {
        super(peon);
        this.target = target;
    }

    //Getters - Setters
    public Point getTarget() {
        return target;
    }

    public void setTarget(Point target) {
        this.target = target;
        setNewSpeed(target);
    }

    public Peon getPeon() {
        return peon;
    }

    public void setPeon(Peon peon) {
        this.peon = peon;
    }

    //Methods
    @Override
    public void execute() {
        if(target != null && !done) {
            setNewSpeed(target);
            if(peon.intersects(new Rectangle(target, new Dimension(peon.SIZE / 2, peon.SIZE / 2)))) {
                task_notify();
                return;
            }
            peon.setPosition( new Point((int) Math.round(peon.getX() + peon.getSpeed().get(0)),
                    (int) Math.round(peon.getY() + peon.getSpeed().get(1))));
        }
    }

    private void setNewSpeed(Point p) {
        double angle = Math.atan2(p.y - peon.getCenterY(), p.x - peon.getCenterX());
        peon.setSpeed( peon.MAG_SPEED * Math.cos(angle),  peon.MAG_SPEED * Math.sin(angle));
    }

    protected void task_notify() {
        if(! done) {
            System.out.println("done");
            notifyObservers();
            done = true;
        }
    }
}
