package dialog;

import gui.MainDatePicker;
import gui.MainFrame;
import objects.*;
import org.jdatepicker.impl.JDatePickerImpl;
import saveLoad.SaveData;
import settings.Format;
import settings.Style;

import javax.swing.*;
import java.util.Date;

public class TransfersEditDialog extends AddEditDialog {
    public TransfersEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void init() {
        component.put("LABEL_DATE",new MainDatePicker().getDatePicker());
        component.put("LABEL_AMOUNT_FROM",new JTextField());
        component.put("LABEL_AMOUNT_TO", new JTextField());
        component.put("LABEL_ACCOUNTS_FROM",new CommonComboBox(SaveData.getInstance().getAccounts().toArray()));
        component.put("LABEL_ACCOUNTS_TO",new CommonComboBox(SaveData.getInstance().getAccounts().toArray()));
        component.put("LABEL_NOTE",new JTextField());

        icon.put("LABEL_DATE",Style.ICON_DATE);
        icon.put("LABEL_ACCOUNTS_FROM",Style.ICON_ACCOUNTS);
        icon.put("LABEL_ACCOUNTS_TO",Style.ICON_ACCOUNTS);
        icon.put("LABEL_AMOUNT_FROM",Style.ICON_AMOUNT);
        icon.put("LABEL_AMOUNT_TO",Style.ICON_AMOUNT);
        icon.put("LABEL_NOTE",Style.ICON_NOTE);

        values.put("LABEL_DATE", new Date());
        values.put("LABEL_AMOUNT",Format.amount(0));
    }

    @Override
    protected void values() {
        Transfer transfers = (Transfer) c;
        values.put("LABEL_DATE",transfers.getDate());
        values.put("LABEL_ACCOUNTS_FROM",transfers.getFromAccount());
        values.put("LABEL_ACCOUNTS_TO",transfers.getToAccount());
        values.put("LABEL_AMOUNT_FROM",transfers.getFromAmount());
        values.put("LABEL_AMOUNT_TO",transfers.getToAmount());
        values.put("LABEL_NOTE",transfers.getNote());

    }

    @Override
    public Common getCommonFromForm() throws ModelException {
        Transfer transfers = null;
        try {
            Date date =(Date) ((JDatePickerImpl) component.get("LABEL_DATE")).getModel().getValue();
            String amountFrom = ((JTextField) component.get("LABEL_AMOUNT_FROM")).getText();
            String amountTo = ((JTextField) component.get("LABEL_AMOUNT_TO")).getText();
            Account accountFrom = (Account)((CommonComboBox) component.get("LABEL_ACCOUNTS_FROM")).getSelectedItem();
            Account accountTo = (Account)((CommonComboBox) component.get("LABEL_ACCOUNTS_TO")).getSelectedItem();
            String note = ((JTextField) component.get("LABEL_NOTE")).getText();
            transfers = new Transfer(accountFrom,accountTo,Format.formatAmountToNumber(amountFrom),Format.formatAmountToNumber(amountTo),note,date);

        } catch (NumberFormatException e) {
          throw  new ModelException(ModelException.AMOUNT_FORMAT);
        }
        return transfers;
    }
}
