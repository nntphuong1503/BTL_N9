package tilegame.entity.create;

import tilegame.Config;
import tilegame.Handler;
import tilegame.gfx.Assets;

public class SmallEnemy extends Enemy{
    public SmallEnemy(Handler handler,int id) {
        super(handler, Assets.enemy[id], Config.SMALL_HEALTH, Config.SMALLENEMY_PRICE,  Config.SMALL_SPEED,3);
    }
}
