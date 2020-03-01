package saveLoad;

import Objects.*;

import java.util.ArrayList;
import java.util.List;

public class SaveData {

    public static SaveData instance;
    private List<Account> accounts = new ArrayList<>();
    private List<Currency> currencies = new ArrayList<>();
    private List<Article> articles = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();
    private List<Transfer> transfers = new ArrayList<>();

    public static SaveData getInstance(){
        if(instance==null) instance = new SaveData();
            return instance;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }
    public Currency getBaseCurency(){
        for(Currency c : currencies){
            if(c.getBase()) return c;
        }
        return new Currency();
    }
}
