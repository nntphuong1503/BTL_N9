package tilegame.tower;

import tilegame.Config;
import tilegame.entity.create.WaveManager;

public class NomalTower extends Tower {
    public NomalTower(int spawX, int spawY, WaveManager waveManager, int id){
        super(spawX,spawY,waveManager,id, Config.NOMAL_DAMAGE,Config.NOMALTOWER_PRICE);
    }
}
