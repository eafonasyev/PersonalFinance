package gui.panel;

import dialog.AccountEditDialog;
import dialog.CurrencyEditDialog;
import gui.MainFrame;
import gui.hundler.FunctionHundler;
import gui.table.ArticleTableData;
import gui.table.CurrencyTableData;
import settings.Style;
import toolbar.FuctionToolbar;

public class CurrenciesPanel extends RightPanel{
    public CurrenciesPanel(MainFrame frame) {
        super(frame, new CurrencyTableData(new FunctionHundler(frame,new CurrencyEditDialog(frame))), "CURRENCY",Style.ICON_CURRENCIES,new FuctionToolbar(new FunctionHundler(frame,new CurrencyEditDialog(frame))));
    }
}
