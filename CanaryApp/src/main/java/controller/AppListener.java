package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.NewTaskView;
import view.LoginView;
//import view.TaskView;
//import static view.TaskView.taskDescription;

public class AppListener implements MouseListener {
    static NewTaskView newTaskView = new NewTaskView();
    static LoginView loginView = new LoginView();
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent().getName().equals("plus_btn")){
            newTaskView.setVisible(true);  
        } else if(e.getComponent().getName().equals("login_btn")){
            loginView.setVisible(true);
        } /*else if(e.getComponent().getName().equals("check_btn")){
            TaskView.taskDescription.setText("<html><body><span style='text-decoration:line-through;'>"+TaskView.taskDescription.getText()+"</span></body></html>");
            e.getComponent().setName("uncheck_btn");
        } else if(e.getComponent().getName().equals("uncheck_btn")){
            e.getComponent().setName("check_btn");
            TaskView.taskDescription.setText(NewTaskView.createTaskDescriptionTextField.getText());
        }*/
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
