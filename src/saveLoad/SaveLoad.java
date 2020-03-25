package saveLoad;

import settings.Settings;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class SaveLoad {
    public static void save(SaveData sd){
        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

            Wrapper wrapper = new Wrapper();

            wrapper.setAccounts(sd.getAccounts());
            wrapper.setArticle(sd.getArticles());
            wrapper.setCurrencies(sd.getCurrencies());
            wrapper.setTransactions(sd.getTransactions());
            wrapper.setTransfers(sd.getTransfers());

            m.marshal(wrapper,Settings.getFileSaves());

        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
    public static void load(SaveData sd){
        try {
        JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Unmarshaller un = context.createUnmarshaller();
            Wrapper wrapper = (Wrapper) un.unmarshal(Settings.getFileSaves());
            sd.setAccounts(wrapper.getAccounts());
            sd.setArticles(wrapper.getArticle());
            sd.setCurrencies(wrapper.getCurrencies());
            sd.setTransactions(wrapper.getTransactions());
            sd.setTransfers(wrapper.getTransfers());
        } catch (JAXBException e) {
            System.out.println("Файл не существует!");
        }



    }
}
