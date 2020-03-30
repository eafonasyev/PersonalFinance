package gui;

import gui.panel.*;
import menu.MainMenu;
import settings.Style;
import settings.Text;
import toolbar.MainToolBar;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements Refresh {

    private GridBagConstraints constraints;

    private final MainMenu  mb;
    private MainToolBar tb;
    private LeftPanel leftPanel;
    private RightPanel rightPanel;
    public MainFrame(){
        super(Text.get("PROGRAM_NAME"));
        setResizable(false);
        setIconImage(Style.ICON_MAIN.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mb = new MainMenu(this);
        setJMenuBar(mb);

        setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;

        tb = new MainToolBar();
        add(tb,constraints);

        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.NORTH;

        leftPanel = new LeftPanel(this);
        add(leftPanel,constraints);

        setRightPanel(new TransferPanel(this));

        pack();


    }

    public void setRightPanel(RightPanel panel) {

        if (rightPanel != null) remove(rightPanel);

        constraints.gridy = 1;
        constraints.gridx = 1;
        rightPanel = panel;
        rightPanel.setBorder(Style.BORDER_DIALOG);
        add(rightPanel, constraints);

        pack();
    }

    @Override
    public void refresh() {
        SwingUtilities.updateComponentTreeUI(this);
        tb.refresh();
        leftPanel.refresh();
        rightPanel.refresh();
        pack();
    }
    public MainMenu getMb() {
        return mb;
    }
    public RightPanel getRightPanel() {
        return rightPanel;
    }

}
