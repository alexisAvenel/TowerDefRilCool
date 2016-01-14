package towerdefense.util;

import towerdefense.img.LogicalPath;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

    private BufferedImage img;
    private int tile_width;
    private int tile_height;

    public Sprite(String file){
        try {
            img = ImageIO.read(LogicalPath.class.getResource(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public Sprite(String file, int t_size) {
        loadSprite(file);
        tile_width=t_size;
        tile_height=t_size;
    }
    public Sprite(String file, int width, int height) {
        loadSprite(file);
        tile_width=width;
        tile_height=height;
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
        return img.getSubimage(xGrid * tile_width, yGrid * tile_height, tile_width, tile_height);
    }

    public BufferedImage getImg() {
        return img;
    }
}