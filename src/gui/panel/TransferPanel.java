package gui.panel;

import gui.MainFrame;
import gui.table.TransactionTableData;
import gui.table.TransferTableData;
import settings.Style;
import toolbar.FuctionToolbar;

import javax.swing.*;

public class TransferPanel extends RightPanel{
    public TransferPanel(MainFrame frame) {
        super(frame, new TransferTableData(), "TRANSFER",Style.ICON_MENU_VIEW_TRANSACTIONS,
                new JPanel[]{new FuctionToolbar(),new FilterPanel(frame)});
    }
}
