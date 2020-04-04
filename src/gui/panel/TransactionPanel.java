package gui.panel;

import dialog.AccountEditDialog;
import dialog.TransactionEditDialog;
import gui.MainFrame;
import gui.hundler.FunctionHundler;
import gui.table.TransactionTableData;
import settings.Settings;
import settings.Style;
import toolbar.FuctionToolbar;

import javax.swing.*;

public class TransactionPanel extends RightPanel{
    public TransactionPanel(MainFrame frame) {
        super(frame, new TransactionTableData(new FunctionHundler(frame,new TransactionEditDialog(frame))), "TRANSACTIONS",Style.ICON_MENU_VIEW_TRANSACTIONS,
                new JPanel[]{new FuctionToolbar(new FunctionHundler(frame,new TransactionEditDialog(frame))),new FilterPanel(frame)});
    }
}
