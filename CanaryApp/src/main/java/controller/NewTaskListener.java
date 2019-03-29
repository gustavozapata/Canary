/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.Task;
import model.TaskContainer;
import view.AppView;
import view.NewSubTaskView;
import view.NewTaskView;
import view.TaskView;

/**
 *
 * @author Gustavo
 */
public class NewTaskListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {     
        
        //CREATE TASK BUTTON
        if(e.getComponent().getName().equals("create_task_btn")){
            System.out.println("create task button");
            
            if(NewTaskView.getInstance().getCreateTaskDescriptionTextField().equals("")){
                NewTaskView.getInstance().showWarning();
                
                
            //CREATE AN ACTUAL TASK AND ITS TASKVIEW
            } else {
                NewTaskView.getInstance().setVisible(false);
                
                //create a new instance of Task
                Task task = NewTaskView.getInstance().createTask();
                //add it to the TaskContainer
                TaskContainer.getInstance().addItem(task);
                System.out.println("taskContainer.size(): " + TaskContainer.getInstance().getAll().size());
                //renders all the tasks in the taskContainer
                AppView.getInstance().renderNewTask();
            }
        }
        
        
        //EDIT SAVE BUTTON
        if (e.getComponent().getName().equals("save_task_btn")) {
            System.out.println("save edit...");
            if (NewTaskView.getInstance().getCreateTaskDescriptionTextField().equals("")) {
                NewTaskView.getInstance().showWarning();
            } else {
                NewTaskView.getInstance().setVisible(false);
                NewTaskView.getInstance().saveEditedTask(NewTaskView.getInstance().getTask());
                AppView.getInstance().renderNewTask();
            }
        }
        
        
        
        //SUBTASK CREATE BUTTON
        if (e.getComponent().getName().equals("create_subtask_btn")) {
            System.out.println("subtask...");
            if (NewSubTaskView.getInstance().getCreateTaskDescriptionTextField().equals("")) {
                NewSubTaskView.getInstance().showWarning();
            } else {
                NewSubTaskView.getInstance().setVisible(false);
                NewSubTaskView.getInstance().createNewSubTask();
                AppView.getInstance().renderNewTask();
            }
        }
        
        //SUBTASK EDIT SAVE
        if (e.getComponent().getName().equals("edit_subtask_btn")) {
            System.out.println("subtask save edit...");
            if (NewSubTaskView.getInstance().getCreateTaskDescriptionTextField().equals("")) {
                NewSubTaskView.getInstance().showWarning();
            } else {
                NewSubTaskView.getInstance().setVisible(false);
                NewSubTaskView.getInstance().saveEditedSubTask(NewSubTaskView.getInstance().getSubTask());
                AppView.getInstance().renderNewTask();
            }
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
