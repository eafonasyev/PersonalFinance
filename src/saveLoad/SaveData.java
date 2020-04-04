package saveLoad;

import objects.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class SaveData extends Common{

    public static SaveData instance;

    @Override
    public String toString() {
        return "SaveData{" +
                "accounts=" + accounts +
                ", currencies=" + currencies +
                ", articles=" + articles +
                ", transactions=" + transactions +
                ", transfers=" + transfers +
                ", oldCommon=" + oldCommon +
                '}';
    }

    private List<Account> accounts = new ArrayList<>();
    private List<Currency> currencies = new ArrayList<>();
    private List<Article> articles = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();
    private List<Transfer> transfers = new ArrayList<>();
    private final Filter filter;
    private  Common oldCommon;
    private boolean saved = true;

    public  Common getOldCommon() {
        return oldCommon;
    }

    public SaveData() {
        load();
        this.filter = new Filter();

    }
    public void load(){
       SaveLoad.load(this);
       //sort();
        for(Account a : accounts){
            a.setAmountFromTransactionAndTransfer(transactions,transfers);
        }
    }
    public void save(){
        SaveLoad.save(this);
        saved = true;
    }
    public boolean isSaved(){
        return saved;
    }
    private void sort(){
        this.articles.sort((Article t, Article t1) -> t.getTitle().compareTo(t1.getTitle()));
        this.accounts.sort((Account t, Account t1) -> t.getTitle().compareTo(t1.getTitle()));
        this.transactions.sort((Transaction t, Transaction t1) -> (int)t.getDate().compareTo(t1.getDate()));
        this.transfers.sort((Transfer t, Transfer t1) -> (int)t.getDate().compareTo(t1.getDate()));
        this.currencies.sort(new Comparator<Currency>() {
            @Override
            public int compare(Currency c, Currency c1) {
                if(c.getBase()) return -1;
                if(c1.getBase()) return 1;
                if (c.getOn()|c1.getOn()){
                    if(c1.getOn()) return 1;
                    else
                        return -1;

                }
                return c.getTitle().compareToIgnoreCase(c1.getTitle());
            }
        });

    }

    public static SaveData getInstance(){
        if(instance==null) instance = new SaveData();
            return instance;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        if(accounts!=null)this.accounts = accounts;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        if(currencies!=null)this.currencies = currencies;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        if(articles!=null) this.articles = articles;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        if(transactions!=null)  this.transactions = transactions;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers)
    {
        if(transfers!=null) this.transfers = transfers;
    }
    public Currency getBaseCurency(){
        for(Currency c : currencies){
            if(c.getBase()) return c;
        }
        return new Currency();
    }
    public ArrayList<Currency> getEnableCurrencies(){
        ArrayList  list = new ArrayList<>();
        for(Currency c : currencies)
            if(c.getOn()) list.add(c);
        return list;
    }
    public List<Transaction> getFilterTransaction(){
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        for(Transaction tr : transactions){
            if(filter.checkDate(tr.getDate())) list.add(tr);
        }
        return list;
    }
    public List<Transfer> getFilterTransfers(){
        ArrayList<Transfer> list = new ArrayList<Transfer>();
        for(Transfer tr : transfers){
            if(filter.checkDate(tr.getDate())) list.add(tr);
        }
        return list;
    }
    public List<Transaction> transactionsCount(int count){
        return new ArrayList(transactions.subList(0,Math.min(count,transactions.size())));
    }
   public void add (Common c) throws ModelException{
           List ref = getRef(c);
           if(ref.contains(c)) throw new ModelException(ModelException.IS_EXIST);
           ref.add(c);
           c.postAdd(this);
           sort();
           saved = false;
    }
    public void edit(Common oldC, Common newC) throws ModelException {
        List ref = getRef(oldC);
        if (ref.contains(newC) && oldC != ref.get(ref.indexOf(newC))) throw new ModelException(ModelException.IS_EXIST);
        ref.set(ref.indexOf(oldC),newC);
        oldCommon = oldC;
        newC.postEdit(this);
        sort();
        saved = false;

    }
    public void remove(Common c){
        getRef(c).remove(c);
        c.postRemove(this);
        saved = false;
    }
    private List getRef(Common c){
        if (c instanceof Account) return  accounts;
        else if (c instanceof Article) return articles;
        else if (c instanceof Transfer) return transfers;
        else if (c instanceof Transaction) return  transactions;
        else if (c instanceof Currency) return currencies;
        return null;
    }
    public void updateCurencies() throws Exception {
        HashMap<String,Double> rates = RateCurrency.getRates(getBaseCurency());
        for(Currency c : currencies){
             c.setRate(rates.get(c.getCode()));
        }

        for(Account a : accounts){
            a.getCurrency().setRate(rates.get(a.getCurrency().getCode()));
        }
        saved = false;
    }

    public Filter getFilter() {
        return filter;
    }
    public void  clear(){
        transactions.clear();;
        transfers.clear();
        articles.clear();
        accounts.clear();
        currencies.clear();
    }
}
