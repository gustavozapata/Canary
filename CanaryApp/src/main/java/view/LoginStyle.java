package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Gustavo
 */
public class LoginStyle {
    public void styleLoginButton(JButton button){
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.BOLD, 12));
        button.setBackground(new Color(37, 167, 254));
    }
    
    public void styleLoginTitle(JLabel label){
        label.setFont(new Font("SansSerif", Font.BOLD, 25));
    }
    
    public void styleTextField(JTextField textField){
        textField.setFont(new Font("SansSerif", Font.BOLD, 15));
    }
}
