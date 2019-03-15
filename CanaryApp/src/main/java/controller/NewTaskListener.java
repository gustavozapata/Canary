package controller;

import static controller.AppListener.newTaskView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.Task;
import model.TaskContainer;
import model.User;
import view.TaskView;


public class NewTaskListener implements MouseListener {
    
    TaskContainer taskContainer;
    
    @Override
    public void mouseClicked(MouseEvent e) {
<<<<<<< HEAD
//        TaskView taskView = new TaskView();
=======
        //TaskView taskView = new TaskView();
>>>>>>> b2e03de040f538a5b5dd40c37b9594153c2d6180
        
        newTaskView.setVisible(false);
        AppGUIBuilder.renderTasks();
        
//        if(Task.taskCounter == 0){
//            taskContainer = TaskContainer.getInstance();
<<<<<<< HEAD
//        }
=======
//        }       

>>>>>>> b2e03de040f538a5b5dd40c37b9594153c2d6180


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
