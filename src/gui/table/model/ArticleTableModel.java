package gui.table.model;

import objects.Article;
import saveLoad.SaveData;

public class ArticleTableModel extends  MainTableModel {

    private final int TITLE = 0;

    public ArticleTableModel(String[] column) {
        super(SaveData.getInstance().getArticles(),column);
    }
    public ArticleTableModel(String[] column, int count) {
        super(SaveData.getInstance().getArticles(),column);

    }

    @Override
    protected void updateData() {
        data = SaveData.getInstance().getArticles();

    }

    @Override
    public Object getValueAt(int row, int column) {
        if(data.isEmpty())return null;
        Article article = (Article) data.get(row);
        switch (column) {
            case TITLE:
                return article.getTitle();

        }
        return  null;
    }
}
