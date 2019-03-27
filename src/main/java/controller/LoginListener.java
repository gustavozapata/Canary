package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import view.LoginView;

/**
 *
 * @author Gustavo
 */
public class LoginListener implements MouseListener {
    
    LoginView loginView;
    JOptionPane alert = new JOptionPane();
    UIManager UI = new UIManager();
    
    public LoginListener() {
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        loginView = LoginView.getInstance();
        
        boolean accepted = false;
        
        try {
            accepted = UserSystem.login(loginView.getUsernameField(), loginView.getPasswordField());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if(accepted){
            alert.showMessageDialog(loginView.getInstance(), "Welcome " + UserSystem.currentUser.getUserName());
            loginView.setVisible(false);
        } else {
            alert.showMessageDialog(loginView.getInstance(), "Incorrect username or password");
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
