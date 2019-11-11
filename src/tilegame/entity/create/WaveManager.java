package tilegame.entity.create;

import tilegame.Config;
import tilegame.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class WaveManager {
    private double timeSinceLastWave, spawnTime;
    private ArrayList<Wave> waveList;
    private Handler handler;
    private int count = 0, typeOfWave = 4;
    public WaveManager(Handler handler){
        this.handler = handler;
        this.spawnTime = Config.TiME_WAVE;
        this.timeSinceLastWave = spawnTime;
        this.waveList = new ArrayList<>();
    }
    public void tick(){
        timeSinceLastWave += Config.TiME_TICK;
        if(timeSinceLastWave > spawnTime){
            spaw();
            timeSinceLastWave = 0;
        }

        int i = 0;


        Iterator<Wave> iterator = waveList.iterator();
        while(iterator.hasNext()){
            iterator.next().tick();
        }

       while(i < waveList.size()){
            if(waveList.get(i).getEnemyList().isEmpty() && count >= 4)
                waveList.remove(i);
            else i++;
        }
       if(waveList.isEmpty() && count >= 4){
           this.handler.getGame().setRunning(false);
           this.handler.getGame().setLosse(false);

       }
    }
    private void spaw(){
        if(count < typeOfWave){
            waveList.add(new Wave(handler,count));
            count++;
        }
    }
    public void render(Graphics g){
        Iterator<Wave> iterator = waveList.iterator();
        while(iterator.hasNext()){
            iterator.next().render(g);
        }
    }

    public ArrayList<Wave> getWaveList() {
        return waveList;
    }

    public void setWaveList(ArrayList<Wave> waveList) {
        this.waveList = waveList;
    }
}
