package dialog;

import gui.MainButton;
import gui.MainFrame;
import objects.*;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import settings.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

abstract public class AddEditDialog extends JDialog {
    public final MainFrame  frame;
    protected LinkedHashMap<String,JComponent> component = new LinkedHashMap<>();
    protected LinkedHashMap<String,ImageIcon>  icon = new LinkedHashMap<>();
    protected LinkedHashMap<String,Object>     values = new LinkedHashMap<>();
    protected Common c;

    public AddEditDialog(MainFrame frame){
        super(frame,Text.get("ADD"),true);
        this.frame = frame;
        setResizable(true);

    }

    public Common getCommon() {
        return c;
    }

    public void setCommon(Common c) {
        this.c = c;
    }
    public final void showDialog(){
        setDialog();
        setVisible(true);
    }
    public final void closeDialog(){
        setVisible(false);
        this.c = null;
        values.clear();
        component.clear();
        icon.clear();
        dispose();
    }
    public boolean isAdd (){
        return c == null;
    }
    abstract protected void init();
    abstract  protected  void values();
    abstract protected Common getCommonFromForm() throws ModelException;


    private void setDialog() {
        init();
    if(isAdd()){
        setTitle("ADD");
        setIconImage(Style.ICON_EDIT_ADD.getImage());}
    else{
            setTitle("EDIT");
            setIconImage(Style.ICON_EDIT_ADD.getImage());
        }
     getContentPane().removeAll();
     getContentPane().setLayout(new BoxLayout( getContentPane(),BoxLayout.Y_AXIS));
        ((JPanel)getContentPane()).setBorder(Style.BORDER_DIALOG);
        ((JPanel)getContentPane()).setPreferredSize(Style.DIMENTION_EDIT);
        System.out.println("ghxjhv");
        for(Map.Entry<String, JComponent> entry : component.entrySet()){
            String key = entry.getKey();
            JLabel label = new JLabel(Text.get(key));
            label.setIcon(icon.get(key));
            label.setFont(Style.FONT_BOTTON_MAIN);
            JComponent component = entry.getValue();

            if (component instanceof JTextField){
                component.setPreferredSize(Style.DIMENTION_DIALOG_TEXFILD_SIZE);
                if(values.containsKey(key)) ((JTextField)component).setText(""+ values.get(key));

            }
            else if (component instanceof  JComboBox){
                if(values.containsKey(key)){
                    ((JComboBox)component).setSelectedItem(values.get(key));
                }
            }
            else if(component instanceof JDatePicker){
                if(values.containsKey(key)){
                    ((UtilDateModel)((JDatePickerImpl)component).getModel()).setValue((Date) values.get(key));
                }
            }
            component.setAlignmentX(JComponent.LEFT_ALIGNMENT);
            add(label);
            add(Box.createVerticalStrut(Style.PUDDING_DIALOG));
            add(component);
            add(Box.createVerticalStrut(Style.PUDDING_DIALOG));
        }
        MainButton ok = new MainButton(Text.get("ADD"),Style.ICON_EDIT_ADD,null,HundlerCode.ADD);
        if(!isAdd()){
            ok.setText("EDIT");
            ok.setActionCommand("EDIT");
        }
        MainButton cancel = new MainButton(Text.get("CANCEL"),Style.ICON_CANCEL,null,HundlerCode.CANCEL);
        JPanel panelButton = new JPanel();
        panelButton.setLayout(new BorderLayout());
        panelButton.add(ok,BorderLayout.WEST);
        panelButton.add(cancel,BorderLayout.EAST);
        add(panelButton);
        panelButton.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        pack();
        setLocationRelativeTo(null);
    }


    protected class CommonComboBox extends JComboBox{
        public CommonComboBox(Object[] obj){
            super(obj);
            setRenderer( new DefaultListCellRenderer(){
                             @Override
                             public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                                 DefaultListCellRenderer renderer = (DefaultListCellRenderer) super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
                                 Common c = (Common)value;
                                 if(c!=null) renderer.setText(c.toString());
                                 return renderer;
                             }
                         }

            );
        }
    }
}
