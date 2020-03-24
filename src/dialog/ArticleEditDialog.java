package dialog;

import gui.MainFrame;
import objects.*;
import saveLoad.SaveData;
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
    protected Common getCommonFromForm() throws ModelException {
        Article article = null;

            String tittle = ((JTextField) component.get("LABEL_TITLE")).getText();



        return article;
    }
}
