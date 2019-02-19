package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author Gustavo
 */
public class AppText extends JLabel {
    public AppText(String text) {
        super(text, null, LEADING);
    }
    public AppText(){
        super("", null, LEADING);
    }
    
    public void setHeadingOne(){
        this.setFont(new Font("Sans-Serif", Font.BOLD, 40));
        this.setHorizontalAlignment(CENTER);
    }
    
        public void setHeadingTwo(){ // For Tasks
        this.setFont(new Font("Sans-Serif", Font.BOLD, 30));
        this.setHorizontalAlignment(LEFT);
    }
        
    public void setHeadingSix(){
        this.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        this.setHorizontalAlignment(CENTER);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Map attributes = this.getFont().getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        this.setFont(this.getFont().deriveFont(attributes));
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
    }
    public void setPlusSign(){
        this.setFont(new Font("Sans-Serif", Font.BOLD, 60));
        this.setForeground(new Color(37, 167, 254));
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
    }
}
