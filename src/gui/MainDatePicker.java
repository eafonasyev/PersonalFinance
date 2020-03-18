package gui;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class MainDatePicker {
    private final JDatePickerImpl datePicker;
    public MainDatePicker(){

        UtilDateModel dateModel = new UtilDateModel();
        Properties properties = new Properties();
        JDatePanelImpl panel = new JDatePanelImpl(dateModel,properties);
        datePicker = new JDatePickerImpl(panel,new DateComponentFormatter());
        dateModel.setValue(new Date());
    }

    public JDatePickerImpl getDatePicker() {
        return datePicker;
    }

    public  void setValue(Date date){
        ((UtilDateModel) datePicker.getModel()).setValue(date);
    }
}
