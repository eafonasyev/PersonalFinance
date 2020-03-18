package toolbar;

import gui.EnableEditDelete;
import gui.MainButton;
import settings.HundlerCode;
import settings.Style;
import settings.Text;

public class FuctionToolbar extends AbstractToolBar implements EnableEditDelete {

    private MainButton editButtton;
    private MainButton deleteButton;
    public FuctionToolbar(){
        super();
        init();
    }
    @Override
    protected void init() {
        addButton(Text.get("ADD"),Style.ADD,HundlerCode.ADD,false);
        editButtton = addButton(Text.get("EDIT"),Style.EDIT,HundlerCode.EDIT,false);
        deleteButton = addButton(Text.get("DELETE"),Style.DELETE,HundlerCode.DELETE,false);
    }

    @Override
    public void setEnableEditDelete(boolean action) {
        deleteButton.setEnabled(false);
        editButtton.setEnabled(false);
    }
}
