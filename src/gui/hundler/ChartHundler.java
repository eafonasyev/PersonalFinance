package gui.hundler;

import gui.MainFileChooser;
import gui.MainFrame;
import gui.panel.StatisticsPanel;
import settings.HundlerCode;

import java.awt.event.ActionEvent;

public class ChartHundler extends Hundler {
    public ChartHundler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()){
            case HundlerCode.TYPE:
                ((StatisticsPanel)frame.getRightPanel()).nextType();
        }
        super.actionPerformed(ae);
    }
}
