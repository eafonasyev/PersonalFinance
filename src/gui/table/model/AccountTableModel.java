package gui.table.model;

import objects.Account;
import objects.Currency;
import objects.Transaction;
import saveLoad.SaveData;
import settings.Format;

import java.util.ArrayList;
import java.util.Arrays;

public class AccountTableModel extends  MainTableModel {

    private final int TITLE = 0;
    private final int AMOUNT = 1;

    public AccountTableModel(String[] column) {
        super(SaveData.getInstance().getAccounts(),column);
    }
    public AccountTableModel(String[] column, int count) {
        super(SaveData.getInstance().getAccounts(),column);

    }

    @Override
    protected void updateData() {
        data = SaveData.getInstance().getAccounts();

    }

    @Override
    public Object getValueAt(int row, int column) {
        if(data.isEmpty())return null;
        Account account = (Account) data.get(row);
        switch (column) {
            case TITLE:
                return account.getTitle();
            case AMOUNT:
                return Format.amount(account.getAmount(),account.getCurrency());

        }
        return  null;
    }
}
