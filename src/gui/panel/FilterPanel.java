package gui.panel;

import gui.MainButton;
import gui.MainFrame;
import gui.hundler.MenuFilterHundler;
import objects.Filter;
import saveLoad.SaveData;
import settings.Format;
import settings.HundlerCode;
import settings.Style;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FilterPanel extends AbstractPanel {

    public FilterPanel(MainFrame frame) {
        super(frame);
        init();
    }

    @Override
    protected void init() {
        FlowLayout  layout = new FlowLayout();
        layout.setVgap(0);
        setLayout(layout);
        MainButton leftButton = new MainButton(Style.ICON_LEFT,new MenuFilterHundler(frame),HundlerCode.LEFT);
        MainButton periodButton = new MainButton(Format.getTitleFilter(SaveData.getInstance().getFilter()),new MenuFilterHundler(frame),HundlerCode.STEP);
        MainButton rightButton = new MainButton(Style.ICON_RIGHT,new MenuFilterHundler(frame),HundlerCode.RIGTH);

        setBorder(Style.LEFT_PANEL_BORDER);

        periodButton.setFont(Style.FONT_PANEL_LEFT);
        periodButton.setPreferredSize(new Dimension(Style.WIDTH_FILTER_BUTON,leftButton.getPreferredSize().height));
        add(leftButton);
        add(periodButton);
        add(rightButton);

    }
}
