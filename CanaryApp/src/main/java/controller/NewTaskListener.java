package controller;

import static controller.AppListener.newTaskView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.Task;
import model.TaskContainer;
import model.User;
import view.TaskView;
import view.NewTaskView;


public class NewTaskListener implements MouseListener {
    
    TaskContainer taskContainer;
    
    @Override
    public void mouseClicked(MouseEvent e) {
//        TaskView taskView = new TaskView();
        
        if(NewTaskView.createTaskDescriptionTextField.getText().length() > 0){
            newTaskView.setVisible(false);
            AppGUIBuilder.renderTasks();
        }
        
        
//        if(Task.taskCounter == 0){
//            taskContainer = TaskContainer.getInstance();
//        }
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
