package gui.table;
import gui.table.model.ArticleTableModel;
import settings.Style;

import javax.swing.*;

public class ArticleTableData extends TableData {
    private static final String[] columns = new String[]{"ARTICLES"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_ARTICLES};

    public ArticleTableData() {
        super(new ArticleTableModel(columns),columns,icons);

    }


}
