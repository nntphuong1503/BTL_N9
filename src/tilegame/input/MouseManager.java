package tilegame.input;

import jaco.mp3.player.MP3Player;
import tilegame.Config;
import tilegame.Handler;
import tilegame.button.Button;
import tilegame.button.ButtonManager;
import tilegame.entity.create.WaveManager;
import tilegame.player.Player;
import tilegame.states.PlayButton;
import tilegame.states.QuitButton;
import tilegame.states.State;
import tilegame.tower.Tower;
import tilegame.worlds.World;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

;

public class MouseManager implements MouseListener, MouseMotionListener {

  private ButtonManager buttonManager;
  private Handler handler;
  private List<Tower> towerList;
  private WaveManager waveManager;
  private boolean [] button = new boolean[3];
  private Player player;
  private Button choose = null;
  private PlayButton playButton;
  private QuitButton quitButton;

    public MouseManager(){
        towerList = new ArrayList<Tower>();
    }

    public void setPlayer(Player player){
        this.player = player;
        this.waveManager = player.getWaveManager();
        this.towerList = player.getTowerList();
        this.buttonManager = player.getButtonManager();
    }
    public void setPlayButton(PlayButton playButton) {
        this.playButton = playButton;

    }

    public void setQuitButton(QuitButton quitButton) {
        this.quitButton = quitButton;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        int mouseX = mouseEvent.getX();
        int mouseY = mouseEvent.getY();
        if (mouseX >= playButton.getSpawX() && mouseX <= playButton.getSpawX() + playButton.getWidth()
                && mouseY >= playButton.getSpawY() && mouseY <= playButton.getSpawY() + playButton.getHeight() && mouseEvent.getButton() == MouseEvent.BUTTON1) {
            Config.mp3player.stop();
            Config.mp3player = new MP3Player(Config.run);
            Config.mp3player.play();
            this.handler.getGame().menuState = null;
            State.setState(this.handler.getGame().gameState);
        } else if (this.handler.getGame().menuState != null && mouseX >= quitButton.getSpawX() && mouseX <= quitButton.getSpawX() + quitButton.getWidth()
                && mouseY >= quitButton.getSpawY() && mouseY <= quitButton.getSpawY() + quitButton.getHeight() && mouseEvent.getButton() == MouseEvent.BUTTON1) {
            // handler.getGame().getDisplay().getFrame().dispose();
            System.exit(0);
        } else {

            for (int i = 0; i < buttonManager.getButtonList().size(); i++) {

                if (this.handler.getGame().menuState == null && mouseX >= buttonManager.getButtonList().get(i).getSpawX() && mouseX <= buttonManager.getButtonList().get(i).getSpawX() + Config.BUTTON_WIDTH
                        && mouseY >= buttonManager.getButtonList().get(i).getSpawY() && mouseY <= buttonManager.getButtonList().get(i).getSpawY() + Config.BUTTON_HEIGHT

                )
                    if (MouseEvent.BUTTON1 == mouseEvent.getButton()) {
                        button[i] = true;
                        for (int j = 0; j < button.length; j++) {
                            if (j != i) button[j] = false;
                        }
                    } else {
                        button[i] = false;
                    }
            }
            int posX = mouseEvent.getX() / Config.TILE_WIDTH;
            int posY = mouseEvent.getY() / Config.TILE_HEIGHT;
            if (posY < 15 && World.tiles[posX][posY] == 0) {
                for (int i = 0; i < button.length; i++)
                    if (button[i]) {
                        Tower t = Tower.getTower(posX * Config.TILE_WIDTH, posY * Config.TILE_HEIGHT, waveManager, i);
                        if (this.handler.getGame().menuState == null && checkTowerList(posX, posY) && player.getMoney() >= t.getPrice() && MouseEvent.BUTTON1 == mouseEvent.getButton()) {
                            towerList.add(t);

                            player.subMoney(t.getPrice());
                        }

                    }
            }

        }
    }


    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        //38 la mac dinh cua co duong thap.
//        System.out.println("Mouse released");

    }
    private boolean checkTowerList(int posX, int posY){
        for(Tower tower : towerList){
            if(posX* Config.TILE_WIDTH == tower.getX() && posY * Config.TILE_HEIGHT == tower.getY())
                return false;
        }
        return true;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {


    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }


}
