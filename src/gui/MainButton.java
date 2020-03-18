package gui;

import settings.Style;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainButton extends JButton {

    public MainButton(String titile, ImageIcon icon, ActionListener listener, String action){
        super(titile);
        setIcon(icon);
        setActionCommand(action);
        addActionListener(listener);
        addMouseListener(new HoverButton());

        setFont(Style.FONT_BOTTON_MAIN);
        setBackground(Style.COLOR_BOTTON_NORMAL);
    }
    public MainButton( ImageIcon icon, ActionListener listener, String action){
        this("",icon,listener,action);

    }
    public MainButton( String title, ActionListener listener, String action){
        this(title,null,listener,action);

    }
  private class HoverButton implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
      //  ((MainButton)e.getSource()).setBackground(Style.COLOR_BOTTON_HOVER);
    }

    @Override
    public void mouseExited(MouseEvent e) {


    }
  }
}
