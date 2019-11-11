package tilegame.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage road, grass;
    public static BufferedImage[] enemy = new BufferedImage[4];
    public static BufferedImage[] tower = new BufferedImage[3];
    public static BufferedImage[] bullet = new BufferedImage[3];
    public static BufferedImage[] tree = new BufferedImage[3];
    public static BufferedImage[] nomalenemy = new BufferedImage[6];
    public static BufferedImage background,gameover,victory;
    public static BufferedImage playButton,quitButton;
    public static BufferedImage tree1,tree2,dirt,house,smalltree,
            mountain,wattle,flower,hightree,house1,rock,pine,
            coin, heart , treeorange, house2, chesnut;

    public static void init() {
        road = ImageLoader.loadImage("/res/textures/road3.png");
        grass = ImageLoader.loadImage("/res/textures/grass.png");

        enemy[0] = ImageLoader.loadImage("/res/textures/nomalenemy.png");
        enemy[1] = ImageLoader.loadImage("/res/textures/tankenemy.png");
        enemy[2] = ImageLoader.loadImage("/res/textures/bossenemy.png");
        enemy[3] = ImageLoader.loadImage("/res/textures/smallenemy.png");

        tower[0] = ImageLoader.loadImage("/res/textures/nomaltower.png");
        tower[1] = ImageLoader.loadImage("/res/textures/machinetower.png");
        tower[2] = ImageLoader.loadImage("/res/textures/snipertower.png");

        bullet[0]= ImageLoader.loadImage("/res/textures/bullet.png");
        bullet[1]= ImageLoader.loadImage("/res/textures/bullet.png");
        bullet[2]= ImageLoader.loadImage("/res/textures/bullet.png");

        tree[0] =ImageLoader.loadImage("/res/textures/tree.png");
        tree[1] = ImageLoader.loadImage("/res/textures/tree1.png");
        tree[2] = ImageLoader.loadImage("/res/textures/treedouble.png");

        background = ImageLoader.loadImage("/res/textures/startdefense.png");
        playButton = ImageLoader.loadImage("/res/textures/playbutton.png");
        quitButton = ImageLoader.loadImage("/res/textures/quitbutton.png");

        try{
            int i = 0;
            for(i = 0 ; i < 6; i++){
                nomalenemy[i] = ImageIO.read(Assets.class.getResource("res/textures/nomalenemy" + Integer.toString(new Integer(i+1)) + ".png"));
            }
        }catch (Exception e){}

        tree1 = ImageLoader.loadImage("/res/textures/tree_01.png");
        tree2 = ImageLoader.loadImage("/res/textures/tree_03.png");
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/Overworld.png"));
        house = sheet.crop(97,0,78,78);
        dirt = sheet.crop(98,83,73,10);
        wattle = sheet.crop(0,304,30,14);


        smalltree = ImageLoader.loadImage("/res/textures/smalltree.png");

        SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/res/textures/mountain.png"));
        mountain = sheet1.crop(0,0,186,223);
        flower = sheet1.crop(223,320,33,30);
        hightree = sheet1.crop(288,389,65,120);
        rock = sheet1.crop(350,386,35,60);

        pine = ImageLoader.loadImage("/res/textures/pine.png");

        house1 = ImageLoader.loadImage("/res/textures/rem_0001.png");

        heart = ImageLoader.loadImage("/res/textures/heart.png");

        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/res/textures/coin.png"));
        coin = sheet2.crop(99,0,26,22);

        treeorange = ImageLoader.loadImage("/res/textures/tree1_00.png");

        house2 = ImageLoader.loadImage("/res/textures/rem_0009.png");

        chesnut = ImageLoader.loadImage("/res/textures/chesnut.png");

        gameover = ImageLoader.loadImage("/res/textures/gameover.jpg");

        SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/res/textures/vic.jpg"));
        victory = sheet3.crop(365,0,1176,1117);
    }
}