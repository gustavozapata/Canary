package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.TaskContainer;
import view.AppView;
import view.NewSubTaskView;
import view.NewTaskView;

/**
 *
 * @author Gustavo
 */
public class TaskListener implements MouseListener {
    
    TaskContainer taskContainer;
    NewTaskView newTaskView;
    NewSubTaskView newSubTaskView;
    

    @Override
    public void mouseClicked(MouseEvent e) {
        taskContainer = TaskContainer.getInstance();
        newTaskView = NewTaskView.getInstance();
        
        if(e.getComponent().getName().equals("check_btn")){
//            System.out.println(e.getComponent().getParent().getParent().getComponent(1).getParent().getComponent(2));
//            System.out.println(taskContainer.getAll());
            System.out.println(e.getSource());
        } else if(e.getComponent().getName().equals("delete_btn")){
            System.out.println("deleting...");
        } else if(e.getComponent().getName().equals("edit_btn")){
            newTaskView.setVisible(true);
            newTaskView.setNewTaskTitle("Edit Task");
            newTaskView.setEditTaskButton("Save");
        } else if(e.getComponent().getName().equals("subtask_btn")){
            newSubTaskView = NewSubTaskView.getInstance();
            newSubTaskView.setLocationRelativeTo(AppView.getInstance());
            newSubTaskView.setVisible(true);
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
