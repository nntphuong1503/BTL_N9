package tilegame.button;

import tilegame.Config;
import tilegame.gfx.Assets;

import java.awt.image.BufferedImage;

public class SniperButton extends Button {

    public SniperButton(int id){
        super(Assets.tower[id],Config.SNIPERBUTTON_SPAWX,Config.SNIPERBUTTON_SPAWY,id);
    }
}
