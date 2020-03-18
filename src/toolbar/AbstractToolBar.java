package toolbar;

import gui.MainButton;
import gui.Refresh;
import settings.Style;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractToolBar extends JPanel implements Refresh {
    abstract protected void init();
    @Override
    public void refresh(){
        removeAll();
        refresh();
    }
    protected MainButton addButton(String title, ImageIcon icon, String action, boolean topPosition){
        MainButton button;
        button = new MainButton(title,icon,null,action);
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
