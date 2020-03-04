package settings;

import Objects.Filter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Set;

public class Format {
    public static  String amount(double amount){
        return String.format(Settings.FORMAT_AMOUNT,amount);
    }
    public String amount(double amount, Currency currency){
        return amount(amount)+" "+currency.getCurrencyCode();
    }
    public static String rate(double rate){
        return String.format(Settings.FORMAT_RATE,rate);

    }

    public static String rate(double rate, Currency currency){
        return rate(rate)+" "+currency.getCurrencyCode();

    }
    public static String date(Date date){
        return dateFormat(date,Settings.DATE_FORMAT);
    }
    public  static String monthFormat(Date date){
        return dateFormat(date,Settings.DAY_MONTH);
    }
    public static String yearFormat(Date date){
        return dateFormat(date,Settings.MONTH_YEAR);
    }
    public static String dateFormat(Date date, String format){
        SimpleDateFormat adf = new SimpleDateFormat(format);
        return adf.format(date);

    }
    public static Double formatAmountToNumber(String amount) throws NumberFormatException{
        amount = amount.replace(",",".");
        return Double.parseDouble(amount);
    }
    public static String yesNo (boolean yes){
        if(yes) return Text.get("YES");
        return Text.get("NO");
    }
    public static String getTitleFilter(Filter filter){
        Date time = filter.getTo();
        switch (filter.getStep()){
            case Filter.STEP_DAY:
                date(time);
            case Filter.STEP_MONTH:
                monthFormat(time);
            case Filter.STEP_YEAR:
                yearFormat(time);

        }
        return null;
    }

}
