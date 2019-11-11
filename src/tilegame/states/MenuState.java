package tilegame.states;

import tilegame.Config;
import tilegame.Handler;
import tilegame.gfx.Assets;
import tilegame.input.MouseManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;

public class MenuState extends State{
    // cac thuoc tinh
    private PlayButton playButton ;
    private QuitButton quitButton;

    public MenuState(Handler handler){
        super(handler);
        playButton = new PlayButton();
        quitButton = new QuitButton();
        this.handler.getMouseManager().setPlayButton(playButton);
        this.handler.getMouseManager().setQuitButton(quitButton);
    }
    @Override
    public void tick(){

    }

    @Override
    public void render(Graphics g){
        g.setColor(Color.blue);
        g.drawImage(Assets.background,0,0,handler.getGame().getWidth(),handler.getGame().getHeight(),null);

//        g.setFont(new Font("Arial", Font.ROMAN_BASELINE,72));
//        g.drawString("TOWER DEFENSE",80,100);
        playButton.render(g);
        quitButton.render(g);
    }

}
