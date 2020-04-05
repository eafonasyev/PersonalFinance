package gui.hundler;


import gui.MainFileChooser;
import gui.MainFrame;
import saveLoad.SaveData;
import settings.HundlerCode;

import java.awt.event.ActionEvent;

public class MenuFilterHundler extends Hundler {
    MainFileChooser fc;
    public MenuFilterHundler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        switch (ae.getActionCommand()){
            case HundlerCode.LEFT:
                SaveData.getInstance().getFilter().prev();
                break;
            case HundlerCode.RIGTH:
                SaveData.getInstance().getFilter().next();
                break;
            case HundlerCode.STEP:
                SaveData.getInstance().getFilter().nextPeriod();

        }
        super.actionPerformed(ae);
    }
}
