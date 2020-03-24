package gui;

import dialog.*;
import menu.MainMenu;
import settings.Style;
import settings.Text;
import toolbar.MainToolBar;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements Refresh {

    private GridBagConstraints constraints;
    private final MainMenu  mb;
    private MainToolBar mainToolBar;
    public MainFrame(){
        super(Text.get("PROGRAM_NAME"));
        new CurrencyEditDialog(this).showDialog();
        setResizable(false);
        //setLocationRelativeTo(null);
        setSize(770,500);
        setIconImage(Style.ICON_MAIN.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainFileChooser fc = new MainFileChooser(this);
        fc.open();

        mb = new MainMenu(this);
        setJMenuBar(mb);

        setLayout(new GridLayout());
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;

        mainToolBar = new MainToolBar();
        add(mainToolBar,constraints);
        add(new MainDatePicker().getDatePicker());

        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.NORTH;


        //setLocationRelativeTo(null);



    }

    @Override
    public void refresh() {
       SwingUtilities.updateComponentTreeUI(this);
       pack();
       mb.refresh();
    }
}
