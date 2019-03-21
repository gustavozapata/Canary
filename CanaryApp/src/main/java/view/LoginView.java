package view;

import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LoginView extends JPanel {
    
    private JLabel loginTitle = new JLabel();
    private JButton jb1 = new JButton();

    public static LoginView instance = null;
    private LoginView() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Login");

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(boxlayout);

        panel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));

        // Define new buttons
        loginTitle = new JLabel("Login");
        jb1 = new JButton("Button 1");

        // Add buttons to the frame (and spaces between buttons)
        panel.add(loginTitle);
        panel.add(jb1);

        // Set size for the frame
        //frame.setSize(300, 300);
        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame.pack();
//        frame.setVisible(true);
    }
    
    //SINGLETON METHOD
    public static LoginView getInstance(){
        if(LoginView.instance == null){
            instance = new LoginView();
        }
        return instance;
    }

}
