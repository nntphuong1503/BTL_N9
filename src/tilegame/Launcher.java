package tilegame;

import javax.swing.*;
import java.awt.*;

public class Launcher {
    public static void main(String [] args){

            Game game = new Game("Hello ",Config.WIDTH,Config.HEIGHT);
            game.start();
    }
}
