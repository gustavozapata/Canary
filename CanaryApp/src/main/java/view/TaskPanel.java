package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author k1715308
 */
public class TaskPanel extends JPanel {
    //PLACE THIS IN THE RIGHT PLACE
    private ArrayList<TaskPanel> taskContainers = new ArrayList();
    
    public TaskPanel(){
        super(true);
        this.setBackground(Color.WHITE);
    }
    public TaskPanel(LayoutManager layout) {
        super(layout, true);
        this.setSize(300,300);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(600, 400));
        this.setMaximumSize(new Dimension(500, 400));
        this.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 130, 20, 130), BorderFactory.createLineBorder(Color.BLACK)));
    }
    
    public TaskPanel(String type){
        if(type.equals("Task")){
            this.setBackground(new Color(241,241,241));
            this.setPreferredSize(new Dimension(900,90));
            this.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK));
        } else {
            BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
            this.setLayout(boxLayout);
        }
    }
    
    public void renderToolbarPanel(){
        this.setBackground(new Color(203, 232, 254));
        this.setPreferredSize(new Dimension(100, 35));
        this.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK));
    }
    
    public void createNewTask(){
        this.add(new TaskPanel("Task"));
    }
}
