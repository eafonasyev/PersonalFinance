package gui.hundler;

import dialog.AddEditDialog;
import dialog.ErrorDialog;
import gui.MainFrame;
import objects.ModelException;
import saveLoad.SaveData;
import settings.HundlerCode;

import java.awt.event.*;

public class AddEditDialogHundler extends Hundler implements KeyListener,WindowListener {
    private final AddEditDialog dialog;
    public AddEditDialogHundler(MainFrame frame, AddEditDialog dialog) {
        super(frame);
        this.dialog = dialog;
    }
    @Override
    public void actionPerformed(ActionEvent ea) {
        try {
        switch(ea.getActionCommand()){
            case HundlerCode.ADD:
                add();
                break;
            case HundlerCode.EDIT:
                edit();
            case HundlerCode.CANCEL:
                closeDialog();
          }
        }
        catch (Exception ex) {
            ErrorDialog.show(frame, ex.getMessage());
        }
    }

    private void closeDialog() {
        dialog.closeDialog();
    }
    private void addEdit(boolean add) {
        try {
            if (add) SaveData.getInstance().add(dialog.getCommonFromForm());
            else SaveData.getInstance().edit(dialog.getCommon(), dialog.getCommonFromForm());
            closeDialog();
        }
        catch (ModelException ex) {
            ErrorDialog.show(frame, ex.getMessage());
        }
    }
    private void add() throws Exception{

    }

    private void edit() throws Exception{
        SaveData.getInstance().edit(dialog.getCommon(),dialog.getCommonFromForm());
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
     if(e.getKeyCode()==KeyEvent.VK_ENTER){

     }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
