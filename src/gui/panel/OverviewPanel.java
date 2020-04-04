package gui.panel;

import dialog.AccountEditDialog;
import dialog.TransactionEditDialog;
import gui.MainFrame;
import gui.hundler.FunctionHundler;
import gui.table.TransactionTableData;
import settings.Settings;
import settings.Style;
import settings.Text;

import javax.swing.*;

public class OverviewPanel extends RightPanel{
    public OverviewPanel(MainFrame frame) {
        super(frame, new TransactionTableData(Settings.COUNT_OVERVIEW_ROWS,new FunctionHundler(frame, new TransactionEditDialog(frame))), "LAST_TRANSACTIONS",Style.ICON_TOOLBAR_OVERVIEW);
    }
}
