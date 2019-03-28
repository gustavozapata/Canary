/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.SubTask;
import model.Task;
import model.TaskContainer;
import view.AppView;
import view.SubTaskView;
import view.TaskView;

/**
 *
 * @author Gustavo
 */
public class SubTaskListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        
        //TASK TO EDIT/DELETE
        SubTask subtaskToEdit = ((SubTaskView) (e.getComponent().getParent().getParent().getParent())).getSubTask();
        
        //SUBTASK EDIT BUTTON
        if(e.getComponent().getName().equals("subtask_edit_btn")){
            System.out.println("subtask edit btn");
            
            
        //SUBTASK DELETE BUTTON
        } else if (e.getComponent().getName().equals("subtask_delete_btn")){
            System.out.println("subtask delete btn");
            System.out.println("subtask to delete: " + subtaskToEdit.getDescription());
            System.out.println("my parent task says: " + subtaskToEdit.getTask().getDescription());
            subtaskToEdit.getTask().deleteSubtask(subtaskToEdit);
            AppView.getInstance().renderNewTask();
            
            
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
