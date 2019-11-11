package tilegame.button;

import tilegame.Config;
import tilegame.gfx.Assets;

import java.awt.image.BufferedImage;

public class MachineButton extends Button {

    public MachineButton(int id){
        super(Assets.tower[id],Config.MACHINEBUTTON_SPAWX,Config.MACHINEBUTTON_SPAWY,id);
    }
}
