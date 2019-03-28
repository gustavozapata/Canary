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
public class TaskListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

        //TASK TO EDIT/DELETE
        Task taskToEdit = ((TaskView) (e.getComponent().getParent().getParent().getParent())).getTask();
        
        
        //DELETE BUTTON
        if (e.getComponent().getName().equals("delete_btn")) {
            System.out.println("deleting...");
            TaskContainer.getInstance().removeTask(taskToEdit);
            AppView.getInstance().renderNewTask();
            
            System.out.println("taskContainer.size(): " + TaskContainer.getInstance().getAll().size());

        //EDIT BUTTON
        } else if (e.getComponent().getName().equals("edit_btn")) {
            NewTaskView.getInstance().setTaskToEdit(taskToEdit);
            NewTaskView.getInstance().setTask(taskToEdit);
            NewTaskView.getInstance().setVisible(true);
            NewTaskView.getInstance().setEditReady();

        //SUBTASK BUTTON
        } else if (e.getComponent().getName().equals("subtask_btn")) {
            System.out.println("subtasking...");
            NewSubTaskView.getInstance().setVisible(true);
            NewSubTaskView.getInstance().emptyFields();
            NewSubTaskView.getInstance().setTask(taskToEdit);
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
