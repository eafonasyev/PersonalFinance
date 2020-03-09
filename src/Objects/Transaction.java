package Objects;

import saveLoad.SaveData;

import java.util.Date;

public class Transaction extends Common {
    private Article article;
    private Account account;
    private double amount;
    private String note;
    private Date date;

    public Transaction() {
    }

    public Transaction(Article article, Account account, double amount) throws ModelException{
        if(article == null) throw new ModelException(ModelException.ARTICLE_EMPTY);
        if(account == null) throw new ModelException(ModelException.ACCOUNT_EMPTY);
        this.article = article;
        this.account = account;
        this.amount = amount;
    }

    public Transaction(Article article, Account account, double amount, String note) throws ModelException{
        this(article,account,amount);
        this.note = note;
    }

    public Transaction(Article article, Account account, double amount, String note, Date date) throws ModelException{
        this(article,account,amount,note);
        this.date = date;
    }

    public Transaction(Article article, Account account, double amount, Date date) throws ModelException {
        this(article,account,amount);
        this.date = date;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "article=" + article +
                ", account=" + account +
                ", amount=" + amount +
                ", note='" + note + '\'' +
                ", date=" + date +
                '}';
    }


    @Override
    public void postAdd(SaveData sd) {
        setAmounts(sd);
    }
    @Override
    public void postEdit(SaveData sd) {
        setAmounts(sd);
    }
    @Override
    public void postRemove(SaveData sd) {
        setAmounts(sd);
    }
    private void setAmounts(SaveData sd) {
        for (Account a: sd.getAccounts()){
          a.setAmountFromTransactionAndTransfer(sd.getTransactions(),sd.getTransfers());
        }
    }
}

