package settings;

import org.ini4j.Ini;
import org.ini4j.IniPreferences;
import org.ini4j.Wini;
import saveLoad.SaveData;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

public class Settings {

    public static final File FONT_STILE = new File("fonts/18223.ttf");
    public static final File saveDir = new File("saves/");
    public static final String FORMAT_AMOUNT = "%.2f";
    public static final String FORMAT_RATE = "%.f";
    public static final String DATE_FORMAT = "dd.MM.yyyy";
    public static final String DAY_MONTH = "MM.yyyy";
    public static final String MONTH_YEAR= "dd.MM.yyyy";

    public static final int COUNT_OVERVIEW_ROWS = 10;

    public static final String[] CURRENCY_CODES = new String[]{"RUB","USA","KZT","EUR","FRK"};

    public  static final File FILE_SETTINGS =  new File("saves/settings.ini");
    public  static  File FILE_SAVES = new File("saves/save_file1.ini");

    public static void init(){
        try {
            Ini ini = new Ini(FILE_SETTINGS);
            Preferences pref = new IniPreferences(ini);
            String file = pref.node("settings").get("FILE_SETTINGS",null);
            if (file != null) FILE_SAVES =  new File(file);
            selLocale();

        } catch (IOException e) {
            save();
        }


    }

    private static void selLocale() {
        Locale.setDefault(new Locale("RU"));
    }

    public static File getFileSaves() {
        return FILE_SAVES;
    }

    public static void setFileSaves(File fileSaves) {
        FILE_SAVES = fileSaves;
        save();
    }

    private static void save() {
        try {
            Wini wini = new Wini(FILE_SETTINGS);
            wini.put("settings", "FILE_SAVE", FILE_SAVES.getAbsolutePath().replace("\\", "\\\\"));
            wini.store();
        }
        catch (IOException ex){
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
