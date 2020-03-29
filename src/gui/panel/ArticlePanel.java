package gui.panel;

import gui.MainFrame;
import gui.table.ArticleTableData;
import settings.Style;
import toolbar.FuctionToolbar;

public class ArticlePanel extends RightPanel{
    public ArticlePanel(MainFrame frame) {
        super(frame, new ArticleTableData(), "ARTICLES",Style.ICON_ARTICLES,new FuctionToolbar());
    }
}
