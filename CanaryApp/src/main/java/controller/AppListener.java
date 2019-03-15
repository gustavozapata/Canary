package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.NewTaskView;
import view.LoginView;

public class AppListener implements MouseListener {
    static NewTaskView newTaskView = new NewTaskView();
    static LoginView loginView = new LoginView();
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        newTaskView.setVisible(true);    
        loginView.setVisible(true);
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
