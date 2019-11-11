package tilegame;

import jaco.mp3.player.MP3Player;

import java.io.File;

public class Config {


    public static final int TIME_SHOOT = 40;
    public static final double DISTANCE = 150;
    public static final int FLY = 100;



    public static double SPAWX, SPAWY;

    public static final int WIDTH = 800;
    public static final int HEIGHT = 700;

    public static final int BULLET_WIDTH = 15,
                            BULLET_HEIGHT = 15;
    public static final int BUTTON_WIDTH = 40,
                            BUTTON_HEIGHT = 40;
    public static final int CREATURE_WIDTH = 50;
    public static final int CREATURE_HEIGHT = 50;
    public static final int TILE_WIDTH = 39;
    public static final int TILE_HEIGHT = 39;
    public static final int TREE_WIDTH = 39;
    public static final int TREE_HEIGHT = 60;

    public static final int  NOMALBUTTON_SPAWY = 600, NOMALBUTTON_SPAWX = 230;
    public static final int MACHINEBUTTON_SPAWY = 600,MACHINEBUTTON_SPAWX = 380;
    public static final int SNIPERBUTTON_SPAWY = 600, SNIPERBUTTON_SPAWX = 530 ;


    public static final double TiME_WAVE = 150;
    public static final double TiME_TICK = 0.2;
    public static final double  TiME_ENEMY = 25;


    public static final double BOSS_SPEED = 0.5  ;
    public static final double NOMAL_SPEED = 0.6 ;
    public static final double TANK_SPEED = 0.4 ;
    public static final double SMALL_SPEED = 0.5;
    public static final int BULLET_SPEED = 6;


    public static final int NOMAL_DAMAGE = 5 ;
    public static final int MACHINE_DAMAGE = 10 ;
    public static final int SNIPER_DAMAGE = 8 ;

    public static final int NOMAL_HEALTH = 20;
    public static final int BOSS_HEALTH = 50;
    public static final int TANK_HEALTH = 30;
    public static final int SMALL_HEALTH = 20;

    public static final int PLAYER_MONEY = 100 ;
    public static final int PLAYER_HP = 5;

    public static final int BOSSENEMY_PRICE = 20 ;
    public static final int TANKERENEMY_PRICE = 20;
    public static final int NOMALENEMY_PRICE = 10;
    public static final int SMALLENEMY_PRICE = 20;

    public static final int NOMALTOWER_PRICE = 20;
    public static final int MACHINETOWER_PRICE = 50;
    public static final int SNIPERTOWER_PRICE = 20;

    public static final int PLAYBUTTON_SPAWX = 290 ;
    public static final int PLAYBUTTON_SPAWY = 520;
    public static final int PLAYBUTTON_WIDTH = 210;
    public static final int PLAYBUTTON_HEIGHT = 80;

    public static final int QUITBUTTON_SPAWX = 290 ;
    public static final int QUITBUTTON_SPAWY = 605;
    public static final int QUITBUTTON_WIDTH = 210;
    public static final int QUITBUTTON_HEIGHT = 80;

    public static final int MAX_NUMBER_ENEMY = 10;


    public static final File start = new File("src/res/sounds/start.mp3"  );
    public static final File run = new File("src/res/sounds/run.mp3"  );
    public static final File gun = new File("src/res/sounds/gun3.mp3"  );
    public static final File tower = new File("src/res/sounds/tower.mp3"  );
    public static final File coin = new File("src/res/sounds/coin.mp3"  );
    public static final File win = new File("src/res/sounds/win.mp3"  );
    public static final File lose = new File("src/res/sounds/lose.mp3"  );
    public static final File heart = new File("src/res/sounds/heart.mp3"  );
    public static MP3Player mp3player ;
}
