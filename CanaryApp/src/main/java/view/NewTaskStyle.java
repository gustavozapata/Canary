package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Gustavo
 */
public class NewTaskStyle {
    public void styleNewTaskTitle(JLabel label){
        label.setFont(new Font("SansSerif", Font.BOLD, 27));
        label.setForeground(new Color(235,17,69));
    }
    
    public void styleNewTaskSubtitle(JLabel label){
        label.setFont(new Font("SansSerif", Font.BOLD, 23));
        label.setForeground(new Color(74,74,74));
    }
    
    public void styleCreateTaskButton(JButton button){
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.BOLD, 18));
        button.setBackground(new Color(112, 112, 112));
    }
}
