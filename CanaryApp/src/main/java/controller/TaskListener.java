/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.TaskContainer;

/**
 *
 * @author Gustavo
 */
public class TaskListener implements MouseListener {
    
    TaskContainer taskContainer = TaskContainer.getInstance();

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent().getName().equals("check_btn")){
//            System.out.println(e.getComponent().getParent().getParent().getComponent(1).getParent().getComponent(2));
//            System.out.println(taskContainer.getAll());
        } else if(e.getComponent().getName().equals("delete_btn")){
            
        } else if(e.getComponent().getName().equals("edit_btn")){
            
        } else if(e.getComponent().getName().equals("subtask_btn")){
            
        }
    }

    
    @Override
    public void mousePressed(MouseEvent e) {
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
