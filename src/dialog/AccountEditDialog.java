package dialog;

import gui.MainFrame;
import objects.Account;
import objects.Common;
import objects.Currency;
import objects.ModelException;
import saveLoad.SaveData;
import settings.Style;
import settings.Text;
import javax.swing.*;

public class AccountEditDialog extends AddEditDialog {
    public AccountEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void init() {
        component.put("LABEL_TITLE",new JTextField());
        component.put("LABEL_CURRENCIES",new CommonComboBox(SaveData.getInstance().getEnableCurrencies().toArray()));
        component.put("LABEL_START_AMOUNT",new JTextField());

        icon.put("LABEL_TITLE",Style.ICON_ACCOUNT_LABEL);
        icon.put("LABEL_START_AMOUNT",Style.ICON_START_AMOUNT);
        icon.put("LABEL_CURRENCIES",Style.ICON_CURRENCIES);

    }

    @Override
    protected void values() {
        Account account = (Account) c;
        values.put("LABEL_TITLE",account.getTitle());
        values.put("LABEL_CURRENCIES",account.getCurrency());
        values.put("LABEL_START_AMOUNT",account.getStartAmount());

    }

    @Override
    protected Common getCommonFromForm() throws ModelException {
        Account account = null;
        try {
            String tittle = ((JTextField) component.get("LABEL_TITLE")).getText();
            String start_amount = ((JTextField) component.get("LABEL_START_AMOUNT")).getText();
           Currency currency = (Currency)((CommonComboBox) component.get("LABEL_CURRENCIES")).getSelectedItem();
            account = new Account(tittle,currency, settings.Format.formatAmountToNumber(start_amount));

        } catch (NumberFormatException e) {
          throw  new ModelException(ModelException.AMOUNT_FORMAT);
        }
        return account;
    }
}
