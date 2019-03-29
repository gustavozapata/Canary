package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.TaskContainer;
import view.LoginView;
import view.AppView;

/**
 *
 * @author Gustavo
 */
public class LoginListener implements MouseListener {
    
    JOptionPane alert = new JOptionPane();
    UIManager UI = new UIManager();
    
    public LoginListener() {
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        boolean accepted = false;
        
        try {
            accepted = UserSystem.login(LoginView.getInstance().getUsernameField(), LoginView.getInstance().getPasswordField());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if(accepted){
            alert.showMessageDialog(LoginView.getInstance(), "Welcome " + UserSystem.currentUser.getUserName());
            if(UserSystem.currentUser.getUserLevel() == 1){
                AppView.getInstance().showList();
                AppView.getInstance().listComboBoxAction();;
            } else {
                AppView.getInstance().hideList();
            }
            LoginView.getInstance().setVisible(false);
            TaskContainer.getInstance().clear();
            AppView.getInstance().autoLoadTasks(UserSystem.currentUser.getUserName());
            
        } else {
            alert.showMessageDialog(LoginView.getInstance(), "Incorrect username or password");
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
