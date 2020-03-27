package gui.table;

import gui.table.model.MainTableModel;
import gui.table.model.TransactionTableModel;
import gui.table.rendered.MainTableSellRenderer;
import gui.table.rendered.TableHederIconRendered;
import settings.Style;
import settings.Text;

import javax.swing.*;
import java.awt.*;

public class TransactionTableData extends TableData {
    private static String[] columns = new String[]{"DATA","ACCOUNT","ARTICLES","AMOUNT","NOTICE"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_DATE,Style.ICON_ACCOUNTS,Style.ICON_ARTICLES,Style.ICON_AMOUNT,Style.ICON_NOTE};

    public TransactionTableData() {
        super(new TransactionTableModel(columns),columns,icons);
    }
    public TransactionTableData(int count) {
        super(new TransactionTableModel(columns,count),columns,icons);
        init();
    }

    private void init() {
        getColumn(Text.get("AMOUNT")).setCellRenderer(new TableCellAmountRendered());

    }
    private class TableCellAmountRendered extends MainTableSellRenderer{
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component rendered = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if(((String)value).contains("-")) rendered.setForeground(Style.COLOR_AMOUNT_NEGATIVE);
            else rendered.setForeground(Style.COLOR_AMOUNT_POSITIVE);
            return rendered;
        }
    }


}
