import Objects.*;
import jdk.swing.interop.SwingInterOpUtils;
import saveLoad.SaveData;
import settings.Format;
import settings.Text;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaFinance {
    public static void main(String[] args) throws ModelException {
        init();
        testModel();
    }

    private static void init() {
        Text.init();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/18223.ttf")));
        } catch (FontFormatException | IOException e) {
            Logger.getLogger(PersonaFinance.class.getName()).log(Level.SEVERE,null,e);
            e.printStackTrace();

        }
    }
    public static void testModel() throws ModelException {
        try {
            Currency c1 = new Currency("Рубль","RUB",1,true,true);
            Currency c2 = new Currency("Тенге","KZT",3,true,true);
            Currency c3 = new Currency("Евро","EUR",55,false,false);
            Currency c4 = new Currency("Доллар","USD",27,true,false);

            Account ac1 = new Account("Кошелек",c1,1000);
            Account ac2 = new Account("visa",c4,3000);
            Account ac3 = new Account("Депозит KZT",c1,50000);

            Article article1 = new Article("Продукты");
            Article article2 = new Article("ЖКХ");
            Article article3 = new Article("Зарплата");
            Article article4 = new Article("Столовая");
            Article article5 = new Article("проценты по депозиту");

            ArrayList<Currency> currencies = new ArrayList();
            currencies.add(c1);
            currencies.add(c2);
            currencies.add(c3);
            currencies.add(c4);

            ArrayList<Account> accounts = new ArrayList();
            accounts.add(ac1);
            accounts.add(ac2);
            accounts.add(ac2);

            ArrayList<Article> articles = new ArrayList();
            articles.add(article1);
            articles.add(article2);
            articles.add(article3);
            articles.add(article4);
            articles.add(article5);

            ArrayList<Transaction> transactions = new ArrayList();
            transactions.add(new Transaction(article1,ac2,30000));
            transactions.add(new Transaction(article2,ac1,2500,"квартира"));
            transactions.add(new Transaction(article3,ac3,2700,"Халык"));

            SaveData sd = SaveData.getInstance();
            sd.setCurrencies(currencies);
            sd.setArticles(articles);
            sd.setAccounts(accounts);
            sd.save();
            System.out.println(sd);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
