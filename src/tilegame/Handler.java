package tilegame;

import tilegame.input.MouseManager;
import tilegame.worlds.World;

public class Handler {
    private Game game;
    private World world;

    public Handler (Game game){
        this.game = game;
    }
    public void setWorld(World world){
        this.world = world;
    }
    public Game getGame(){
        return this.game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public MouseManager getMouseManager() {
        return game.getMouseManager();
    }

    public void setMouseManager(MouseManager mouseManager) {
        game.setMouseManager(mouseManager) ;
    }
}
