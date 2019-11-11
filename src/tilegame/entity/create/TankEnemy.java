package tilegame.entity.create;

import tilegame.Config;
import tilegame.Handler;
import tilegame.gfx.Assets;

public class TankEnemy extends Enemy{
    public TankEnemy(Handler handler, int id){
        super(handler,Assets.enemy[id],Config.TANK_HEALTH,Config.TANKERENEMY_PRICE,  Config.TANK_SPEED,1);
    }
}
