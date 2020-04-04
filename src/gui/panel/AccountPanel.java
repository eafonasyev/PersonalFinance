package gui.panel;

import dialog.AccountEditDialog;
import gui.MainFrame;
import gui.hundler.FunctionHundler;
import gui.table.AccountTableData;

import settings.Style;
import toolbar.FuctionToolbar;

public class AccountPanel extends RightPanel{
    public AccountPanel(MainFrame frame) {
        super(frame, new AccountTableData(new FunctionHundler(frame,new AccountEditDialog(frame))), "ACCOUNTS",Style.ICON_ACCOUNTS,new FuctionToolbar(new FunctionHundler(frame,new AccountEditDialog(frame))));
    }
}
