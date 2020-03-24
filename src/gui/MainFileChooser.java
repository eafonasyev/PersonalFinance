package gui;

import settings.Settings;
import settings.Text;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFileChooser extends JFileChooser {
    private MainFrame frame;
    public MainFileChooser(MainFrame frame){
        this.frame = frame;
        FileNameExtensionFilter filter = new FileNameExtensionFilter("programm",Settings.SAVE_FORMANT_FILE);
        setFileFilter(filter);
        setAcceptAllFileFilterUsed(false);
        setCurrentDirectory(Settings.SAVEDIR);

        UIManager.put("FileChooser.openButtonText",Text.get("OPEN_BUTTON_TEXT"));
        UIManager.put("FileChooser.saveButtonText",Text.get("SAVE_BUTTON_TEXT"));
        UIManager.put("FileChooser.cancelButtonText",Text.get("CANCEL_BUTTON_TEXT"));
        UIManager.put("FileChooser.fileNameLabelText",Text.get("NAME_LABEL_TEXT"));
        UIManager.put("FileChooser.filesOfTypeLabelText",Text.get("TYPE_lABEL_TEXT"));

        updateUI();
    }
    public int save (){
        return super.showSaveDialog(frame);
    }
    public int open(){
        return super.showOpenDialog(frame);
    }

}
