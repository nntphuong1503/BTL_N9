package tilegame.states;

import tilegame.Handler;
import tilegame.worlds.World;

import java.awt.*;

public class GameState extends State {
    private World world;
    public GameState(Handler handler){
        super(handler);
        world = new World(handler, "resource/worlds/world1.txt");
        handler.setWorld(world);
}
    @Override
    public void tick(){
        world.tick();
    }
    @Override
    public void render(Graphics g){
        handler.getGame().getDisplay().getCanvas().setBackground(new Color(57,97,97));
        world.render(g);
    }
}
