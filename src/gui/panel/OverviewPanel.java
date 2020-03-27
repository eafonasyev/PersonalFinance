package gui.panel;

import gui.MainFrame;
import gui.table.TransactionTableData;
import settings.Settings;
import settings.Style;
import settings.Text;

public class OverviewPanel extends RightPanel{
    public OverviewPanel(MainFrame frame) {
        super(frame, new TransactionTableData(Settings.COUNT_OVERVIEW_ROWS), "LAST_TRANSACTIONS",Style.ICON_TOOLBAR_OVERVIEW);
    }
}
