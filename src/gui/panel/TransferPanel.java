package gui.panel;

import dialog.AccountEditDialog;
import dialog.TransactionEditDialog;
import gui.MainFrame;
import gui.hundler.FunctionHundler;
import gui.table.TransactionTableData;
import gui.table.TransferTableData;
import settings.Style;
import toolbar.FuctionToolbar;

import javax.swing.*;

public class TransferPanel extends RightPanel{
    public TransferPanel(MainFrame frame) {
        super(frame, new TransferTableData(new FunctionHundler(frame,new TransactionEditDialog(frame))), "TRANSFER",Style.ICON_MENU_VIEW_TRANSACTIONS,
                new JPanel[]{new FuctionToolbar(new FunctionHundler(frame,new TransactionEditDialog(frame))),new FilterPanel(frame)});
    }
}
