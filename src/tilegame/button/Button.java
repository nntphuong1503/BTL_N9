package tilegame.button;

import tilegame.Config;
import tilegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Button {
    private int spawX, spawY,id;
    private Button[] button = new Button[10];
    private BufferedImage texture;
    public Button(BufferedImage texture, int spawX, int spawY, int id){
        this.texture = texture;
        this.spawX = spawX;
        this.spawY = spawY;
        this.id = id;
        button[id] = this;
    }
    public void render(Graphics g){
        g.drawImage(texture,spawX,spawY,Config.BUTTON_WIDTH,Config.CREATURE_HEIGHT,null);

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
