package tilegame.entity.create;

import tilegame.Config;
import tilegame.Handler;
import tilegame.gfx.Assets;

import java.awt.image.BufferedImage;

public class NomalEnemy extends Enemy{
    public NomalEnemy(Handler handler,int id) {
        super(handler, Assets.enemy[id], Config.NOMAL_HEALTH, Config.NOMALENEMY_PRICE,  Config.NOMAL_SPEED,0);
    }
}
