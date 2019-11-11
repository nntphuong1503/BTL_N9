package tilegame.tiles;

import tilegame.Config;
import tilegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    public static Tile[] tiles = new Tile[300];
    public static Tile grassTile = new GrassTile(0);
    public static Tile roadTile = new RoadTile(1);
    public static Tile tree = new TreeTile(2);
    public static Tile tree1 = new TreeTile1(3);
    public static Tile tree2 = new TreeTile2(4);

    public static final int DELTA = 15;


    protected BufferedImage texture;
    protected final int id ;

    public Tile(BufferedImage texture, int id){
        this.id = id;
        this.texture = texture;

        tiles[id] = this;
    }
    public void render(Graphics g, int x, int y){
        if(x == 0) x +=  DELTA;
        if(y == 0) y += DELTA;

        if(id == 1){
            g.drawImage(Assets.road, x, y, Config.TILE_WIDTH, Config.TILE_HEIGHT, null);
        }
        else {
            g.drawImage(Assets.grass,x,y, Config.TILE_WIDTH,Config.TILE_HEIGHT, null);

            if (id == 2) {
                g.drawImage(Assets.grass, x, y, Config.TREE_WIDTH, Config.TILE_HEIGHT, null);
            } else if (id == 3) {
                g.drawImage(Assets.hightree, x, 0 , Config.TILE_WIDTH, 40, null);
            } else if(id == 4){
                g.drawImage(Assets.hightree,x,250,Config.TILE_WIDTH,40,null);
            }
        }
   }
   public int getId(){
        return this.id;
   }


}
