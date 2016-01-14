package towerdefense.bo;

import towerdefense.interfaces.IDrawable;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class Entity extends Rectangle implements IDrawable {
    public Entity(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public abstract void draw(Graphics2D g);

    public abstract void update();

    public void onClick(MouseEvent mouseEvent) {
        System.out.println(mouseEvent.toString());
    }
}
