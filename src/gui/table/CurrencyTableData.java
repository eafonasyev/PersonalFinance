package gui.table;
import gui.table.model.ArticleTableModel;
import gui.table.model.CurrencyTableModel;
import gui.table.rendered.MainTableSellRenderer;
import objects.Currency;
import saveLoad.SaveData;
import settings.Style;
import settings.Text;

import javax.swing.*;
import java.awt.*;

public class CurrencyTableData extends TableData {
    private static final String[] columns = new String[]{"TITLE_CURRENCY","CODE","RATE","ON","BASE"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_CURRENCIES,Style.ICON_CODE,Style.ICON_RATE,Style.ICON_ON,Style.ICON_BASE};

    public CurrencyTableData() {
        super(new CurrencyTableModel(columns),columns,icons);
        init();
    }

    @Override
    protected void init() {
        for(String column : columns){
            getColumn(Text.get(column)).setCellRenderer(new TableCellOnOffRenderer());
        }
    }
    private class TableCellOnOffRenderer extends MainTableSellRenderer{
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
           if (((Currency) ((CurrencyTableModel)table.getModel()).getObjectByRow(row)).getOn())
               renderer.setForeground(Style.COLOR_CURRENCY_ON);
           else renderer.setForeground(Style.COLOR_CURRENCY_OFF);
            return renderer;
        }
    }
}
