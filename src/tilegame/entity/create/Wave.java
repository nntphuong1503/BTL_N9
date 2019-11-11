package tilegame.entity.create;

import tilegame.Config;
import tilegame.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Wave {
    private double timeSinceLastSpawn, spawnTime;
    private Enemy enemy;
    private ArrayList<Enemy> enemyList;
    private Handler handler;
    private int count = 0, numberOfEnemy ;
    int id;

    public Wave(Handler handler,int id){
        this.handler = handler;
        this.id = id;
        enemyList = new ArrayList<>();
        spawnTime = Config.TiME_ENEMY;
        timeSinceLastSpawn = spawnTime;
        Random random = new Random();
        numberOfEnemy = (random.nextInt(100) % Config.MAX_NUMBER_ENEMY) + 1;
    }
    public void render(Graphics g){

        Iterator<Enemy> iterator = enemyList.iterator();
        while(iterator.hasNext()){
            iterator.next().render(g);
        }
    }
    private  void Spawn(){
        if(count < numberOfEnemy) {
            enemyList.add( Enemy.getEnemy(handler, id));
            count++;
        }
    }
    public void tick(){
        timeSinceLastSpawn += 0.2;
        if(timeSinceLastSpawn > spawnTime){
            Spawn();
            timeSinceLastSpawn = 0;
        }
        int i = 0;
        while(i < enemyList.size()){
            if(!enemyList.get(i).isLive())
                enemyList.remove(i);
            else{
                i++;
            }
        }
        Iterator<Enemy> iterator = enemyList.iterator();
        while(iterator.hasNext()){
            iterator.next().tick();
        }

    }

    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }

    public void setEnemyList(ArrayList<Enemy> enemyList) {
        this.enemyList = enemyList;
    }
}
