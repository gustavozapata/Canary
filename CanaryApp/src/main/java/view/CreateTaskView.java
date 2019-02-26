package view;

import controller.GUIManager;
import controller.TaskSystem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.App;
import model.Task;
import model.User;

/**
 *
 * @author Gustavo
 */
public class CreateTaskView extends JDialog {
    private App appSettings = new App();
    
    private TodoPanel createTaskMainPanel = new TodoPanel();
    private TodoPanel createTaskNorth = new TodoPanel();
    private TodoPanel createTaskCentre = new TodoPanel();
    private TodoPanel createTaskSouth = new TodoPanel();
    private TodoPanel containerCentreY = new TodoPanel();
    private TodoPanel containerCentreX = new TodoPanel();
    private TodoPanel containerCentreX2 = new TodoPanel();
    private TodoPanel containerCentreX3 = new TodoPanel();
    private TodoPanel containerCentreX4 = new TodoPanel();
    
    private TodoText createTaskTitle = new TodoText();
    private TodoText createTaskDescription = new TodoText();
    private TodoText createTaskCategory = new TodoText();
    private TodoText createTaskPriority = new TodoText();
    private TodoText createTaskAssigned = new TodoText();
    
    private JTextField createTaskDescriptionTextField = new JTextField();
    private JComboBox<String> createTaskCategoryDrop = new JComboBox(appSettings.getCategories());
    private JComboBox<String> createTaskAssignedDrop = new JComboBox(appSettings.getCategories());
    private ButtonGroup groupPriority = new ButtonGroup();
    private JRadioButton lowPriority = new JRadioButton(appSettings.getPriorities()[0]);
    private JRadioButton mediumPriority = new JRadioButton(appSettings.getPriorities()[1]);
    private JRadioButton highPriority = new JRadioButton(appSettings.getPriorities()[2]);
    private JButton createTaskButton = new JButton();
    
    
    
    public void createTask(){
        User u1 = new User("Kylan","Haffie","Mazemace","Todocanary123");
        Task t1 = TaskSystem.taskManager.newTask(createTaskDescription.getText(),u1);
        GUIManager.createTaskView();
    }
    
    public CreateTaskView() {
        this.setSize(700, 400);
        this.setLocation(300, 150);
        
        
        //PANEL FORMATTING
        createTaskMainPanel.setLayout(new BorderLayout());
        createTaskMainPanel.setBackground(Color.WHITE);
        
        createTaskNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
        createTaskNorth.setBorder(BorderFactory.createEmptyBorder(0,25,15,0));
        createTaskSouth.setBorder(BorderFactory.createEmptyBorder(0,0,15,0));

        containerCentreX.setLayout(new BoxLayout(containerCentreX, BoxLayout.Y_AXIS));
        containerCentreX2.setLayout(new BoxLayout(containerCentreX2, BoxLayout.Y_AXIS));
        containerCentreX4.setLayout(new BoxLayout(containerCentreX4, BoxLayout.Y_AXIS));
        containerCentreY.setLayout(new BoxLayout(containerCentreY, BoxLayout.Y_AXIS));
        containerCentreY.setBorder(BorderFactory.createEmptyBorder(0,0,40,110));
//        containerCentreX2.setBorder(BorderFactory.createEmptyBorder(0,30,0,30));
        

        
        //COMPONENTS FORMATTING
        createTaskTitle.setNewTaskTitle("New Task");
        createTaskDescription.setNewTaskLabel("Task Description");
        createTaskCategory.setNewTaskLabel("Category");
        createTaskPriority.setNewTaskLabel("Priority");
        createTaskAssigned.setNewTaskLabel("Assigned To");
        
        createTaskPriority.setBorder(BorderFactory.createEmptyBorder(0,0,0,75));
//        createTaskPriority.setHorizontalAlignment(TodoText.CENTER);
        
        createTaskDescriptionTextField.setPreferredSize(new Dimension(520,30));
        createTaskCategoryDrop.setPreferredSize(new Dimension(150,30));
        createTaskCategoryDrop.setBackground(Color.white);
        createTaskAssignedDrop.setPreferredSize(new Dimension(100,30));
        createTaskAssignedDrop.setBackground(Color.white);
        
        lowPriority.setBackground(Color.white);
        mediumPriority.setBackground(Color.white);
        highPriority.setBackground(Color.white);
//        highPriority.setBackground(new Color(248,73,121));
//        highPriority.setForeground(Color.WHITE);
        
        groupPriority.add(lowPriority);
        groupPriority.add(mediumPriority);
        groupPriority.add(highPriority);

        createTaskButton.setText("Create");
        createTaskButton.setForeground(Color.WHITE);
        createTaskButton.setFont(new Font("Sans-serif", Font.BOLD, 18));
        createTaskButton.setBackground(new Color(112,112,112));
        
        
        
        
        
        //ADDING
        containerCentreX4.add(createTaskAssigned);
        containerCentreX4.add(createTaskAssignedDrop);
        
        containerCentreX3.add(lowPriority);
        containerCentreX3.add(mediumPriority);
        containerCentreX3.add(highPriority);
              
        containerCentreX2.add(createTaskPriority);
        containerCentreX2.add(containerCentreX3);
        
        containerCentreX.add(createTaskCategory);
        containerCentreX.add(createTaskCategoryDrop);
        
        containerCentreY.add(createTaskDescription);
        containerCentreY.add(createTaskDescriptionTextField);
        
        createTaskNorth.add(createTaskTitle);
        createTaskCentre.add(containerCentreY, BorderLayout.WEST);
        createTaskCentre.add(containerCentreX, BorderLayout.CENTER);
        createTaskCentre.add(containerCentreX2, BorderLayout.EAST);
        createTaskCentre.add(containerCentreX4);
        createTaskSouth.add(createTaskButton);
        
        createTaskMainPanel.add(createTaskNorth, BorderLayout.NORTH);
        createTaskMainPanel.add(createTaskCentre, BorderLayout.CENTER);
        createTaskMainPanel.add(createTaskSouth, BorderLayout.SOUTH);
        
        createTaskButton.addActionListener(e -> createTask());
        this.add(createTaskMainPanel);
    }
}
