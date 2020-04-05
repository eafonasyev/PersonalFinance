package gui.hundler;


import dialog.AboutDialog;
import gui.MainFileChooser;
import gui.MainFrame;
import gui.panel.*;
import settings.HundlerCode;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuHelpHundler extends Hundler {
    MainFileChooser fc;
    public MenuHelpHundler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()){
            case HundlerCode.MENU_HELP_ABOUT:
                new AboutDialog().setVisible(true);
        }
        super.actionPerformed(ae);
    }


}
