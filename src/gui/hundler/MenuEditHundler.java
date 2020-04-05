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

public class MenuEditHundler extends Hundler {
    MainFileChooser fc;
    public MenuEditHundler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        FunctionHundler hundler = frame.getRightPanel().getTableData().getFunctionHundler();
        switch (ae.getActionCommand()){
            case HundlerCode.MENU_EDIT_ADD:
                hundler.add();
                break;
            case HundlerCode.MENU_EDIT_EDIT:
                hundler.edit();
                break;
            case HundlerCode.MENU_EDIT_DELETE:
                hundler.delete();

        }
        super.actionPerformed(ae);
    }
}
