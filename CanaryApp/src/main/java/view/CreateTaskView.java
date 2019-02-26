package view;

import controller.GUIManager;
import controller.TaskSystem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
    
    private TodoPanel containerCentre = new TodoPanel();
    
    private TodoText createTaskTitle = new TodoText();
    private TodoText createTaskDescription = new TodoText();
    private JButton createTaskButton = new JButton();
    private JTextField createTaskDescriptionTextField = new JTextField();
    
    public void createTask(){
        User u1 = new User("Kylan","Haffie","Mazemace","Todocanary123");
        Task t1 = TaskSystem.taskManager.newTask(createTaskDescription.getText(),u1);
        GUIManager.createTaskView();
    }
    
    public CreateTaskView() {
        this.setSize(650, 400);
        this.setLocation(300, 150);
//        this.setVisible(true);
        
        //PANEL FORMATTING
        createTaskMainPanel.setLayout(new BorderLayout());
        createTaskMainPanel.setBackground(Color.WHITE);
        
        createTaskNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
        createTaskNorth.setBorder(BorderFactory.createEmptyBorder(0,15,15,0));
        
        createTaskSouth.setBorder(BorderFactory.createEmptyBorder(0,0,15,0));
//        createTaskNorth.setBorder(BorderFactory.createLineBorder(Color.red));

        containerCentre.setLayout(new BoxLayout(containerCentre, BoxLayout.Y_AXIS));
        containerCentre.setBorder(BorderFactory.createEmptyBorder(0,0,0,80));
        

        //COMPONENTS FORMATTING
        createTaskTitle.setNewTaskTitle("New Task");
        
        createTaskDescription.setNewTaskLabel("Task Description");
//        createTaskTitle.setHorizontalAlignment(SwingConstants.LEFT);
//        Map attributes = createTaskTitle.getFont().getAttributes();
//        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
//        createTaskTitle.setFont(createTaskTitle.getFont().deriveFont(attributes));
        
        createTaskDescriptionTextField.setPreferredSize(new Dimension(520,30));
//        createTaskButton.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));


        createTaskButton.setText("Create");
        createTaskButton.setForeground(Color.WHITE);
        createTaskButton.setBackground(new Color(112,112,112));
        

        
        
        //ADDING
        containerCentre.add(createTaskDescription);
        containerCentre.add(createTaskDescriptionTextField);
        
        createTaskNorth.add(createTaskTitle);
        createTaskCentre.add(containerCentre);
//        createTaskCentre.add(createTaskDescriptionTextField);
        createTaskSouth.add(createTaskButton);
        
        createTaskMainPanel.add(createTaskNorth, BorderLayout.NORTH);
        createTaskMainPanel.add(createTaskCentre, BorderLayout.CENTER);
        createTaskMainPanel.add(createTaskSouth, BorderLayout.SOUTH);
        
        createTaskButton.addActionListener(e -> createTask());
        this.add(createTaskMainPanel);
    }
}
