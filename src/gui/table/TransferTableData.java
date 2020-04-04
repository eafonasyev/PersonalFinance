package gui.table;
import gui.hundler.FunctionHundler;
import gui.table.TableData;
import gui.table.model.TransactionTableModel;
import gui.table.model.TransferTableModel;
import gui.table.rendered.MainTableSellRenderer;
import settings.Style;
import settings.Text;

import javax.swing.*;
import java.awt.*;

public class TransferTableData extends TableData {
    private static String[] columns = new String[]{"DATE","FROM_ACCOUNT","TO_ACCOUNT","FROM_AMOUNT","TO_AMOUNT","NOTICE"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_DATE,Style.ICON_FROM_ACCOUNT,Style.ICON_TO_ACCOUNT,Style.ICON_FROM_AMOUNT,Style.ICON_TO_AMOUNT,Style.ICON_NOTE};

    public TransferTableData(FunctionHundler hundler) {
        super(new TransferTableModel(columns),hundler,columns,icons);


    }

    @Override
    public void refresh() {
        super.refresh();
    }
/*private class TableCellAmountRendered extends MainTableSellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
             if (value.toString().contains("-")) renderer.setForeground(Style.COLOR_AMOUNT_NEGATIVE);
             else renderer.setForeground(Style.COLOR_AMOUNT_POSITIVE);
            return renderer;
        }

    }*/
}
