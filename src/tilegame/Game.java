package tilegame;

import jaco.mp3.player.MP3Player;
import tilegame.display.Display;
import tilegame.gfx.Assets;
import tilegame.input.MouseManager;
import tilegame.player.Player;
import tilegame.states.GameState;
import tilegame.states.MenuState;
import tilegame.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{

    private Display display;
    private int width, height;
    public String title;

    private boolean running = false;
    private boolean losse = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    public State gameState;
    public State menuState;


    private MouseManager mouseManager;
    private Player player;

    private Handler handler;

    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        mouseManager = new MouseManager();

    }

    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
       display.getCanvas().addMouseListener(mouseManager);
       display.getCanvas().addMouseMotionListener(mouseManager);

        Assets.init();
        handler = new Handler(this);
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        mouseManager.setHandler(handler);
        player = new Player(handler);
        State.setState(menuState);
    }


    @Override
    public void run() {
        init();
        Config.mp3player =  new MP3Player(Config.start);
        Config.mp3player.play();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (State.getState() != null) {

            if (running == true) {
                now = System.nanoTime();
                delta += (now - lastTime) / timePerTick;
                timer += now - lastTime;
                lastTime = now;

                if (delta >= 1) {
                    tick();
                    render();
                    delta--;
                }
            }else stop();

        }
    }
    public synchronized void start(){
        if(running == true) return ;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop() {
        if (!running) {
            render();
            try {


                thread.sleep(5400);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            running = true;
          //  handler = new Handler(this);
            gameState = new GameState(handler);
            menuState = new MenuState(handler);
            State.setState(menuState);
           // player = new Player(handler);
            Config.mp3player = new MP3Player(Config.start);
            Config.mp3player.play();


        }
    }
    private void tick(){
      if(State.getState() != null)
          State.getState().tick();
    }
    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        if (running) {

            g.clearRect(0, 0, width, height);
            if (State.getState() != null)
                State.getState().render(g);
        } else {
            Config.mp3player.stop();
            if(losse) {

                g.drawImage(Assets.gameover,100,200,null);
                Config.mp3player = new MP3Player(Config.lose);
                Config.mp3player.play();
            }
            else{
                g.drawImage(Assets.victory,0,0,800,700,null);

                Config.mp3player = new MP3Player(Config.win);
                Config.mp3player.play();
            }
            }

        bs.show();
        g.dispose();
    }
    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public void setMouseManager(MouseManager mouseManager) {
        this.mouseManager = mouseManager;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    public void setLosse(boolean loose){
        this.losse = loose;
    }
    public void setRunning(boolean running){
        this.running = running;
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

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
