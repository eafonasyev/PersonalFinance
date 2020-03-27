package gui.table.model;

import objects.Common;
import objects.Transaction;
import saveLoad.SaveData;
import settings.Format;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransactionTableModel extends  MainTableModel {

    int count= -1;
    private final int DATE = 0;
    private final int ACCOUNT = 1;
    private final int ARTICLES = 2;
    private final int AMOUNT = 3;
    private final int NOUTE = 4;
    public TransactionTableModel(String[] column) {
        super(SaveData.getInstance().getFilterTransaction());
        this.column = new ArrayList(Arrays.asList(column));
    }
    public TransactionTableModel(String[] column,int count) {
        super(SaveData.getInstance().transactionsCount(count));
        this.column = new ArrayList(Arrays.asList(column));
        this.count = count;
    }

    @Override
    protected void updateData() {
        if(count == -1) data = SaveData.getInstance().getFilterTransaction();
        else data = SaveData.getInstance().transactionsCount(count);

    }

    @Override
    public Object getValueAt(int row, int column) {
        if(data.isEmpty())return null;
        Transaction transaction = (Transaction) data.get(row);
        switch (column) {
            case DATE:
                return transaction.getDate();
            case ACCOUNT:
                return transaction.getAccount().getTitle();
            case AMOUNT:
                return Format.amount(transaction.getAmount());
            case ARTICLES:
                return transaction.getArticle().getTitle();
            case NOUTE:
                return transaction.getNote();
        }
        return  null;
    }
}
