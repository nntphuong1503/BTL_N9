package tilegame.tower;

import tilegame.Config;
import tilegame.button.MachineButton;
import tilegame.entity.create.Wave;
import tilegame.entity.create.WaveManager;

public class MachineTower extends Tower {
    public MachineTower(int spawX, int spawY, WaveManager waveManager,int id){

        super(spawX,spawY,waveManager,id, Config.MACHINE_DAMAGE,Config.MACHINETOWER_PRICE);

    }
}
