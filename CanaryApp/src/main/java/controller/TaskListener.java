package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.Task;
import model.TaskContainer;
import view.NewTaskView;
import view.TaskView;

/**
 *
 * @author Gustavo
 */
public class TaskListener implements MouseListener {
     

    @Override
    public void mouseClicked(MouseEvent e) {
        TaskContainer taskContainer = TaskContainer.getInstance();
        NewTaskView newTaskView = NewTaskView.getInstance();
        
        //DELETE BUTTON
        if(e.getComponent().getName().equals("delete_btn")){
            System.out.println("deleting...");
            
        //EDIT BUTTON
        } else if(e.getComponent().getName().equals("edit_btn")){
            Task taskToEdit = ((TaskView)(e.getComponent().getParent().getParent().getParent())).getTask();
            newTaskView.setTaskToEdit(taskToEdit);
            newTaskView.setVisible(true);
            newTaskView.setNewTaskTitle("Edit Task");
            newTaskView.getNewTaskWarning().setVisible(false);
            newTaskView.setEditTaskButton("Save");
            
        //SUBTASK BUTTON
        } else if(e.getComponent().getName().equals("subtask_btn")){
            System.out.println("subtasking...");
        }
        
        //EDIT SAVE BUTTON
        if(e.getComponent().getName().equals("save_task_btn")){
            System.out.println("save edit...");
            if (newTaskView.getCreateTaskDescriptionTextField().equals("")){
                newTaskView.showWarning();
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
