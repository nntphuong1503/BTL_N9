package tilegame.player;

import tilegame.Config;
import tilegame.Handler;
import tilegame.button.ButtonManager;
import tilegame.entity.create.WaveManager;
import tilegame.gfx.Assets;
import tilegame.tower.Tower;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Player {
    private Handler handler;
    private List<Tower> towerList = new ArrayList<Tower>();
    private ButtonManager buttonManager;
    private WaveManager waveManager;
    private int money ;
    public static int add = 0;
    public static  int hp ;
    public static int sub;

    public Player(Handler handler){
        this.handler = handler;
    }
    public Player(Handler handler, ButtonManager buttonManager, WaveManager waveManager) {
        this.handler = handler;
        this.buttonManager = buttonManager;
        this.waveManager = waveManager;
        handler.getGame().getMouseManager().setPlayer(this);
        money = Config.PLAYER_MONEY;
        hp = Config.PLAYER_HP;
        sub = 0;
    }


    public void tick() {
        add = 0;
        Iterator<Tower> iterator = towerList.iterator();
        while(iterator.hasNext()){
            iterator.next().tick();
        }
        waveManager.tick();
        addMoney(add);

        if( hp == -1){
            this.handler.getGame().setLosse(true);
            this.handler.getGame().setRunning(false);
            return;
        }

    }

    public void render(Graphics g) {
        //TODO: ve them hp va tien ;
        buttonManager.render(g);
        Iterator<Tower> iterator = towerList.iterator();
        while (iterator.hasNext()) {
            iterator.next().render(g);
        }
        waveManager.render(g);
        g.drawImage(Assets.coin,660,600,30,30,null);
        g.drawImage(Assets.heart,660,630,25,25,null);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.ROMAN_BASELINE,20));
        g.drawString(String.valueOf(this.money),690,620);
        g.drawString(" "+this.hp, 690, 650 );
        g.setFont(new Font("Arial", Font.ROMAN_BASELINE,12));

        g.drawString("NOMAL" ,230,595);
        g.drawImage(Assets.coin,220,655,20,20,null);

        g.drawString("MACHINE" ,370,595);
        g.drawImage(Assets.coin,370,655,20,20,null);

        g.drawString("SNIPPER" ,520,595);
        g.drawImage(Assets.coin,520,655,20,20,null);

        g.setFont(new Font("Arial", Font.ROMAN_BASELINE,20));
        g.drawString(""+Config.NOMALTOWER_PRICE ,240,670);
        g.drawString(""+Config.MACHINETOWER_PRICE ,390,670);
        g.drawString(""+Config.SNIPERTOWER_PRICE ,540,670);

    }
    public  void subMoney(int n){
        this.money -= n;
    }
    public void addMoney(int n){
        this.money += n;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Tower> getTowerList() {
        return towerList;
    }

    public void setTowerList(List<Tower> towerList) {
        this.towerList = towerList;
    }

    public ButtonManager getButtonManager() {
        return buttonManager;
    }

    public void setButtonManager(ButtonManager buttonManager) {
        this.buttonManager = buttonManager;
    }

    public WaveManager getWaveManager() {
        return waveManager;
    }

    public void setWaveManager(WaveManager waveManager) {
        this.waveManager = waveManager;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}

