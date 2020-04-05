package gui.panel;

import dialog.AccountEditDialog;
import dialog.TransactionEditDialog;
import dialog.TransfersEditDialog;
import gui.MainFrame;
import gui.hundler.FunctionHundler;
import gui.table.TransactionTableData;
import gui.table.TransferTableData;
import settings.Style;
import settings.Text;
import toolbar.FuctionToolbar;

import javax.swing.*;

public class TransferPanel extends RightPanel{
    public TransferPanel(MainFrame frame) {
        super(frame, new TransferTableData(new FunctionHundler(frame,new TransfersEditDialog(frame))), "TRANSFER",Style.ICON_MENU_VIEW_TRANSFERS,
                new JPanel[]{new FuctionToolbar(new FunctionHundler(frame,new TransfersEditDialog(frame))),new FilterPanel(frame)});
    }
}
