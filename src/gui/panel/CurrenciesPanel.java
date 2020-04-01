package gui.panel;

import gui.MainFrame;
import gui.table.ArticleTableData;
import gui.table.CurrencyTableData;
import settings.Style;
import toolbar.FuctionToolbar;

public class CurrenciesPanel extends RightPanel{
    public CurrenciesPanel(MainFrame frame) {
        super(frame, new CurrencyTableData(), "CURRENCY",Style.ICON_CURRENCIES,new FuctionToolbar());
    }
}
