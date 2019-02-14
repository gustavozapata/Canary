package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.SwingConstants;

/**
 *
 * @author Gustavo
 */
public class CreateTaskView extends JDialog {
    private TodoPanel createTaskMainPanel = new TodoPanel();
    private TodoPanel createTaskNorth = new TodoPanel();
    private TodoPanel createTaskSouth = new TodoPanel();
    
    private TodoText createTaskTitle = new TodoText();
    private TodoButton createTaskButton = new TodoButton();
    
    
    public CreateTaskView() {
        this.setSize(650, 400);
        this.setLocation(300, 150);
//        this.setVisible(true);
        
        createTaskMainPanel.setLayout(new BorderLayout());
        createTaskMainPanel.setBackground(Color.WHITE);

        createTaskTitle.setText("New Task");
        createTaskTitle.setFont(new Font("Sans-serif", Font.BOLD, 25));
        createTaskTitle.setForeground(new Color(235,17,69));
        createTaskTitle.setHorizontalAlignment(SwingConstants.LEFT);
//        Map attributes = createTaskTitle.getFont().getAttributes();
//        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
//        createTaskTitle.setFont(createTaskTitle.getFont().deriveFont(attributes));
//        createTaskNorth.setLayout(new FlowLayout(FlowLayout.LEFT));

        createTaskButton.setText("Create");
        createTaskButton.setForeground(Color.WHITE);
        createTaskButton.setBackground(new Color(112,112,112));
//        createTaskButton.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));

        createTaskSouth.setBorder(BorderFactory.createEmptyBorder(0,0,15,0));
        
        createTaskNorth.add(createTaskTitle);
        createTaskSouth.add(createTaskButton);
        
        createTaskMainPanel.add(createTaskNorth, BorderLayout.NORTH);
        createTaskMainPanel.add(createTaskSouth, BorderLayout.SOUTH);
        
        this.add(createTaskMainPanel);
    }
}
