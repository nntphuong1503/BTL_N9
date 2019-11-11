package tilegame.bullet;

import jaco.mp3.player.MP3Player;
import tilegame.Config;
import tilegame.entity.create.Enemy;
import tilegame.entity.create.Wave;
import tilegame.entity.create.WaveManager;
import tilegame.gfx.Assets;
import tilegame.player.Player;
import tilegame.worlds.World;

import java.awt.*;
import java.awt.image.BufferedImage;

//import tilegame.states.PlayButton;
//import tilegame.tower.Tower;

public class Bullet {
    private  int x, y;
    private int spawX, spawY;
    private int damage;
  //  private double angle;
    private Enemy target;
    private final int speed = Config.BULLET_SPEED;
    private double xMove, yMove;
    private boolean isDraw = true;
    private WaveManager waveManager;
    private int id;
    private BufferedImage texture;
    private int fly = Config.FLY;
    public Bullet (int x, int y,int damage,WaveManager waveManager, Enemy target, int id){
        MP3Player mp3Player = new MP3Player(Config.gun);
        mp3Player.play();
        this.x = x;
        this.y = y;
        this.spawX = x;
        this.spawY = y;
        this.target = target;
        this.damage = damage;
        this.waveManager = waveManager;
        this.texture = Assets.bullet[id];
       checkMove();
    }
    private void checkMove() {
        double deltaX = target.getSpawX() - x;
        double deltaY = target.getSpawY() - y;
        double a = Math.atan2(deltaX,deltaY);
        xMove = Math.sin(a);
        yMove = Math.cos(a);

    }
    private void move(){

        int a = (int) (x +  xMove * speed);
        int b = (int)( y + yMove * speed);
        if(a > World.tiles.length * Config.TILE_WIDTH || b > World.tiles[0].length * Config.TILE_HEIGHT || a <0 || b < 0)
            isDraw = false;
        else if( Math.sqrt((spawX - a) * (spawX - a) + (spawY - b) * (spawY - b) ) > fly) isDraw = false;
        else{
            x += xMove * speed;
            y += yMove * speed;
        }
    }
    public void tick() {

        move();
        checkCollisiion();

    }
    private void checkCollisiion(){
       int k = 0;
         while(k < waveManager.getWaveList().size()) {
             Wave wave = waveManager.getWaveList().get(k);
             int j = 0;
             while(j < wave.getEnemyList().size()){
                 Enemy enemy = wave.getEnemyList().get(j);
                 if (x >= enemy.getSpawX()  && x <= enemy.getSpawX() + Config.CREATURE_WIDTH / 1.5
                         && y >= enemy.getSpawY()  && y <= enemy.getSpawY() + Config.CREATURE_HEIGHT / 1.5) {
                     enemy.setHealth(enemy.getHealth() - damage);

                     isDraw = false;
                 }
                 if (enemy.getHealth() <= 0 ){
                     Player.add += enemy.getPrice();
                     MP3Player mp3Player = new MP3Player(Config.coin);
                     mp3Player.play();
                     enemy.setLive(false);
                     wave.getEnemyList().remove(j);
                 }

                 else j++;
             }
             if (wave.getEnemyList().isEmpty())
                 waveManager.getWaveList().remove(k);
             else k++;
         }
    }

    public void  render(Graphics g){
        if(isDraw)
        g.drawImage(texture, x, y,Config.BULLET_WIDTH, Config.BULLET_HEIGHT ,null);
    }
    public void setTarget(Enemy e){
        this.target = e;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isDraw() {
        return isDraw;
    }

    public void setDraw(boolean draw) {
        isDraw = draw;
    }
}
