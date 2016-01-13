package towerdefense.bo.peon;

import towerdefense.bo.Base;
import towerdefense.bo.ResourceDispenser;
import towerdefense.bo.Ressource;
import towerdefense.manager.EntityManager;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by FZAB on 13/01/2016.
 */
public class PeonManager implements Observer{
    private ArrayList<Peon> peons;

    public PeonManager() {
        peons = new ArrayList<>();
    }

    public ArrayList<Peon> getPeons() {
        return peons;
    }

    public Peon createPeon(Point p) {
        Peon peon = new Peon(p.x, p.y);
        peons.add(peon);

        MoveToDispenser dsp = new MoveToDispenser(peon, (ResourceDispenser) EntityManager.entities.get(1));
        dsp.addObserver(this);
        peon.setTask(dsp);

        return peon;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof MoveToDispenser) {

            ResourceDispenser r = (ResourceDispenser) arg;
            MoveToDispenser task = (MoveToDispenser) o;

            GatherTask g = new GatherTask(task.peon, r);
            g.addObserver(this);
            task.peon.setTask(g);
            return;
        }

        if(o instanceof MoveToBase) {
            MoveToBase task = (MoveToBase) o;
            EntityManager.getBase().addResource(task.peon.getRessource());
            task.peon.emptyRessource();


            MoveToDispenser dsp = new MoveToDispenser(task.peon, (ResourceDispenser) EntityManager.entities.get(1));
            dsp.addObserver(this);
            task.peon.setTask(dsp);
            return;
        }

        if(o instanceof GatherTask) {
            BaseTask task = (BaseTask) o;

            task.peon.setRessource(new Ressource("", 10));

            MoveToBase mv = new MoveToBase(((BaseTask) o).peon, EntityManager.getBase());
            mv.addObserver(this);

            ((BaseTask) o).peon.setTask(mv);
        }



    }
}
