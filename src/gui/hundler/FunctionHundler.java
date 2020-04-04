package gui.hundler;

import dialog.AddEditDialog;
import dialog.ConfirmDialog;
import gui.MainFrame;
import gui.panel.RightPanel;
import gui.table.TableData;
import gui.table.model.MainTableModel;
import objects.Common;
import saveLoad.SaveData;
import settings.HundlerCode;

import javax.swing.*;
import java.awt.event.*;

public class FunctionHundler extends Hundler  implements MouseListener,KeyListener {
    private final AddEditDialog dialog;
    public FunctionHundler(MainFrame frame, AddEditDialog dialog) {
        super(frame);
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent ea) {
        switch(ea.getActionCommand()){
            case HundlerCode.ADD:
                add();
                break;
            case HundlerCode.EDIT:
                edit();
                break;
            case HundlerCode.DELETE:
                delete();
                break;
        }
    }

    private void add() {
        showAddEditDialog(null);
    }
    private void edit() {
        showAddEditDialog(getSelectedCommon());
    }
    private void delete() {
        Common c = getSelectedCommon();
        if(c != null){
            int result = ConfirmDialog.show(frame,"DELETE_OPTION","DELETE_TITLE");
            if(result == JOptionPane.YES_OPTION){
                SaveData.getInstance().remove(c);
                frame.refresh();
            }
        }
    }
    private void showAddEditDialog(Common c){
        dialog.setCommon(c);

        dialog.showDialog();
    }

    private Common getSelectedCommon(){
        TableData td = frame.getRightPanel().getTableData();
        Common c = ((MainTableModel)td.getModel()).getCommonByRow(td.getSelectedRow());
        return c;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public
    void keyReleased(KeyEvent e) {
       if(e.getKeyCode() == KeyEvent.VK_DELETE) delete();
       frame.refresh();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    if(e.getSource() instanceof TableData){
        if(e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1){
            showAddEditDialog(getSelectedCommon());
        }
       }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() instanceof TableData){
            if(e.getButton() == MouseEvent.BUTTON3){
                TableData tb = frame.getRightPanel().getTableData();
                int row = tb.rowAtPoint(e.getPoint()) ;
                tb.setRowSelectionInterval(row,row);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
