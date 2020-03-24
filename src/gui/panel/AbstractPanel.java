package gui.panel;

import gui.MainFrame;
import gui.Refresh;

import javax.swing.*;

public class AbstractPanel extends JPanel implements Refresh {
    private final MainFrame frame;

    public AbstractPanel(MainFrame frame){
        this.frame = frame;
        init();
    }

    @Override
    public void refresh() {

    }

    private void init() {
    }

}
