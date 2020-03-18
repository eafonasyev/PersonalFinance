package saveLoad;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.text.SimpleDateFormat;
import objects.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RateCurrency  {

    public static HashMap<String,Double> getRates(Currency base) throws Exception{
        HashMap<String,NodeList> result = new HashMap();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        String url = "http://cbr.ru/scripts/XML_daily.asp?date_req="+dateFormat.format(new Date());
        System.out.println(url);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            Document doc = factory.newDocumentBuilder().parse(new URL(url).openStream());
            NodeList nl = doc.getElementsByTagName("Valute");
            for(int i = 0; i < nl.getLength(); i++){
                Node node = nl.item(i);
                NodeList nodeList = node.getChildNodes();
                for (int j = 0; j < nodeList.getLength(); j++){
                    if(nodeList.item(j).getNodeName().equals("CharCode")){
                       result.put(nodeList.item(j).getTextContent(),nodeList);
                    }
                }
            }
            HashMap<String,Double> rates = new HashMap<>();
            for (Map.Entry<String,NodeList> entry : result.entrySet()){
               NodeList temp = entry.getValue();
               double value = 0;
               int nominal = 0;
               for (int i = 0; i < temp.getLength(); i++){
                   if(temp.item(i).getNodeName().equals("Value")) {
                       value = Double.parseDouble(temp.item(i).getTextContent().replace(",", "."));
                   }
                   else if (temp.item(i).getNodeName().equals("Nominal")){
                       nominal = Integer.parseInt(temp.item(i).getTextContent());
                   }
                   double amount = value/nominal;
                   rates.put(entry.getKey(),((double)(Math.round(amount*1000))/1000));
               }
            }

        rates.put("RUB",1.0);
            double div = rates.get(base.getCode());
            for (Map.Entry<String,Double> entry : rates.entrySet()){
                entry.setValue(entry.getValue()/div);
            }

       return rates;

    }
}
