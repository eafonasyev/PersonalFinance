package dialog;

import gui.MainFrame;
import objects.Account;
import objects.Common;
import objects.Currency;
import objects.ModelException;
import saveLoad.SaveData;
import settings.Format;
import settings.Settings;
import settings.Style;
import settings.Text;

import javax.swing.*;

public class CurrencyEditDialog extends AddEditDialog {
    public CurrencyEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void init() {
        component.put("LABEL_TITLE", new JTextField());
        component.put("LABEL_CODE", new JComboBox(Settings.CURRENCY_CODES));
        component.put("LABEL_RATE", new JTextField());
        component.put("LABEL_ON", new JComboBox(new String[]{Text.get("YES"), Text.get("NO")}));
        component.put("LABEL_BASE", new JComboBox(new String[]{Text.get("YES"), Text.get("NO")}));

        icon.put("LABEL_TITLE", Style.ICON_CURRENCIES);
        icon.put("LABEL_CODE", Style.ICON_CODE);
        icon.put("LABEL_RATE", Style.ICON_RATE);
        icon.put("LABEL_ON", Style.ICON_ON);
        icon.put("LABEL_BASE", Style.ICON_BASE);

        values.put("LABEL_RATE", Format.amount(1));
    }

    @Override
    protected void setValues() {
        Currency currency = (Currency) c;
        values.put("LABEL_TITLE", currency.getTitle());
        values.put("LABEL_CODE", currency.getCode());
        values.put("LABEL_RATE", currency.getRate());
        if (currency.getOn()) values.put("LABEL_ON", Text.get("YES"));
        else values.put("LABEL_ON", Text.get("NO"));
        if (currency.getBase()) values.put("LABEL_BASE", Text.get("YES"));
        else values.put("LABEL_BASE", Text.get("NO"));
    }

    @Override
    public Common getCommonFromForm() throws ModelException {
        try {
            String title = ((JTextField) component.get("LABEL_TITLE")).getText();
            String code = (String) ((JComboBox) component.get("LABEL_CODE")).getSelectedItem();
            String rate = ((JTextField) component.get("LABEL_RATE")).getText();
            boolean isOn = false;
            if (((JComboBox) component.get("LABEL_ON")).getSelectedItem().equals(Text.get("YES")))
                isOn = true;
            boolean isBase = false;
            if (((JComboBox) component.get("LABEL_BASE")).getSelectedItem().equals(Text.get("YES")))
                isBase = true;
            if (!isBase && c != null && ((Currency) c).getBase()) throw new ModelException(ModelException.NO_BASE_CURRENCY);
            return new Currency(title, code, Format.formatAmountToNumber(rate), isOn, isBase);

        } catch (NumberFormatException ex) {
            throw new ModelException(ModelException.AMOUNT_FORMAT);
        }
    }
}