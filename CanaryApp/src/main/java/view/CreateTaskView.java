package view;

import controller.GUIManager;
import controller.TaskSystem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import model.Task;
import model.User;

/**
 *
 * @author Gustavo
 */
public class CreateTaskView extends JDialog {
    private TodoPanel createTaskMainPanel = new TodoPanel();
    private TodoPanel createTaskNorth = new TodoPanel();
    private TodoPanel createTaskCentre = new TodoPanel();
    private TodoPanel createTaskSouth = new TodoPanel();
    
    private JLabel createTaskTitle = new JLabel();
    private JButton createTaskButton = new JButton();
    private JTextField createTaskDescription = new JTextField();
    
    public void createTask(){
        User u1 = new User("Kylan","Haffie","Mazemace","Todocanary123");
        Task t1 = TaskSystem.taskManager.newTask(createTaskDescription.getText(),u1);
        GUIManager.createTaskView();
        
    }
    
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
        
        createTaskDescription.setPreferredSize(new Dimension(120,30));
//        createTaskButton.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));

        createTaskSouth.setBorder(BorderFactory.createEmptyBorder(0,0,15,0));
        
        createTaskNorth.add(createTaskTitle);
        createTaskCentre.add(createTaskDescription);
        createTaskSouth.add(createTaskButton);
        
        createTaskMainPanel.add(createTaskNorth, BorderLayout.NORTH);
        createTaskMainPanel.add(createTaskCentre, BorderLayout.CENTER);
        createTaskMainPanel.add(createTaskSouth, BorderLayout.SOUTH);
        
        createTaskButton.addActionListener(e -> createTask());
        this.add(createTaskMainPanel);
    }
}
