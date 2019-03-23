package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
        
        if(loginView.getUsernameField().equals("tavo") && loginView.getPasswordField().equals("lovecoding")){
            alert.showMessageDialog(loginView.getInstance(), "Welcome Tavo");
            loginView.setVisible(false);
        } else if(loginView.getUsernameField().equals("paul") && loginView.getPasswordField().equals("neve")){
            alert.showMessageDialog(loginView.getInstance(), "Welcome Mr. Neve");
            loginView.setVisible(false);
        } else {
            alert.showMessageDialog(loginView.getInstance(), "Incorrect username or password");
        }
        
//        if(alert.)
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
