package gui.hundler;

import dialog.ConfirmDialog;
import gui.MainFrame;
import saveLoad.SaveData;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindowHendler extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        if(SaveData.getInstance().isSaved()) System.exit(0);
        else{
            int result = ConfirmDialog.show((MainFrame) e.getWindow(),"EXIT_FILE_CONFIRM","CONFIRMATION_ACTION");
            if(result == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }
    }
}
