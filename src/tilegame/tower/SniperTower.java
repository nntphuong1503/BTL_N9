package tilegame.tower;

import tilegame.Config;
import tilegame.button.MachineButton;
import tilegame.entity.create.Wave;
import tilegame.entity.create.WaveManager;

public class SniperTower extends Tower {
    public SniperTower(int spawX, int spawY, WaveManager waveManager,int id){
        super(spawX,spawY,waveManager,id, Config.SNIPER_DAMAGE,Config.SNIPERTOWER_PRICE);
    }
}
