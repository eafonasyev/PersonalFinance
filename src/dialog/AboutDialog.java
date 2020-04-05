package dialog;

import settings.Text;

import javax.swing.*;

public class AboutDialog extends JDialog {
    public AboutDialog(){
        super();
        init();
        setTitle(Text.get("DIALOG_ABOUT"));
        setResizable(false);
    }
    private void init() {
        JEditorPane pane = new JEditorPane("text/html", Text.get("ABOUT"));
        pane.setEditable(false);
        pane.setOpaque(false);
        add(pane);
        pack();
        setLocationRelativeTo(null);
        setSize(500,300);

    }


}
