package gui.table.model;

import objects.Article;
import objects.Currency;
import saveLoad.SaveData;
import settings.Format;

public class CurrencyTableModel extends  MainTableModel {

    private final int TITLE = 0;
    private final int CODE = 1;
    private final int RATE = 2;
    private final int ON = 3;
    private final int BASE = 4;

    public CurrencyTableModel(String[] column) {
        super(SaveData.getInstance().getCurrencies(),column);
    }


    @Override
    protected void updateData() {
        data = SaveData.getInstance().getCurrencies();

    }

    @Override
    public Object getValueAt(int row, int column) {
        if(data.isEmpty())return null;
        Currency currency = (Currency) data.get(row);
        switch (column) {
            case TITLE:
                return currency.getTitle();
            case CODE:
                return currency.getCode();
            case RATE:
               // return Format.rate(currency.getRate(),SaveData.getInstance().getBaseCurency());
                return  currency.getRate();
            case ON:
               // return currency.getOn();
                return Format.yesNo(currency.getOn());
            case BASE:
               // return currency.getBase();
                return Format.yesNo(currency.getBase());

        }
        return  null;
    }
}
