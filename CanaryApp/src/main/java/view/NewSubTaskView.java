package view;

import controller.NewTaskListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.AppModel;
import model.SubTask;
import model.Task;

/**
 *
 * @author Gustavo
 */
public class NewSubTaskView extends JDialog {

    //PANELS #1
    private TaskPanel createTaskMainPanel = new TaskPanel();
    private TaskPanel createTaskNorth = new TaskPanel();
    private TaskPanel createTaskCentre = new TaskPanel();
    private TaskPanel createTaskSouth = new TaskPanel();

    //PANELS #2
    private TaskPanel containerTaskDescription = new TaskPanel();
    private TaskPanel containerPriority = new TaskPanel();
    private TaskPanel containerPriorityOptions = new TaskPanel();
    private TaskPanel containerCentre = new TaskPanel();

    
    
    //COMPONENTS
    private JLabel newTaskTitle = new JLabel();
    private JLabel newTaskDescription = new JLabel();
    private JLabel newTaskPriority = new JLabel();
    private JLabel newTaskWarning = new JLabel();
    
    private JTextField createTaskDescriptionTextField = new JTextField();
    private JRadioButton lowPriority;
    private JRadioButton mediumPriority;
    private JRadioButton highPriority;
    private ButtonGroup groupPriority = new ButtonGroup();
    private JButton createTaskButton = new JButton();
    
    
    //MODEL
    private AppModel taskSettings = new AppModel();
    
    
    //STYLES
    private NewTaskStyle newTaskStyle = new NewTaskStyle();
    
    
    //LISTENERS
    private NewTaskListener newTaskListener = new NewTaskListener();
//    private AppController appListener = new AppController();


    //SINGLETON
    public static NewSubTaskView instance = null;
    private NewSubTaskView(){
        this.setSize(600, 350);
        this.setResizable(false);
               
        setComponents();
        styleComponents();
        setPanels();
        addComponents(this); 
        
        createTaskButton.addMouseListener(newTaskListener);
    }
    
    //SINGLETON METHOD
    public static NewSubTaskView getInstance(){
        if(NewSubTaskView.instance == null){
            instance = new NewSubTaskView();
        }
        return instance;
    }
    
    public void setComponents(){
        lowPriority = new JRadioButton(taskSettings.getPriorities()[0]);
        mediumPriority = new JRadioButton(taskSettings.getPriorities()[1]);
        highPriority = new JRadioButton(taskSettings.getPriorities()[2]);
        
        setNewTaskTitle("New Subtask");
        setNewTaskDescription("Subtask Description");
        setNewTaskPriority("Priority");
        setCreateTaskButton("Create");
        setNewTaskWarning("Please add a subtask description");
    }
    
    public void styleComponents(){
        newTaskPriority.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 75));

        createTaskDescriptionTextField.setPreferredSize(new Dimension(520, 30));

        lowPriority.setBackground(Color.white);
        mediumPriority.setBackground(Color.white);
        highPriority.setBackground(Color.white);
        
        lowPriority.setActionCommand("Low");
        mediumPriority.setActionCommand("Medium");
        highPriority.setActionCommand("High");
        mediumPriority.setSelected(true);
        newTaskWarning.setVisible(false);
    }
    
    public void setPanels(){
        createTaskMainPanel.setLayout(new BorderLayout());
        createTaskMainPanel.setBackground(Color.WHITE);

        createTaskNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
        createTaskNorth.setBorder(BorderFactory.createEmptyBorder(0, 25, 5, 0));
        createTaskSouth.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        containerCentre.setLayout(new BoxLayout(containerCentre, BoxLayout.Y_AXIS));
        containerCentre.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
        containerTaskDescription.setLayout(new BoxLayout(containerTaskDescription, BoxLayout.Y_AXIS));
        containerTaskDescription.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 20));
    }
    
    
    //COMPONENTS SETTERS
    public void setNewTaskTitle(String text){
        newTaskTitle.setText(text);
        newTaskStyle.styleNewTaskTitle(newTaskTitle);
    }
    
    public void setNewTaskDescription(String text){
        newTaskDescription.setText(text);
        newTaskStyle.styleNewTaskSubtitle(newTaskDescription);
    }
    
    public void setNewTaskPriority(String text){
        newTaskPriority.setText(text);
        newTaskStyle.styleNewTaskSubtitle(newTaskPriority);
    }
        
    public void setNewTaskWarning(String text){
        newTaskWarning.setText(text);
        newTaskStyle.styleNewTaskWarning(newTaskWarning);
    }
    
    public void setCreateTaskButton(String text){
        createTaskButton.setText(text);
        createTaskButton.setName("create_subtask_btn");
        newTaskStyle.styleCreateTaskButton(createTaskButton);
    }
    
    public void setEditTaskButton(String text){
        createTaskButton.setText(text);
        createTaskButton.setName("save_subtask_btn");
        newTaskStyle.styleCreateTaskButton(createTaskButton);
    }
    
    
    public String getCreateTaskDescriptionTextField(){
        return createTaskDescriptionTextField.getText();
    }
    
    
    //COMPONENTS ADDING
    public void addComponents(NewSubTaskView newSubTaskView){
        groupPriority.add(highPriority);
        groupPriority.add(mediumPriority);
        groupPriority.add(lowPriority);

        containerPriorityOptions.add(highPriority);
        containerPriorityOptions.add(mediumPriority);
        containerPriorityOptions.add(lowPriority);

        containerPriority.add(containerPriorityOptions);
        containerTaskDescription.add(newTaskDescription);
        containerTaskDescription.add(createTaskDescriptionTextField);
        containerTaskDescription.add(newTaskWarning);
        
        containerCentre.add(newTaskPriority);
        containerCentre.add(containerPriorityOptions);
        
        createTaskNorth.add(newTaskTitle);
        createTaskCentre.add(containerTaskDescription, BorderLayout.WEST);
        createTaskCentre.add(containerCentre, BorderLayout.CENTER);
        createTaskCentre.add(containerPriority, BorderLayout.EAST);
        createTaskSouth.add(createTaskButton);

        createTaskMainPanel.add(createTaskNorth, BorderLayout.NORTH);
        createTaskMainPanel.add(createTaskCentre, BorderLayout.CENTER);
        createTaskMainPanel.add(createTaskSouth, BorderLayout.SOUTH);

        newSubTaskView.add(createTaskMainPanel);
    }
    
    
    public SubTask createNewSubTask(){
        SubTask subtask = new SubTask();
        subtask.setDescription(createTaskDescriptionTextField.getText());
        subtask.setPriority(groupPriority.getSelection().getActionCommand());
//        subtask.setAssignedToString(createTaskAssignedDrop.getSelectedItem().toString());  SAME ASSIGNEE AS TASK
        return subtask;
    }
    
    public void showWarning(){
        newTaskWarning.setVisible(true);
    }
    
    public void emptyFields(){
        createTaskDescriptionTextField.setText("");
        mediumPriority.setSelected(true);
        newTaskWarning.setVisible(false);
    }

}
