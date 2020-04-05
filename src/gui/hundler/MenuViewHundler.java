package gui.hundler;


import gui.MainFileChooser;
import gui.MainFrame;
import gui.panel.*;
import settings.HundlerCode;

import java.awt.event.ActionEvent;

public class MenuViewHundler extends Hundler {
    MainFileChooser fc;
    public MenuViewHundler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()){
            case HundlerCode.MENU_VIEW_OVERVIEW:
                showOverviewPanel(frame);
                break;
            case HundlerCode.MENU_VIEW_ACCOUNTS:
                showAccountPanel(frame);
                break;
            case HundlerCode.MENU_VIEW_ARTICLES:
                showArticlePanel(frame);
                break;
            case HundlerCode.MENU_VIEW_CURRENCIES:
                showCurrenciesPanel(frame);
                break;
            case HundlerCode.MENU_VIEW_STATISTICS:
                showStatisticsPanel(frame);
                break;
            case HundlerCode.MENU_VIEW_TRANSACTIONS:
                showTransactionPanel(frame);
                break;
            case HundlerCode.MENU_VIEW_TRANSFERS:
                showTransferPanel(frame);
                break;
        }
        super.actionPerformed(ae);
    }

    protected void showOverviewPanel(MainFrame frame){
        frame.setRightPanel(new OverviewPanel(frame));
    }
    protected void showAccountPanel(MainFrame frame){
        frame.setRightPanel(new AccountPanel(frame));
    }
    protected void showArticlePanel(MainFrame frame){
        frame.setRightPanel(new ArticlePanel(frame));
    }
    protected void showCurrenciesPanel(MainFrame frame){
        frame.setRightPanel(new CurrenciesPanel(frame));
    }
    protected void showStatisticsPanel(MainFrame frame){
        frame.setRightPanel(new StatisticsPanel(frame));
    }
    protected void showTransactionPanel(MainFrame frame){
        frame.setRightPanel(new TransactionPanel(frame));
    }
    protected void showTransferPanel(MainFrame frame){
        frame.setRightPanel(new TransferPanel(frame));
    }

}
