package gui.panel;

import gui.EnableEditDelete;
import gui.MainFrame;
import gui.Refresh;
import gui.table.TableData;
import settings.Style;
import settings.Text;
import toolbar.AbstractToolBar;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class RightPanel extends AbstractPanel {

    protected TableData tb;
    private String title;
    private ImageIcon icon;
    private JPanel[] panels;

    public RightPanel(MainFrame frame, TableData tb, String title, ImageIcon icon, JPanel[] panel) {
        super(frame);
        this.title = title;
        this.icon = icon;
        this.panels = panel;
        this.tb = tb;
    }

    public RightPanel(MainFrame frame, TableData tb, String title, ImageIcon icon, AbstractToolBar pn) {
        this(frame, tb, title, icon, new JPanel[]{pn});

    }

    public RightPanel(MainFrame frame, TableData tb, String title, ImageIcon icon) {
        this(frame, tb, title, icon, new JPanel[]{});

    }

    @Override
    public void refresh() {
        super.refresh();
        if (tb != null) tb.refresh();
        for (JPanel panel : panels) {
            if (panel instanceof Refresh) ((Refresh) panel).refresh();
        }
    }

    public void enableEditDelete() {
        super.refresh();
        for (JPanel panel : panels) {
            if (panel instanceof EnableEditDelete) ((EnableEditDelete) panel).setEnableEditDelete(false);
        }
        frame.getMb().setEnableEditDelete(false);
        if (tb != null)
            if (tb.getSelectedRow() != -1) {
                for (JPanel panel : panels) {
                    if (panel instanceof EnableEditDelete) ((EnableEditDelete) panel).setEnableEditDelete(true);
                    frame.getMb().setEnableEditDelete(true);
                }
            }
    }

    @Override
    protected void init() {
        enableEditDelete();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel header = new JLabel(Text.get(title));
        header.setFont(Style.FONT_PANEL_LEFT);
        header.setIcon(icon);
        header.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        add(header);

        if (panels.length==0) add(Box.createHorizontalStrut(Style.PUDDING_EMPTY));

        for (JPanel panel : panels) {
            add(panel);
            add(Box.createHorizontalStrut(Style.PUDDING_BALLANCE));
        }
      if(tb!=null){
            JScrollPane scroll = new JScrollPane(tb);
            add(scroll);
            scroll.setVerticalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            ListSelectionModel model = tb.getSelectionModel();
            model.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    enableEditDelete();
                }
            });
      }
    }


}
