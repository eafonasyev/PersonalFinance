import jdk.swing.interop.SwingInterOpUtils;
import settings.Settings;
import settings.Text;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaFinance {
    public static void main(String[] args) {
        init();
        Settings.init();
        System.out.println(Text.get("PROGRAM_NAME"));
        System.out.println(Arrays.toString(Text.getMounth()));
    }

    private static void init() {
        Text.init();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
           // ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/18223.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, Settings.FONT_STILE));

        } catch (FontFormatException | IOException e) {
            Logger.getLogger(PersonaFinance.class.getName()).log(Level.SEVERE,null,e);
            e.printStackTrace();

        }
    }
}
