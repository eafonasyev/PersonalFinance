package gui.table;
import gui.table.model.AccountTableModel;
import gui.table.model.TransactionTableModel;
import gui.table.rendered.MainTableSellRenderer;
import settings.Style;
import settings.Text;

import javax.swing.*;
import java.awt.*;

public class AccountTableData extends TableData {
    private static final String[] columns = new String[]{"ACCOUNTS","AMOUNT"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_ACCOUNTS,Style.ICON_AMOUNT};

    public AccountTableData() {
        super(new AccountTableModel(columns),columns,icons);

    }


}
