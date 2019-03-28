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
import view.NewSubTaskView;
import view.NewTaskView;
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
            NewSubTaskView.getInstance().setSubtaskToEdit(subtaskToEdit);
//            NewSubTaskView.getInstance().setTask(taskToEdit);
            NewSubTaskView.getInstance().setEditReady();
            NewSubTaskView.getInstance().setVisible(true);
            
            
        //SUBTASK DELETE BUTTON
        } else if (e.getComponent().getName().equals("subtask_delete_btn")){
           // subtaskToEdit.getTask().deleteSubtask(subtaskToEdit); CHANGE THIS
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
