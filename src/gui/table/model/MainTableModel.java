package gui.table.model;

import gui.Refresh;
import objects.Common;
import settings.Text;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

abstract public class MainTableModel extends AbstractTableModel implements Refresh {
    protected List<? extends Common> data;
    protected List<String> column = new ArrayList<>();

    public MainTableModel(List<? extends Common> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return column.size();
    }

    @Override
    public String getColumnName(int column) {
        return Text.get(this.column.get(column));
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Object obj = getValueAt(0,columnIndex);
        return obj.getClass();
    }
    public void refresh(){
        updateData();
        fireTableStructureChanged();
        fireTableDataChanged();
    }

    protected abstract void updateData();
}
