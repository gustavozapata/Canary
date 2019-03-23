package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginView extends JDialog {
    
    //PANELS
    private JPanel topPanel = new JPanel();
    private JPanel middlePanel = new JPanel();
    private JPanel bottomPanel = new JPanel();
        
    private JLabel loginTitle = new JLabel();
    private JLabel usernameLabel = new JLabel();
    private JLabel passwordLabel = new JLabel();
    
    private JButton loginButton = new JButton();
    private JTextField usernameField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    
    
    //STYLES
    private LoginStyle loginStyle = new LoginStyle();
    

    //SINGLETON
    public static LoginView instance = null;
    private LoginView() {
        this.setTitle("Login");
        this.setSize(400, 300);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);
        
        setComponents();
        setPanels();
        addComponents();
    }
    
    //SINGLETON METHOD
    public static LoginView getInstance(){
        if(LoginView.instance == null){
            instance = new LoginView();
        }
        return instance;
    }
    
    public void setComponents(){
        loginTitle.setText("Login");
        usernameLabel.setText("Username");
        passwordLabel.setText("Password");
        
        loginButton.setText("Login");
        loginStyle.styleLoginButton(loginButton);
        loginStyle.styleLoginTitle(loginTitle);
        loginStyle.styleTextField(usernameField);
        loginStyle.styleTextField(passwordField);

        passwordLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
    }
    
    public void setPanels(){
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
        middlePanel.setBorder(BorderFactory.createEmptyBorder(20, 70, 50, 70));
        topPanel.setBackground(Color.white);
        middlePanel.setBackground(Color.white);
        bottomPanel.setBackground(Color.white);
    }
    
    public void addComponents(){
        topPanel.add(loginTitle);
        middlePanel.add(usernameLabel);
        middlePanel.add(usernameField);
        middlePanel.add(passwordLabel);
        middlePanel.add(passwordField);
        bottomPanel.add(loginButton);
        
        this.add(topPanel, BorderLayout.NORTH);
        this.add(middlePanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

}
