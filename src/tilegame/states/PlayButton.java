package tilegame.states;

import tilegame.Config;
import tilegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayButton {
    private int spawX,spawY;
    private BufferedImage play = Assets.playButton;
    private int width,height;
    public PlayButton(){
        this.spawX = Config.PLAYBUTTON_SPAWX;
        this.spawY = Config.PLAYBUTTON_SPAWY;
        this.width = Config.PLAYBUTTON_WIDTH;
        this.height = Config.PLAYBUTTON_HEIGHT;
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
        g.drawImage(play,spawX,spawY,width,height,null);
    }
}
