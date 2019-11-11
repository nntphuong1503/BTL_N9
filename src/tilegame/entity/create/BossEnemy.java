package tilegame.entity.create;

import tilegame.Config;
import tilegame.Handler;
import tilegame.gfx.Assets;

public class BossEnemy extends Enemy {
    public BossEnemy(Handler handler, int id){
        super(handler, Assets.enemy[id], Config.BOSS_HEALTH, Config.BOSSENEMY_PRICE, Config.BOSS_SPEED,2);
    }
}
