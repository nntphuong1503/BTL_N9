package tilegame.states;

import javax.swing.*;
import java.awt.*;

public class QuitState  {
    private JFrame frame;
    private Canvas canvas;

    private int money;
    private int width, height;
    private String status;

    public QuitState(int money, int width, int height,String status){
        this.money = money;
        this.width = width;
        this.height = height;
        this.status = status;
        createDisplay();
    }

    private void  createDisplay(){
        frame = new JFrame("End");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);


        frame.add(canvas);
        frame.pack();
    }


}
