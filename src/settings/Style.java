package settings;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Style {

    public static final Color COLOR_BOTTON_HOVER = Color.green;
    public static final Color COLOR_AMOUNT_NEGATIVE = Color.RED;
    public static final Color COLOR_AMOUNT_POSITIVE = Color.green;
    public static final Color COLOR_BOTTON_NORMAL = new Color(240, 240, 240, 240);
    public static final Color COLOR_CURRENCY_OFF = Color.LIGHT_GRAY;
    public static final Color COLOR_CURRENCY_ON = Color.GRAY;

    public static final Font FONT_BOTTON_TOOLBAR = new Font("Roboto-ligth", Font.BOLD, 14);
    public static final Font FONT_BOTTON_MAIN = new Font("Roboto-ligth", Font.BOLD, 14);
    public static final Font FONT_PANEL_LEFT = new Font("Roboto-ligth", Font.BOLD, 12);

    public static final int PUDDING_BALLANCE = 3;
    public static final int PUDDING_BALLANCE_BIG = 15 ;
    public static final int PUDDING_EMPTY = 0;
    public static final int PUDDING_DIALOG = 10;

    public static final EmptyBorder EMPTY_BORDER = new EmptyBorder(10, 10, 10, 10);
    public static final EmptyBorder LEFT_PANEL_BORDER = new EmptyBorder(5, 5, 5, 5);
    public static final EmptyBorder BORDER_DIALOG = new EmptyBorder(10, 10, 10, 10);
    public static final int WIDTH_FILTER_BUTON = 200;
    public static EmptyBorder MAIN_TOOLBAR = new EmptyBorder(10,10,10,10);

    public static final Dimension DIMENTION_DIALOG_TEXFILD_SIZE = new Dimension(700,400);
    public static final Dimension DIMENTION_CHART = new Dimension(718,450);
    public static final Dimension DIMENTION_LEFT_PANEL = new Dimension(10,10);
    public static final Dimension DIMENTION_EDIT = new Dimension(300,500);

    public static final ImageIcon ICON_MAIN = new ImageIcon("image/pigs.png");
    public static final ImageIcon ICON_TOOLBAR_OVERVIEW = new ImageIcon("image/icon_toolbar_overview.png");
    public static final ImageIcon ICON_TOOLBAR_ACTICLES = new ImageIcon("image/icon_toolbar_articles.png");
    public static final ImageIcon ICON_TOOLBAR_STATISTICS = new ImageIcon("image/icon_toolbar_statistics.png");
    public static final ImageIcon ICON_TOOLBAR_TRANSACTIONS = new ImageIcon("image/icon_toolbar_transactions.png");
    public static final ImageIcon ICON_TOOLBAR_TRANSFER = new ImageIcon("image/ICON_TOOLBAR_TRANSFER2.png");
    public static final ImageIcon ICON_TOOLBAR_ACCOUNTS = new ImageIcon("image/icon_toolbar_accounts.png");
    public static final ImageIcon ICON_TOOLBAR_CURRENCIES = new ImageIcon("image/icon_toolbar_currencies.png");
    public static final ImageIcon ICON_TOOLBAR_HELP = new ImageIcon("image/ICON_TOOLBAR_HELP.png");
    public static final ImageIcon ICON_MENU_FILE = new ImageIcon("image/icon_menu_file.png");
    public static final ImageIcon ICON_MENU_EDIT = new ImageIcon("image/ICON_MENU_EDIT.png");
    public static final ImageIcon ICON_MENU_VIEW = new ImageIcon("image/ICON_MENU_VIEW.png");
    public static final ImageIcon ICON_MENU_HELP = new ImageIcon("image/ICON_MENU_HELP.png");
    public static final ImageIcon ICON_CANCEL = new ImageIcon("image/ICON_CANCEL.png");
    public static final ImageIcon ICON_ACCOUNT_LABEL = new ImageIcon("image/ICON_TITLE_ACCOUNT.png");
    public static final ImageIcon ICON_START_AMOUNT = new ImageIcon("image/ICON_START_AMOUNT.png");
    public static final ImageIcon ICON_CURRENCIES = new ImageIcon("image/ICON_CURRENCIES.png");
    public static final ImageIcon ICON_MENU_FILE_NEW = new ImageIcon("image/ICON_MENU_FILE_NEW.png");
    public static final ImageIcon ICON_MENU_FILE_OPEN = new ImageIcon("image/ICON_MENU_FILE_OPEN.png");
    public static final ImageIcon ICON_MENU_FILE_SAVE = new ImageIcon("image/ICON_MENU_FILE_SAVE.png");
    public static final ImageIcon ICON_MENU_FILE_EXIT = new ImageIcon("image/ICON_MENU_FILE_EXIT.png");
    public static final ImageIcon ICON_MENU_UPDATE_CURRINCIES = new ImageIcon("image/ICON_MENU_UPDATE_CURRINCIES.png");
    public static final ImageIcon ICON_EDIT_ADD = new ImageIcon("image/ICON_EDIT_ADD.png");
    public static final ImageIcon ICON_MENU_EDIT_EDIT = new ImageIcon("image/ICON_MENU_EDIT_EDIT.png");
    public static final ImageIcon ICON_MENU_EDIT_DELETE = new ImageIcon("image/ICON_MENU_EDIT_DELETE.png");
    public static final ImageIcon ICON_MENU_VIEW_ACCOUNTS = new ImageIcon("image/ICON_MENU_VIEW_ACCOUNTS.png");
    public static final ImageIcon ICON_MENU_VIEW_ARTICLES = new ImageIcon("image/ICON_MENU_VIEW_ARTICLES.png");
    public static final ImageIcon ICON_MENU_VIEW_CURRIENCIES = new ImageIcon("image/ICON_MENU_VIEW_CURRIENCIES.png");
    public static final ImageIcon ICON_MENU_VIEW_TRANSACTIONS = new ImageIcon("image/ICON_MENU_VIEW_TRANSACTIONS.png");
    public static final ImageIcon ICON_MENU_VIEW_TRANSFERS = new ImageIcon("image/ICON_MENU_VIEW_TRANSFERS.png");
    public static final ImageIcon ICON_MENU_VIEW_HELP = new ImageIcon("image/ICON_MENU_VIEW_HELP.png");
    public static final ImageIcon ICON_MENU_VIEW_STATISTICS = new ImageIcon("image/ICON_MENU_VIEW_STATISTICS.png");
    public static final ImageIcon ICON_INFO = new ImageIcon("image/ICON_INFO.png");
    public static final ImageIcon ADD = new ImageIcon("image/ADD.png");
    public static final ImageIcon EDIT = new ImageIcon("image/EDIT.png");
    public static final ImageIcon DELETE = new ImageIcon("image/DELETE.png");
    public static final ImageIcon ICON_DATE = new ImageIcon("image/ICON_DATE.png");
    public static final ImageIcon ICON_ARTICLES = new ImageIcon("image/ICON_MENU_VIEW_ARTICLES.png");
    public static final ImageIcon ICON_ACCOUNTS = new ImageIcon("image/ICON_MENU_VIEW_ACCOUNTS.png");
    public static final ImageIcon ICON_AMOUNT = new ImageIcon("image/ICON_AMOUNT.png");
    public static final ImageIcon ICON_NOTE = new ImageIcon("image/ICON_NOTE.png");
    public static final ImageIcon ICON_CODE = new ImageIcon("image/ICON_CODE.png");
    public static final ImageIcon ICON_ON = new ImageIcon("image/ICON_ON.png");
    public static final ImageIcon ICON_BASE = new ImageIcon("image/ICON_BASE.png");
    public static final ImageIcon ICON_RATE = new ImageIcon("image/ICON_RATE.png");
    public static final ImageIcon ICON_STATISTICS  = new ImageIcon("image/ICON_RATE.png");
    public static final ImageIcon ICON_FROM_ACCOUNT = new ImageIcon("image/ICON_FROM_ACCOUNT.png");
    public static final ImageIcon ICON_TO_ACCOUNT = new ImageIcon("image/ICON_TO_ACCOUNT.png");
    public static final ImageIcon ICON_FROM_AMOUNT = new ImageIcon("image/ICON_FROM_AMOUNT.png");
    public static final ImageIcon ICON_TO_AMOUNT = new ImageIcon("image/ICON_TO_AMOUNT.png");
    public static final ImageIcon ICON_LEFT = new ImageIcon("image/ICON_LEFT.png");
    public static final ImageIcon ICON_RIGHT = new ImageIcon("image/ICON_RIGHT.png");


}