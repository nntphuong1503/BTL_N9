package tilegame.worlds;

import tilegame.Config;
import tilegame.Handler;
import tilegame.button.Button;
import tilegame.button.ButtonManager;
import tilegame.entity.create.Enemy;
import tilegame.entity.create.Wave;
import tilegame.entity.create.WaveManager;
import tilegame.gfx.Assets;
import tilegame.player.Player;
import tilegame.tiles.Tile;
import tilegame.tower.Tower;
import tilegame.utils.Utils;

import java.awt.*;

public class World {
    private Handler handler;
    private int width, height;// so luong cua map
    private int spawnX, spawnY;
    public static int [][] tiles;
     public static int [][] point;
     public static int len = 6;

    private WaveManager  waveManager;
    private Player player;
    private ButtonManager buttonManager;

    public World(Handler handler, String path){
        this.handler = handler;
        loadWorld(path);
       Config.SPAWX = spawnX;
       Config.SPAWY = spawnY;
       waveManager = new WaveManager(handler);
        buttonManager = new ButtonManager();
        player = new Player(handler,buttonManager,waveManager);
    }
    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String [] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX  = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);
        len = Utils.parseInt(tokens[4]);
        point = new int[len][2];
        for(int i = 0; i < len ; i++ ){
            point[i][0] = Utils.parseInt(tokens[5 + 2*i]);
            point[i][1] = Utils.parseInt(tokens[6 + 2*i]);
        }

        tiles = new int [width][height];
        for(int y = 0; y < height; y++)
            for(int x = 0; x < width; x++){
                tiles[x][y] = Utils.parseInt(tokens[(x + y*width) + 5 + 2 *len]);
                }

    }
    public void tick(){
       //TODO tick cac lop de chon gio ko quan trong nghi sau
        //entityManager.tick(); -> enemy.tick(){ move(); (co the ca dan bay va chet }

       player.tick();
    }
    public void render(Graphics g) {

        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++) {
                getTile(x, y).render(g, x* Config.TILE_WIDTH ,y*Config.TILE_HEIGHT);
            }
        player.render(g);
        g.drawImage(Assets.house,710,0,60,60,null);
        g.drawImage(Assets.smalltree,765,0,30,39,null);
        g.drawImage(Assets.smalltree,775,10,30,39,null);
        g.drawImage(Assets.wattle,760,40,40,20,null);
        g.drawImage(Assets.tree1,690,30,35,35,null);
        g.drawImage(Assets.tree1,630,6,30,30,null);
        g.drawImage(Assets.tree1,650,6,50,50,null);
        g.drawImage(Assets.flower,760,50,30,30,null);
        g.drawImage(Assets.flower,760,70,30,30,null);
        g.drawImage(Assets.dirt,195,410,100,20,null);
        g.drawImage(Assets.tree1,370,270,40,40,null);
        g.drawImage(Assets.hightree,0,100,30,50,null);
        g.drawImage(Assets.hightree,20,100,40,60,null);
        g.drawImage(Assets.hightree,50,100,40,60,null);
        g.drawImage(Assets.treeorange,750,110,85,100,null);
        g.drawImage(Assets.treeorange,730,180,85,100,null);
        g.drawImage(Assets.treeorange,650,230,70,70,null);
        g.drawImage(Assets.treeorange,670,240,70,70,null);
        g.drawImage(Assets.treeorange,690,220,70,70,null);
        g.drawImage(Assets.treeorange,700,250,80,90,null);
        g.drawImage(Assets.house1,700,245,150,160,null);
        g.drawImage(Assets.pine,250,220,150,100,null);
        g.drawImage(Assets.rock,312,273,50,100,null);
        g.drawImage(Assets.pine,280,300,100,100,null);
        g.drawImage(Assets.pine,78,260,100,60,null);
        g.drawImage(Assets.pine,78,160,100,100,null);
        g.drawImage(Assets.pine,100,180,150,100,null);
        g.drawImage(Assets.treeorange,700,200,50,50,null);
        g.drawImage(Assets.house2,0,450,150,150,null);
        g.drawImage(Assets.pine,60,450,150,150,null);
        g.drawImage(Assets.pine,145,480,100,110,null);
        g.drawImage(Assets.pine,0,490,80,100,null);
        g.drawImage(Assets.treeorange,650,490,80,100,null);
        g.drawImage(Assets.treeorange,690,480,80,80,null);
        g.drawImage(Assets.treeorange,720,470,90,100,null);
        g.drawImage(Assets.treeorange,750,450,80,100,null);
        g.drawImage(Assets.treeorange,750,520,60,60,null);
        g.drawImage(Assets.treeorange,680,520,60,60,null);
        g.drawImage(Assets.treeorange,680,520,60,60,null);
        g.drawImage(Assets.treeorange,650,520,60,60,null);
        g.drawImage(Assets.treeorange,630,530,60,60,null);
        g.drawImage(Assets.treeorange,580,530,60,60,null);
    }
    public Tile getTile(int x, int y){
        Tile t = Tile.tiles[tiles[x][y]];
        return t;
    }
//TODO soat lai vi thua
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSpawnX() {
        return spawnX;
    }

    public void setSpawnX(int spawnX) {
        this.spawnX = spawnX;
    }

    public int getSpawnY() {
        return spawnY;
    }

    public void setSpawnY(int spawnY) {
        this.spawnY = spawnY;
    }

    public int[][] getTiles() {
        return tiles;
    }

}
