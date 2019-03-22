package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.Task;
import model.TaskContainer;
import view.AppView;
import view.NewTaskView;
import view.TaskView;

public class AppController implements MouseListener {

    TaskContainer taskContainer = TaskContainer.getInstance();
    TaskView taskView;
    Task task;

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getComponent().getName().equals("create_task_btn")) {
            NewTaskView newTaskView = NewTaskView.getInstance();
            this.task = newTaskView.createNewTask();
            if (newTaskView.getCreateTaskDescriptionTextField().equals("")) {
                newTaskView.showWarning();
            } else {
                taskContainer.addItem(task);
                taskView = new TaskView(task);
                AppView.getInstance().renderNewTask(taskView);

                newTaskView.setVisible(false);
            }
        } else if(e.getComponent().getName().equals("check_btn")){
//            System.out.println(this.task.getTaskDescription());
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
