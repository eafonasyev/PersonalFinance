package objects;

import saveLoad.SaveData;

import java.util.Objects;
import java.util.List;

public class Account extends Common{

    private String title;
    private Currency currency;
    private double startAmount;
    private double amount;

    public Account() {
    }

     public Account(String title){
        this.title = title;
     }

    public Account(String title, Currency currency, double startAmount) {
        this.title = title;
        this.currency = currency;
        this.startAmount = startAmount;
    }

    public Account(String title, Currency currency, double startAmount, double amount) throws ModelException{
        if(title.length()==0) throw new ModelException(ModelException.CODE_EMPTY);
        if(currency==null) throw new ModelException(ModelException.CURRENCY_EMPTY);
        this.title = title;
        this.currency = currency;
        this.startAmount = startAmount;
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Currency getCurrency() {
        return currency;
    }

    public  void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(double startAmount) {
        this.startAmount = startAmount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(title, account.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return title ;
    }

    @Override
    public String getValueForComboBox() {
        return title;
    }
    public void setAmountFromTransactionAndTransfer(List<Transaction> transactionList,List<Transfer>transferList){
     this.amount = startAmount;
     for(Transaction transaction : transactionList)
         if(transaction.getAccount().equals(this)){
             this.amount += transaction.getAmount();}
    for(Transfer transfer : transferList) {
         if (transfer.getFromAccount().equals(this)) {
             this.amount -= transfer.getFromAmount();
         }
         if(transfer.getToAccount().equals(this)){
             this.amount=+transfer.getToAmount();
         }
     }
    }

    @Override
    public void postAdd(SaveData sd) {

        setAmountFromTransactionAndTransfer(sd.getTransactions(), sd.getTransfers());
    }

    @Override
    public void postEdit(SaveData sd) {
        for(Transaction t : sd.getTransactions()) {
            if(t.getAccount().equals( sd.getOldCommon())) t.setAccount(this);
        }
        for (Transfer t : sd.getTransfers()){
            if(t.getFromAccount().equals(sd.getOldCommon())) t.setFromAccount(this);
            if(t.getToAccount().equals(sd.getOldCommon())) t.setToAccount(this);
        }
        setAmountFromTransactionAndTransfer(sd.getTransactions(), sd.getTransfers());

    }
}
