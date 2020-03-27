package gui.table.rendered;

import settings.Style;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TableHederIconRendered extends DefaultTableCellRenderer {

    private final JLabel label;

    public TableHederIconRendered(ImageIcon label) {
        this.label = new JLabel (label);
    }

    public Component getTableCellRenderComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column){
        TableCellRenderer trc = table.getTableHeader().getDefaultRenderer();
        Component rendered = trc.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
        label.setFont(Style.FONT_BOTTON_MAIN);
        label.setForeground(getForeground());
        label.setBorder(((JComponent)rendered).getBorder());
        label.setText(""+value);
        return label;
    }
}
