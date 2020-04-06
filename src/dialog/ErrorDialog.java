package dialog;

import gui.MainFrame;
import settings.Text;

import javax.swing.*;

public class ErrorDialog {
    public static void show(MainFrame frame, String text){
        JOptionPane.showMessageDialog(frame,Text.get(text),text,JOptionPane.ERROR_MESSAGE);
    }
}
