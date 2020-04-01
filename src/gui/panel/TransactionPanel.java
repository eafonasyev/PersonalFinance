package gui.panel;

import gui.MainFrame;
import gui.table.TransactionTableData;
import settings.Settings;
import settings.Style;
import toolbar.FuctionToolbar;

import javax.swing.*;

public class TransactionPanel extends RightPanel{
    public TransactionPanel(MainFrame frame) {
        super(frame, new TransactionTableData(), "TRANSACTIONS",Style.ICON_MENU_VIEW_TRANSACTIONS,
                new JPanel[]{new FuctionToolbar(),new FilterPanel(frame)});
    }
}
