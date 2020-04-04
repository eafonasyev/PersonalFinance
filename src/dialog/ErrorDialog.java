package dialog;

import gui.MainFrame;
import settings.Text;

import javax.swing.*;

public class ErrorDialog {
    public static void show(MainFrame frame, String text){
        JOptionPane.showMessageDialog(frame,text,Text.get(text),JOptionPane.ERROR_MESSAGE);
    }
}
