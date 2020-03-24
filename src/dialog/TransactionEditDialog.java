package dialog;

import gui.MainDatePicker;
import gui.MainFrame;
import objects.*;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePickerImpl;
import saveLoad.SaveData;
import settings.Format;
import settings.Style;

import javax.swing.*;
import java.util.Date;

public class TransactionEditDialog extends AddEditDialog {
    public TransactionEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void init() {
        component.put("LABEL_DATE",new MainDatePicker().getDatePicker());
        component.put("LABEL_ARTICLES",new CommonComboBox(SaveData.getInstance().getArticles().toArray()));
        component.put("LABEL_ACCOUNTS",new CommonComboBox(SaveData.getInstance().getAccounts().toArray()));
        component.put("LABEL_AMOUNT",new JTextField());
        component.put("LABEL_Note",new JTextField());

        icon.put("LABEL_DATE",Style.ICON_DATE);
        icon.put("LABEL_ARTICLES",Style.ICON_ARTICLES);
        icon.put("LABEL_ACCOUNTS",Style.ICON_ACCOUNTS);
        icon.put("LABEL_AMOUNT",Style.ICON_AMOUNT);
        icon.put("LABEL_NOTE",Style.ICON_NOTE);

        values.put("LABEL_DATE", new Date());
        values.put("LABEL_AMOUNT",Format.amount(0));
    }

    @Override
    protected void values() {
        Transaction tranasaction = (Transaction) c;
        values.put("LABEL_DATE",tranasaction.getDate());
        values.put("LABEL_ARTICLES",tranasaction.getArticle());
        values.put("LABEL_ACCOUNTS",tranasaction.getAccount());
        values.put("LABEL_AMOUNT",tranasaction.getAmount());
        values.put("LABEL_NOTE",tranasaction.getNote());

    }

    @Override
    protected Common getCommonFromForm() throws ModelException {
        Transaction transaction = null;
        try {
            Date date =(Date) ((JDatePickerImpl) component.get("LABEL_DATE")).getModel().getValue();
            String amount = ((JTextField) component.get("LABEL_AMOUNT")).getText();
            String note = ((JTextField) component.get("LABEL_NOTE")).getText();
            Article articles = (Article)((CommonComboBox) component.get("LABEL_ARTICLES")).getSelectedItem();
            Account account = (Account)((CommonComboBox) component.get("LABEL_ACCOUNTS")).getSelectedItem();
            transaction = new Transaction(articles,account,Format.formatAmountToNumber(amount),note);

        } catch (NumberFormatException e) {
          throw  new ModelException(ModelException.AMOUNT_FORMAT);
        }
        return transaction;
    }
}
