package tilegame.button;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ButtonManager {
    private List<Button> buttonList;
    public  ButtonManager(){
        buttonList = new ArrayList<Button>(3);
        buttonList.add(new NomalButton(0));
        buttonList.add(new MachineButton(1));
        buttonList.add(new SniperButton(2));
    }
    public void render(Graphics g){
        for(Button button : buttonList){
            button.render(g);
        }
    }

    public List<Button> getButtonList() {
        return buttonList;
    }

    public void setButtonList(List<Button> buttonList) {
        this.buttonList = buttonList;
    }
}
