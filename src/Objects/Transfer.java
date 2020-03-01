package Objects;

import java.util.Date;
import java.util.List;

public class Transfer extends Common{
    private Account fromAccount;
    private Account toAccount;
    private double fromAmount;
    private double toAmount;
    private String note;
    private Date date;

    public Transfer() {
    }



    public Transfer(Account fromAccount, Account toAccount, double fromAmount, double toAmount) throws ModelException{
        if(fromAccount == null|| toAccount == null) throw new ModelException(ModelException.ACCOUNT_EMPTY);
        if(fromAmount < 0||toAmount < 0) throw  new ModelException(ModelException.AMOUNT_FORMAT);
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.fromAmount = fromAmount;
        this.toAmount = toAmount;
    }
    public Transfer(Account fromAccount, Account toAccount, double fromAmount, double toAmount, String note) throws  ModelException{
        this(fromAccount,toAccount,fromAmount,toAmount);
        this.note = note;
    }

    public Transfer(Account fromAccount, Account toAccount, double fromAmount, double toAmount, Date date) throws ModelException {
        this(fromAccount,toAccount,fromAmount,toAmount);
        this.date = date;
    }

    public Transfer(Account fromAccount, Account toAccount, double fromAmount, double toAmount, String note, Date date) throws ModelException{
        this(fromAccount,toAccount,fromAmount,toAmount,date);
        this.note = note;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "fromAccount=" + fromAccount +
                ", toAccount=" + toAccount +
                ", fromAmount=" + fromAmount +
                ", toAmount=" + toAmount +
                ", note='" + note + '\'' +
                ", date=" + date +
                '}';
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public double getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(double fromAmount) {
        this.fromAmount = fromAmount;
    }

    public double getToAmount() {
        return toAmount;
    }

    public void setToAmount(double toAmount) {
        this.toAmount = toAmount;
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
    public String getValueForComboBox() {
        return super.getValueForComboBox();
    }

}
