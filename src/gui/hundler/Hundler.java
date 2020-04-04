package gui.hundler;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract  public class Hundler implements ActionListener {
    MainFrame frame;
    public Hundler(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       frame.refresh();
    }
}
