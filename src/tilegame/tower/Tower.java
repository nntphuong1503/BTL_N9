package tilegame.tower;

import jaco.mp3.player.MP3Player;
import tilegame.Config;
import tilegame.bullet.Bullet;
import tilegame.entity.create.Enemy;
import tilegame.entity.create.Wave;
import tilegame.entity.create.WaveManager;
import tilegame.gfx.Assets;

import java.awt.*;
import java.util.ArrayList;

public class Tower {
    private  final int price;
    protected int x, y;
    protected int  damage ;
    //private Tile tile;
    protected ArrayList<Bullet> bulletList;
    protected boolean isTarged = false;
    protected Enemy target;
    protected WaveManager waveManager;
    protected int timeShoot = Config.TIME_SHOOT;
    protected int time = timeShoot;
    protected int count  = 0;
    //TODO Con
    protected double distance = Config.DISTANCE;
    protected int id;

    public Tower(int x, int y,WaveManager waveManager,int id, int damage,int price){
        MP3Player mp3player = new MP3Player(Config.tower);
        mp3player.play();
        this.x = x;
        this.y = y;
        this.waveManager = waveManager;
        this.id = id;
        this.damage = damage;
        this.price = price;
        this.target = acquireTarget();
        bulletList = new ArrayList<Bullet>();
    }
    public static Tower getTower(int spawX, int spawY,WaveManager waveManager,int id){
        if(id == 0) return new NomalTower(spawX,spawY,waveManager,id);
        else if(id == 1) return new MachineTower(spawX,spawY,waveManager,id);
        else if(id == 2) return new SniperTower(spawX,spawY,waveManager,id);
        else return null;
    }
    private Enemy acquireTarget(){
        Enemy closet = null;
        for(Wave wave: waveManager.getWaveList())
          for(Enemy enemy: wave.getEnemyList()){
             if(dis(enemy) <= distance)
             {
                closet = enemy;
                break;
              }
        }
        return closet;
    }
    private double dis(Enemy e){
        //return  Math.sqrt((e.getSpawX() - x) * (e.getSpawX() - x) - (e.getSpawY() - y) *(e.getSpawY() - y));
        return Math.abs(e.getSpawX() - x) + Math.abs(e.getSpawY() - y);
    }

    public void tick(){

        time++;
        if( acquireTarget() != null){
            if(time >timeShoot)
            {
                   time = 0;

                   bulletList.add(new Bullet(x,y,damage,waveManager,acquireTarget(),id));
               }
            }
        int i = 0;
        for(Bullet b : bulletList)
            b.tick();
        while(i < bulletList.size()){
            if(!bulletList.get(i).isDraw())
                bulletList.remove(i);
            else i++;
        }

    }
    public void render(Graphics g){
        g.drawImage(Assets.tower[id], x, y,38,38, null);
        for(Bullet b : bulletList)
            b.render(g);

    }
    private void shoot(){

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

    public ArrayList<Bullet> getBulletList() {
        return bulletList;
    }

    public void setBulletList(ArrayList<Bullet> bulletList) {
        this.bulletList = bulletList;
    }

    public int getPrice() {
        return price;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
