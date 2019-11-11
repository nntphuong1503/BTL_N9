package tilegame.entity.create;

import tilegame.Config;
import tilegame.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public  class Enemy extends Creature {
    private Enemy enemies[] = new Enemy[10];

    protected BufferedImage texture;
    protected int id ;
    public Enemy(Handler handler,BufferedImage texture,int health, int price,double speed,int id){
        super(handler,health,price,speed);
        this.texture = texture;
        this.id = id;
        enemies[id] = this;
    }
    public static Enemy getEnemy(Handler handler, int id){
        if(id == 0)
            return new NomalEnemy(handler,id);
        else if(id == 1)
            return new TankEnemy(handler,id);
        else if(id == 2)
            return new BossEnemy(handler,id);
        else if(id == 3)
            return new SmallEnemy(handler,id);
        else return null;
    }


    public void tick(){
        checkmove();
        move();
    }
    public void render(Graphics g){

           g.drawImage(texture,(int)spawX,(int)spawY, Config.CREATURE_WIDTH,Config.CREATURE_HEIGHT,null);
    }

}
