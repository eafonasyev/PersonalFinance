package menu;

import gui.EnableEditDelete;
import gui.MainFrame;
import gui.Refresh;
import gui.hundler.Hundler;
import gui.hundler.MenuFileHundler;
import org.w3c.dom.html.HTMLAnchorElement;
import settings.HundlerCode;
import settings.Settings;
import settings.Style;
import settings.Text;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JMenuBar implements Refresh, EnableEditDelete {
    private JMenuItem menuEdit;
    private JMenuItem menuDelete;
    private final MainFrame frame;

    public MainMenu(MainFrame frame){
        super();
        this.frame = frame;
        init();

    }

    private void init(){
        JMenu file = new JMenu(Text.get("MENU_FILE"));
        JMenu edit = new JMenu(Text.get("MENU_EDIT"));
        JMenu view = new JMenu(Text.get("MENU_VIEW"));
        JMenu help = new JMenu(Text.get("MENU_HELP"));

        file.setIcon(Style.ICON_MENU_FILE);
        edit.setIcon(Style.ICON_MENU_EDIT);
        view.setIcon(Style.ICON_MENU_VIEW);
        help.setIcon(Style.ICON_MENU_HELP);

        add(file);
        add(edit);
        add(view);
        add(help);

        MenuFileHundler fileHundler = new MenuFileHundler(frame);
        MenuFileHundler editHundler = new MenuFileHundler(frame);
        MenuFileHundler viewHundler = new MenuFileHundler(frame);
        MenuFileHundler helpHundler = new MenuFileHundler(frame);


        addMenuItem(file,fileHundler,Text.get("FILE_MENU_NEW"),Style.ICON_MENU_FILE_NEW,HundlerCode.MENU_FILE_NEW);
        addMenuItem(file,fileHundler,Text.get("FILE_MENU_OPEN"),Style.ICON_MENU_FILE_OPEN,HundlerCode.MENU_FILE_OPEN);
        addMenuItem(file,fileHundler,Text.get("FILE_MENU_SAVE"),Style.ICON_MENU_FILE_SAVE,HundlerCode.MENU_FILE_SAVE);
        addMenuItem(file,fileHundler,Text.get("FILE_MENU_UPDATE_CURRINCIES"),Style.ICON_MENU_UPDATE_CURRINCIES,HundlerCode.MENU_FILE_UPDATE_CURRINCIES);
        addMenuItem(file,fileHundler,Text.get("FILE_MENU_EXIT"),Style.ICON_MENU_FILE_EXIT,HundlerCode.MENU_FILE_EXIT);

        addMenuItem(edit,editHundler,Text.get("MENU_EDIT_ADD"),Style.ICON_EDIT_ADD,HundlerCode.MENU_EDIT_ADD);
        menuEdit = addMenuItem(edit,editHundler,Text.get("MENU_EDI_EDIT"),Style.ICON_MENU_EDIT_EDIT,HundlerCode.MENU_EDIT_EDIT);
        menuDelete = addMenuItem(edit,editHundler,Text.get("MENU_EDIT_DELETE"),Style.ICON_MENU_EDIT_DELETE,HundlerCode.MENU_EDIT_DELETE);
        menuEdit.setEnabled(false);
        menuDelete.setEnabled(false);
        addMenuItem(view,viewHundler,Text.get("MENU_VIEW_OVERVIEW"),Style.ICON_TOOLBAR_OVERVIEW,HundlerCode.MENU_VIEW_OVERVIEW);
        addMenuItem(view,viewHundler,Text.get("MENU_VIEW_ACCOUNTS"),Style.ICON_MENU_VIEW_ACCOUNTS,HundlerCode.MENU_VIEW_ACCOUNTS);
        addMenuItem(view,viewHundler,Text.get("MENU_VIEW_ARTICLES"),Style.ICON_MENU_VIEW_ARTICLES,HundlerCode.MENU_VIEW_ARTICLES);
        addMenuItem(view,viewHundler,Text.get("MENU_VIEW_TRANSACTIONS"),Style.ICON_MENU_VIEW_TRANSACTIONS,HundlerCode.MENU_VIEW_TRANSACTIONS);
        addMenuItem(view,viewHundler,Text.get("MENU_VIEW_TRANSFERS"),Style.ICON_MENU_VIEW_TRANSFERS,HundlerCode.MENU_VIEW_TRANSFERS);
        addMenuItem(view,viewHundler,Text.get("MENU_VIEW_HELP"),Style.ICON_MENU_VIEW_HELP,HundlerCode.MENU_VIEW_HELP);
        addMenuItem(view,viewHundler,Text.get("MENU_VIEW_STATISTICS"),Style.ICON_MENU_VIEW_STATISTICS,HundlerCode.MENU_VIEW_STATISTICS);
        addMenuItem(view,viewHundler,Text.get("MENU_VIEW_CURRENCIES"),Style.ICON_MENU_VIEW_CURRIENCIES,HundlerCode.MENU_VIEW_CURRENCIES);

        addMenuItem(help,helpHundler,Text.get("MENU_HELP_ABOUT"),Style.ICON_MENU_HELP,HundlerCode.MENU_HELP_ABOUT);
    }
    private JMenuItem addMenuItem(JMenu menu,Hundler lisener, String menuName, ImageIcon icon, String action, int key){
        JMenuItem item = new JMenuItem(menuName);
        item.setIcon(icon);
        item.setActionCommand(action);
        item.addActionListener(lisener);
        if(key != 0 ){
           KeyStroke stroke = KeyStroke.getKeyStroke(key, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());

        }
        menu.add(item);
    return item;
    }

    private JMenuItem addMenuItem(JMenu menu,Hundler lisener,String menuName,ImageIcon icon,String action){
        return  addMenuItem(menu,lisener, menuName,icon, action,0);
    }

    @Override
    public void setEnableEditDelete(boolean action) {
       menuEdit.setEnabled(action);
       menuDelete.setEnabled(action);
    }

    @Override
    public void refresh() {
        removeAll();
        init();
    }
}
