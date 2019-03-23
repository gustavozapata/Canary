package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.LEFT;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Gustavo
 */
public class AppStyle {
    
    //COMPONENTS
    public void setLabelOne(JLabel label){
        label.setFont(new Font("SansSerif", Font.BOLD, 40));
        label.setBorder(BorderFactory.createEmptyBorder(0, 220, 0, 0));
        label.setHorizontalAlignment(CENTER);
    }
    
    public void setLabelThree(JLabel label){
        label.setFont(new Font("SansSerif", Font.BOLD, 15));
        label.setHorizontalAlignment(CENTER);
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        styleClickableLabel(label);
    }
    
    public void setLabelFour(JLabel label){
        label.setFont(new Font("SansSerif", Font.BOLD, 15));
        label.setHorizontalAlignment(LEFT);
        label.setBorder(BorderFactory.createEmptyBorder(0,25,0,0));
    }
    
    public void setLabelFive(JLabel label){
        label.setFont(new Font("SansSerif", Font.BOLD, 13));
        label.setHorizontalAlignment(LEFT);
        label.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
        styleClickableLabel(label);
    }
    
    public void styleAppSettings(JLabel label){
        label.setFont(new Font("SansSerif", Font.BOLD, 11));
        label.setHorizontalAlignment(LEFT);
        label.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
    }
    
    public void setIconPlus(JLabel label){
        label.setFont(new Font("SansSerif", Font.BOLD, 60));
        label.setForeground(new Color(37, 167, 254));
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
    }
    
    public void setTaskInfo(JLabel label){
        label.setFont(new Font("SansSerif", Font.ITALIC, 20));
        label.setText("Nothing To Do! It's time to relax");
        label.setForeground(new Color(200, 200, 200));
        label.setBorder(BorderFactory.createEmptyBorder(200, 0, 0, 0));
    }
    
    public void styleToolbarItem(JLabel label){
        label.setFont(new Font("SansSerif", Font.BOLD, 13));
        label.setBorder(BorderFactory.createEmptyBorder(3,25,0,0));
        styleClickableLabel(label);
        label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    
    public void styleComboBox(JComboBox comboBox){
        comboBox.setBackground(Color.white);
    }
    
    public void styleClickableLabel(JLabel label){
        Map attributes = label.getFont().getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        label.setFont(label.getFont().deriveFont(attributes));
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    
    
    //PANELS
    public void setTaskWindow(JPanel panel){
        panel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 130, 20, 130), BorderFactory.createLineBorder(Color.BLACK)));
    }
    
    public void setActionPanel(JPanel panel){
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);
        panel.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
    }
    
    public void setToolBar(JPanel panel){
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(new Color(203, 232, 254));
        panel.setPreferredSize(new Dimension(100, 35));
        panel.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK));
    }
}
