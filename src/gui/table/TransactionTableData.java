package gui.table;
import gui.hundler.FunctionHundler;
import gui.table.model.TransactionTableModel;
import gui.table.rendered.MainTableSellRenderer;
import settings.Style;
import settings.Text;

import javax.swing.*;
import java.awt.*;

public class TransactionTableData extends TableData {
    private static String[] columns = new String[]{"DATE","ACCOUNT","ARTICLES","AMOUNT","NOTICE"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_DATE,Style.ICON_ACCOUNTS,Style.ICON_ARTICLES,Style.ICON_AMOUNT,Style.ICON_NOTE};

    public TransactionTableData(FunctionHundler hundler) {
        super(new TransactionTableModel(columns),hundler,columns,icons);
        init();

    }
    public TransactionTableData(int count,FunctionHundler hundler) {
        super(new TransactionTableModel(columns,count),hundler,columns,icons);
        init();
    }

    protected void init() {
        getColumn(Text.get("AMOUNT")).setCellRenderer(new TableCellAmountRendered());

    }
    private class TableCellAmountRendered extends MainTableSellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
             if (value.toString().contains("-")) renderer.setForeground(Style.COLOR_AMOUNT_NEGATIVE);
             else renderer.setForeground(Style.COLOR_AMOUNT_POSITIVE);
            return renderer;
        }

    }
}
