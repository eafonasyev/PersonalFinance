package objects;

import saveLoad.SaveData;

import java.util.HashMap;
import java.util.List;

public class Statistics {
    public static Double getBalanceCurrency(Currency currency){
        SaveData sd = SaveData.getInstance();
        double amount = 0;
        for(Account account:sd.getAccounts()){
            if(currency.equals(account.getCurrency())) amount +=account.getAmount();
        }
        return amount;
    }
    public static Double getBalance(Currency currency){
        SaveData sd = SaveData.getInstance();
        double amount = 0;
        for(Account account : sd.getAccounts()){
            amount +=account.getAmount()* account.getCurrency().getRateByCurrency(currency);
        }
        return amount;
    }
    private static double round(double value){
        return (double) Math.round(value*100)/100;
    }

    public static HashMap<String,Double> getDataForChartIncomeArticles(){

        return   getDataForChartOnArticles(true);
    }

    public static HashMap<String,Double> getDataForChartExpArticles(){

        return   getDataForChartOnArticles(false);
    }

    public static HashMap<String,Double> getDataForChartOnArticles(boolean income){
        List<Transaction> transactions = SaveData.getInstance().getFilterTransaction();
        HashMap<String,Double> data = new HashMap<>();
        for (Transaction t : transactions){
            if((income && t.getAmount()> 0) || (!income && t.getAmount() < 0)){
                String key = t.getArticle().getTitle();
                double summa = 0;
                double amount = t.getAmount();
                if(!income) amount *= -1;
                if(data.containsKey(key)) summa = data.get(key);
                summa += amount * t.getAccount().getCurrency().getRateByCurrency(SaveData.getInstance().getBaseCurency());
                data.put(key,round(summa));
            }
        }
        return data;
    }
}
