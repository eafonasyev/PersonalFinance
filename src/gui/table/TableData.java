package gui.table;

import gui.Refresh;
import gui.table.model.MainTableModel;
import gui.table.rendered.MainTableSellRenderer;
import gui.table.rendered.TableHeaderIconRenderer;
import menu.TablePopupMenu;
import settings.Style;
import settings.Text;

import javax.swing.*;
import java.awt.*;

abstract public class TableData extends JTable implements Refresh {

    private final TablePopupMenu popup;
    private final String[] columns;
    private final ImageIcon[] icons;
    public  TableData(MainTableModel tableModel,String[] columns,ImageIcon[] icons){
        super(tableModel);
        this.columns = columns;
        this.icons = icons;
        popup = new TablePopupMenu();
        getTableHeader().setFont(Style.FONT_PANEL_LEFT);
        setFont(Style.FONT_PANEL_LEFT);
        setRowHeight(getRowHeight()+Style.PUDDING_BALLANCE);

        setAutoCreateRowSorter(true);
        setPreferredScrollableViewportSize(Style.DIMENTION_DIALOG_TEXFILD_SIZE);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        for (int i = 0; i < columns.length; i++) {
            getColumn(Text.get(columns[i])).setHeaderRenderer(new TableHeaderIconRenderer(icons[i]));
        }

        MainTableSellRenderer renderer = new MainTableSellRenderer();
        setDefaultRenderer(String.class, renderer);
        setComponentPopupMenu(popup);
    }



 /*
    @Override
    public JPopupMenu getComponentPopupMenu() {
        Point p = getMousePosition();
        int row = rowAtPoint(p);
        if (p != null && rowAtPoint(p) != -1){
            return getComponentPopupMenu();
      }
        return getComponentPopupMenu();
    }
*/
    public void refresh() {
        init();
        int selectedRow = getSelectedRow();
        ((MainTableModel) getModel()).refresh();
       /*  for (int i = 1; i < columns.length; i++){
            getColumn(Text.get(columns[i])).setHeaderRenderer(new TableHeaderIconRenderer(icons[i]));
        }
        if(selectedRow != -1 && selectedRow < getRowCount())setRowSelectionInterval(selectedRow,selectedRow);*/
    }
    protected void init(){

    }

}
