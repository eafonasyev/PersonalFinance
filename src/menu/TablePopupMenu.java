package menu;

import gui.Refresh;
import gui.hundler.FunctionHundler;
import settings.HundlerCode;
import settings.Style;

import javax.swing.*;
import java.util.logging.Handler;

public class TablePopupMenu extends JPopupMenu implements Refresh {
    private  FunctionHundler handler;
    public TablePopupMenu(FunctionHundler hundler){
        super();
        this.handler = hundler;
        init();
    }

    private void init() {
        JMenuItem editItem = new JMenuItem("EDIT");
        JMenuItem deleteItem = new JMenuItem("DELETE");
        editItem.setActionCommand(HundlerCode.EDIT);
        deleteItem.setActionCommand(HundlerCode.DELETE);
        editItem.setIcon(Style.ICON_MENU_EDIT);
        deleteItem.setIcon(Style.ICON_MENU_EDIT_DELETE);

        editItem.addActionListener(handler);
        deleteItem.addActionListener(handler);

        add(editItem);
        add(deleteItem);
    }

    @Override
    public void refresh() {
        
    }
}
