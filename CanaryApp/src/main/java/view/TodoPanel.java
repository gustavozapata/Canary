package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TodoPanel extends JPanel {
    public TodoPanel(){
        super(true);
        this.setBackground(Color.WHITE);
    }
    public TodoPanel(LayoutManager layout) {
        super(layout, true);
        this.setSize(300,300);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(600, 400));
        this.setMaximumSize(new Dimension(500, 400));
        this.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 130, 20, 130), BorderFactory.createLineBorder(Color.BLACK)));
    }
    
    public void renderToolbarPanel(){
        this.setBackground(new Color(203, 232, 254));
        this.setPreferredSize(new Dimension(100, 35));
        this.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK));
    }
}
