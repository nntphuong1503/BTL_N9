package tilegame.button;

        import tilegame.Config;
        import tilegame.gfx.Assets;

        import java.awt.image.BufferedImage;

public class NomalButton extends Button {

    public NomalButton(int id){
        super(Assets.tower[id],Config.NOMALBUTTON_SPAWX,Config.NOMALBUTTON_SPAWY,id);
    }
}
