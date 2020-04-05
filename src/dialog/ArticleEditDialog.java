package dialog;

import gui.MainFrame;
import objects.*;
import settings.Style;

import javax.swing.*;

public class ArticleEditDialog extends AddEditDialog {
    public ArticleEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void init() {

        component.put("LABEL_TITLE",new JTextField());

        icon.put("LABEL_TITLE",Style.ICON_ACCOUNT_LABEL);

    }

    @Override
    protected void values() {
        Account account = (Account) c;
        values.put("LABEL_TITLE",account.getTitle());

    }

    @Override
    public Common getCommonFromForm() throws ModelException {
        String title = ((JTextField) component.get("LABEL_TITLE")).getText();
        return new Article(title);
    }
}
