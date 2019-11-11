package tilegame.entity.create;

import jaco.mp3.player.MP3Player;
import tilegame.Config;
import tilegame.Handler;
import tilegame.gfx.Assets;
import tilegame.player.Player;
import tilegame.tiles.RoadTile;
import tilegame.tiles.Tile;
import tilegame.worlds.World;

import java.awt.*;
import java.sql.SQLOutput;


public abstract class Creature implements Update,Draw,Move{
    protected Handler handler;
    protected double spawX = Config.SPAWX, spawY = Config.SPAWY;
    protected int width, height;
    protected int health;
    protected double speed;
    protected double xMove, yMove;
    protected boolean active = true;
    protected int posX = 0,posY = 0;
    protected int index = 0;
    protected boolean live ;
    protected int price;


     static enum Direction{
        LEFT, RIGHT, UP, DOWN
    }
    public Direction dir;

    public Creature(Handler handler,int health,int price,double speed){
        this.handler = handler;
        this.width = Config.CREATURE_WIDTH;
        this.height = Config.CREATURE_HEIGHT;
        this.health = health;
        this.speed = speed;
        this.price = price;
        xMove = 0;
        yMove = 0;
        live = true;
    }


    public void checkmove() {

            if(index == World.len - 1){
                if(Player.hp>0) {
                    MP3Player mp3Player = new MP3Player(Config.heart);
                    mp3Player.play();
                }
                live = false;
                Player.hp -= 1;
                return;
            }


        if (World.point[index][0] == World.point[index + 1][0]) {
            // UP or DOWN;
            if (World.point[index + 1][1] > World.point[index][1]) {
                // di chuyen xuong
                if (spawY + speed < (World.point[index + 1][1]) * Config.TILE_HEIGHT) dir = Direction.DOWN;
                else {
                    dir = null;
                    index += 1;
                }
            } else {
                // di len
                if (spawY - speed > (World.point[index + 1][1]) * Config.TILE_HEIGHT) dir = Direction.UP;
                else {
                    dir = null;
                    index += 1;
                }
            }
        } else if (World.point[index][1] == World.point[index + 1][1]) {
            // Right or left
            if (World.point[index + 1][0] > World.point[index][0]) {
                // this -> right
                if (spawX + speed < (World.point[index + 1][0]) * Config.TILE_WIDTH) dir = Direction.RIGHT;
                else {
                    dir = null;
                    index += 1;
                }
            } else {
                // di len
                if (spawX - speed> (World.point[index + 1][0]) * Config.TILE_WIDTH) dir = Direction.LEFT;
                else {
                    dir = null;
                    index += 1;
                }
            }
        }
    }

    public void move(){
        if(dir == Direction.LEFT) {
            xMove = -speed;
            yMove = 0;
            this.setSpawX(spawX+xMove);
            this.setSpawY(spawY + yMove);
        }
        else if(dir == Direction.RIGHT)
           {
               xMove = speed;
               yMove = 0;
               this.setSpawX(spawX+xMove);
               this.setSpawY(spawY + yMove);
           }
        else if(dir == Direction.UP)
        {
            xMove = 0;
            yMove = -speed;
            this.setSpawX(spawX+xMove);
            this.setSpawY(spawY + yMove);
        }
        else if(dir == Direction.DOWN)
            {
                xMove = 0;
                yMove = speed;
                this.setSpawX(spawX+xMove);
                this.setSpawY(spawY + yMove);
            }


    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public double getSpawX() {
        return spawX;
    }

    public void setSpawX(double spawX) {
        this.spawX = spawX;
    }

    public double getSpawY() {
        return spawY;
    }

    public void setSpawY(double spawY) {
        this.spawY = spawY;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
