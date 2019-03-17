package view;

import controller.AppListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LoginView extends JPanel {

    public LoginView() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Login");

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(boxlayout);

        panel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));

        // Define new buttons
        AppLabel loginTitle = new AppLabel("Login");
        JButton jb1 = new JButton("Button 1");

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

}
