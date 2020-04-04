package gui.panel;

import dialog.AccountEditDialog;
import dialog.ArticleEditDialog;
import gui.MainFrame;
import gui.hundler.FunctionHundler;
import gui.table.ArticleTableData;
import settings.Style;
import toolbar.FuctionToolbar;

public class ArticlePanel extends RightPanel{
    public ArticlePanel(MainFrame frame) {
        super(frame, new ArticleTableData(new FunctionHundler(frame,new ArticleEditDialog(frame))), "ARTICLES",Style.ICON_ARTICLES,new FuctionToolbar(new FunctionHundler(frame,new ArticleEditDialog(frame))));
    }
}
