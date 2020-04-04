package toolbar;

import gui.MainButton;
import gui.Refresh;
import gui.hundler.Hundler;
import settings.Style;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public abstract class AbstractToolBar extends JPanel implements Refresh {
    private Hundler hundler;
    public AbstractToolBar(EmptyBorder border, Hundler hundler) {
        setBorder(border);
        this.hundler = hundler;
    }

    abstract protected void init();
    @Override
    public void refresh(){
        removeAll();
        init();
    }
    protected MainButton addButton(String title, ImageIcon icon, String action, boolean topPosition){
        MainButton button;
        button = new MainButton(title,icon,hundler,action);
        if(topPosition){
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setVerticalTextPosition(SwingConstants.BOTTOM);
        }
        else{
            button.setHorizontalTextPosition(SwingConstants.RIGHT);
            button.setVerticalTextPosition(SwingConstants.CENTER);

        }
        add(button);
        return button;
    }

}
