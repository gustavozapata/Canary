package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.Task;
import model.TaskContainer;
import model.User;
import view.AppView;
import view.NewTaskView;
import view.TaskView;


public class NewTaskListener implements MouseListener {
    
    TaskContainer taskContainer = TaskContainer.getInstance();
    TaskView taskView;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent().getName().equals("create_task_btn")){
            NewTaskView newTaskView = NewTaskView.getInstance();
            Task task = newTaskView.createNewTask();
            taskContainer.addItem(task);
            taskView = new TaskView(task);
            AppView.getInstance().renderNewTask(taskView);
            
            newTaskView.setVisible(false);
        }
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
