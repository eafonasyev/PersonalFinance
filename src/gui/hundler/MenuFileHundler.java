package gui.hundler;

import dialog.ConfirmDialog;
import dialog.ErrorDialog;
import gui.MainFileChooser;
import gui.MainFrame;
import saveLoad.SaveData;
import settings.HundlerCode;
import settings.Settings;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class MenuFileHundler extends Hundler {
    MainFileChooser fc;
    public MenuFileHundler(MainFrame frame) {
        super(frame);
        fc = new MainFileChooser(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()){
            case HundlerCode.MENU_FILE_NEW:
                Settings.setFileSaves(null);
                SaveData.getInstance().clear();
                break;
            case HundlerCode.MENU_FILE_OPEN:
                int returnVal = fc.open();
                if(returnVal == JFileChooser.APPROVE_OPTION)
                    Settings.setFileSaves(fc.getSelectedFile());
                    SaveData.getInstance().clear();
                    SaveData.getInstance().load();
                break;
            case HundlerCode.MENU_FILE_SAVE:
                if(Settings.getFileSaves() == null){
                    int result = fc.save();
                    if(result == JFileChooser.APPROVE_OPTION){
                       String path = fc.getSelectedFile().getAbsolutePath();
                       String ext = path.substring(path.lastIndexOf(".")+1);
                       if(ext.equals(Settings.SAVE_FORMANT_FILE)) Settings.setFileSaves(new File(path));
                       else{
                           Settings.setFileSaves(new File(path+"."+Settings.SAVE_FORMANT_FILE));
                       }
                    }
                }
                if(Settings.getFileSaves() != null){
                    SaveData.getInstance().save();
                }
                break;
            case HundlerCode.MENU_FILE_UPDATE_CURRINCIES:
                try {
                    SaveData.getInstance().updateCurencies();
                } catch (Exception e) {
                    ErrorDialog.show(frame,"ERROR_UPDATE_CURRENCIES");
                }
                break;
            case HundlerCode.MENU_FILE_EXIT:
                if(SaveData.getInstance().isSaved()){
                    System.exit(0);
                }
                else{
                   int result = ConfirmDialog.show(frame,"EXIT_FILE_CONFIRM","CONFIRMATION_ACTION");
                    if(result == JOptionPane.YES_OPTION){
                        System.exit(0);
                    }
                }
                break;


        }
        super.actionPerformed(ae);
    }
}
