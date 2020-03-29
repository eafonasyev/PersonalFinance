package gui.panel;

import gui.MainFrame;
import objects.Currency;
import objects.Statistics;
import saveLoad.SaveData;
import settings.Format;
import settings.Style;
import settings.Text;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends AbstractPanel {
    public LeftPanel(MainFrame frame) {
        super(frame);
        init();
    }

    @Override
    protected void init() {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(Style.LEFT_PANEL_BORDER);
        JLabel headerBC = new JLabel(Text.get("BALANCE_CURRENCIES"));
        headerBC.setFont(Style.FONT_PANEL_LEFT);
        headerBC.setIcon(Style.ICON_CURRENCIES);
        headerBC.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(headerBC);
        addBalanceCurrency();

        add(Box.createVerticalStrut(Style.PUDDING_BALLANCE_BIG));

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(Style.LEFT_PANEL_BORDER);
        JLabel headerBB = new JLabel(Text.get("BALANCE_CURRENCIES_B"));
        headerBB.setFont(Style.FONT_PANEL_LEFT);
        headerBB.setIcon(Style.ICON_CURRENCIES);
        headerBB.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(headerBB);
        addBalance();
    }

    private void addBalance() {
        for(Currency currency : SaveData.getInstance().getCurrencies()) {
            add(Box.createVerticalStrut(Style.PUDDING_BALLANCE));
            add(new PanelBalanceCurrency(currency, Statistics.getBalance(currency)));
        }
    }

    private void addBalanceCurrency() {
        for(Currency currency : SaveData.getInstance().getCurrencies()) {
            add(Box.createVerticalStrut(Style.PUDDING_BALLANCE));
            add(new PanelBalanceCurrency(currency, Statistics.getBalanceCurrency(currency)));
        }
    }
    private class PanelBalanceCurrency extends JPanel{
        public PanelBalanceCurrency(Currency currency ,Double amount) {
            super();
            setLayout(new BorderLayout());
            setBackground(Color.WHITE);
            setBorder(Style.LEFT_PANEL_BORDER);

            JLabel currencyLaybel = new JLabel(currency.getTitle());
            JLabel amountLaybel = new JLabel(Format.amount(amount,currency));

            currencyLaybel.setFont(Style.FONT_PANEL_LEFT);
            amountLaybel.setFont(Style.FONT_PANEL_LEFT);

            add(currencyLaybel,BorderLayout.WEST);
            add(Box.createRigidArea(Style.DIMENTION_LEFT_PANEL));
            add(amountLaybel,BorderLayout.EAST);

        }
    }
}
