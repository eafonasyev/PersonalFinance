package toolbar;

import settings.HundlerCode;
import settings.Style;
import settings.Text;

public final class MainToolBar extends AbstractToolBar {
    public MainToolBar(){
        super();
        setBorder(Style.MAIN_TOOLBAR);
        init();
    }

    @Override
    protected void init() {
        addButton(Text.get("TOOLBAR_OVERVIEW"),Style.ICON_TOOLBAR_OVERVIEW,HundlerCode.TOOLBAR_OVERVIEW,true);
        addButton(Text.get("TOOLBAR_ARTICLES"),Style.ICON_TOOLBAR_ACTICLES,HundlerCode.TOOLBAR_ARTICLES,true);
        addButton(Text.get("TOOLBAR_ACCOUNTS"),Style.ICON_TOOLBAR_ACCOUNTS,HundlerCode.TOOLBAR_ACCOUNTS,true);
        addButton(Text.get("TOOLBAR_TRANSACTIONS"),Style.ICON_TOOLBAR_TRANSACTIONS,HundlerCode.TOOLBAR_TRANSACTIONS,true);
        addButton(Text.get("TOOLBAR_CURRENCIES"),Style.ICON_TOOLBAR_CURRENCIES,HundlerCode.TOOLBAR_CURRENCIES,true);
        addButton(Text.get("TOOLBAR_STATISTICS"),Style.ICON_TOOLBAR_STATISTICS,HundlerCode.TOOLBAR_STATISTICS,true);
        addButton(Text.get("TOOLBAR_HELP"),Style.ICON_TOOLBAR_HELP,HundlerCode.TOOLBAR_HELP,true);
    }
}
