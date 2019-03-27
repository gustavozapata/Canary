package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.Task;
import model.TaskContainer;
import view.AppView;
import view.NewSubTaskView;
import view.NewTaskView;
import view.TaskView;

public class NewTaskListener implements MouseListener {

        
    @Override
    public void mouseClicked(MouseEvent e) {
        
        TaskContainer taskContainer = TaskContainer.getInstance();
        NewTaskView newTaskView = NewTaskView.getInstance();
        TaskView taskView;
        
        //CREATE NEW TASK BUTTON
        if (e.getComponent().getName().equals("create_task_btn")) {
            if (newTaskView.getCreateTaskDescriptionTextField().equals("")) {
                newTaskView.showWarning();
            } else {
                Task task = newTaskView.createNewTask();
                taskContainer.addItem(task);
                System.out.println("taskContainer.length(): " + taskContainer.getAll().size());
                taskView = new TaskView(task);
                AppView.getInstance().renderNewTask();
                newTaskView.setVisible(false);
            }
        }
        
                
        //CREATE NEW SUBTASK BUTTON
        if (e.getComponent().getName().equals("create_subtask_btn")) {
            NewSubTaskView newSubTaskView = NewSubTaskView.getInstance();
//            Task task = newTaskView.createNewTask();
            if (newSubTaskView.getCreateTaskDescriptionTextField().equals("")) {
                newSubTaskView.showWarning();
            } else {
//                taskContainer.addItem(task);
//                taskView = new TaskView(task);
//                AppView.getInstance().renderNewTask(taskView);

                newSubTaskView.setVisible(false);
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
