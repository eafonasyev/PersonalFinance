package dialog;

import gui.MainFrame;
import settings.Style;
import settings.Text;

import javax.swing.*;

public class ConfirmDialog {
    public static int  show(MainFrame frame,String text,String tittle){
        String[] options = new String[]{Text.get("YES"),Text.get("NO")};
        int result = JOptionPane.showOptionDialog(frame,text,tittle,JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,Style.ICON_INFO,options,options[1]);
        return result;
    }
}
