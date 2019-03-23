package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.AppView;
import view.NewTaskView;
import view.LoginView;

public class AppListener implements MouseListener {
    private NewTaskView newTaskView = NewTaskView.getInstance();
    private LoginView loginView = LoginView.getInstance();
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent().getName().equals("plus_btn")){
            newTaskView.emptyFields();
            newTaskView.setVisible(true);
            newTaskView.setLocationRelativeTo(AppView.getInstance());
        } else if(e.getComponent().getName().equals("login_btn")){
            loginView.setVisible(true);
            loginView.setLocationRelativeTo(AppView.getInstance());
            loginView.setUsernameField("");
            loginView.setPasswordField("");
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
