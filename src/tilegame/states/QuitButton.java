package tilegame.states;

import tilegame.Config;
import tilegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class QuitButton {
    private int spawX,spawY;
    private BufferedImage quit = Assets.quitButton;
    private int width,height;
    public QuitButton(){
        this.spawX = Config.QUITBUTTON_SPAWX;
        this.spawY = Config.QUITBUTTON_SPAWY;
        this.width = Config.QUITBUTTON_WIDTH;
        this.height = Config.QUITBUTTON_HEIGHT;
    }

    public int getSpawX() {
        return spawX;
    }

    public void setSpawX(int spawX) {
        this.spawX = spawX;
    }

    public int getSpawY() {
        return spawY;
    }

    public void setSpawY(int spawY) {
        this.spawY = spawY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public void render(Graphics g){
        g.drawImage(quit,spawX,spawY,width,height,null);
    }
}
