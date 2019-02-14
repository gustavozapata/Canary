/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.CreateTaskView;

/**
 *
 * @author Gustavo
 */
public class MainWindowListener implements MouseListener {
    
    private CreateTaskView createTaskView = new CreateTaskView();

    @Override
    public void mouseClicked(MouseEvent e) {
        createTaskView.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    
   
    
}
