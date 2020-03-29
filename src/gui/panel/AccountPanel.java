package gui.panel;

import gui.MainFrame;
import gui.table.AccountTableData;

import settings.Style;
import toolbar.FuctionToolbar;

public class AccountPanel extends RightPanel{
    public AccountPanel(MainFrame frame) {
        super(frame, new AccountTableData(), "ACCOUNTS",Style.ICON_ACCOUNTS,new FuctionToolbar());
    }
}
