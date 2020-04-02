package gui.panel;

import gui.Chart;
import gui.MainFrame;
import gui.table.TableData;
import objects.Statistics;
import saveLoad.SaveData;
import settings.Style;
import settings.Text;

import javax.swing.*;

public class StatisticsPanel extends RightPanel{
    public static final int TYPE_INCOME = 0;
    public static final int TYPE_EXP = 1;
    private int type = TYPE_INCOME;

    public StatisticsPanel(MainFrame frame ){
        super(frame, null, "STATISTICS", Style.ICON_STATISTICS,
                new JPanel[]{new FilterPanel(frame),
                             new StatisticsTypePanel(frame,"CHART_INCOME"),
                             new Chart(Statistics.getDataForChartIncomeArticles(),Text.get("CHART_INCOME"),SaveData.getInstance().getBaseCurency().getCode()).getPanel()
        });
        System.out.println(Statistics.getDataForChartIncomeArticles());
    }

    public void nextType(){
        type++;
        if(type>TYPE_EXP) type = TYPE_INCOME;
    }

    @Override
    public void refresh() {
        Chart chart = null;
        String title = null;
        if(type == TYPE_INCOME){
            title = "CHART_INCOME";
            chart = new Chart(Statistics.getDataForChartIncomeArticles(),Text.get(title),SaveData.getInstance().getBaseCurency().getCode());}

        else if(type == TYPE_EXP){
            title = "CHART_EXP";
            chart = new Chart(Statistics.getDataForChartExpArticles(),Text.get(title),SaveData.getInstance().getBaseCurency().getCode());
            }
            setPanels(new JPanel[]{
                    new FilterPanel(frame),
                    new StatisticsTypePanel(frame,title),
                    chart.getPanel()
            });
        super.refresh();

    }

}
