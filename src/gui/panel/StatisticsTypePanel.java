package gui.panel;

import gui.MainButton;
import gui.MainFrame;
import gui.hundler.ChartHundler;
import settings.HundlerCode;
import settings.Text;

public final class StatisticsTypePanel extends AbstractPanel {
    public final String title;
    public StatisticsTypePanel(MainFrame frame,String title) {
        super(frame);
        this.title =  Text.get(title);
        init();
    }

    @Override
    protected void init() {
        MainButton type = new MainButton(title, new ChartHundler(frame),HundlerCode.TYPE);
        add(type);

    }
}
