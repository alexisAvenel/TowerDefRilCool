package towerdefense.util;

import towerdefense.img.LogicalPath;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

    private BufferedImage img;
    private int tile_size;

    public Sprite(String file){
        try {
            img = ImageIO.read(LogicalPath.class.getResource(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public Sprite(String file, int t_size) {
        loadSprite(file);
        tile_size=t_size;
    }

    public BufferedImage loadSprite(String file) {

        try {
            img = ImageIO.read(LogicalPath.class.getResource(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return img;
    }

    public BufferedImage getSprite(int xGrid, int yGrid) {
        return img.getSubimage(xGrid * tile_size, yGrid * tile_size, tile_size, tile_size);
    }

    public BufferedImage getImg() {
        return img;
    }
}