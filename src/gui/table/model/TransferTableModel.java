package gui.table.model;

import objects.Transaction;
import objects.Transfer;
import saveLoad.SaveData;
import settings.Format;

public class TransferTableModel extends  MainTableModel {


    private final int DATE = 0;
    private final int FROM_ACCOUNT = 1;
    private final int TO_ACCOUNT = 2;
    private final int FROM_AMOUNT = 3;
    private final int TO_AMOUNT = 4;
    private final int NOUTE = 5;
    public TransferTableModel(String[] column) {
        super(SaveData.getInstance().getFilterTransfers(),column);
    }
    @Override
    protected void updateData() {
        SaveData.getInstance().getTransfers();

    }

    @Override
    public Object getValueAt(int row, int column) {
        if(data.isEmpty())return null;
        Transfer transfer = (Transfer) data.get(row);
        switch (column) {
            case DATE:
                return transfer.getDate();
            case FROM_ACCOUNT:
                return transfer.getFromAccount();
            case TO_ACCOUNT:
                return transfer.getToAccount();
            case FROM_AMOUNT:
                return Format.amount(transfer.getFromAmount(),transfer.getToAccount().getCurrency());
            case TO_AMOUNT:
                return Format.amount(transfer.getToAmount(),transfer.getToAccount().getCurrency());
            case NOUTE:
                return transfer.getNote();
        }
        return  null;
    }
}
