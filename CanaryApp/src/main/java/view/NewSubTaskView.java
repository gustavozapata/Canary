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
    private JComboBox<Integer> createTaskPriorityDrop;
    private ButtonGroup groupPriority = new ButtonGroup();
    private JButton createTaskButton = new JButton();
    
    
    //MODEL
    private AppModel taskSettings = new AppModel();
    private Task task;
    
    
    //STYLES
    private NewTaskStyle newTaskStyle = new NewTaskStyle();
    
    
    //LISTENERS
    private NewTaskListener newTaskListener = new NewTaskListener();


    //SINGLETON
    public static NewSubTaskView instance = null;
    private NewSubTaskView(){
        this.setSize(600, 350);
        this.setResizable(false);
        this.setLocationRelativeTo(AppView.getInstance());
               
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
        setNewTaskTitle("New Subtask");
        setNewTaskDescription("Subtask Description");
        setNewTaskPriority("Priority");
        setCreateTaskButton("Create");
        setNewTaskWarning("Please add a subtask description");
    }
    
    public void styleComponents(){
        newTaskPriority.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        createTaskDescriptionTextField.setPreferredSize(new Dimension(520, 30));
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
        
        createTaskPriorityDrop = new JComboBox(taskSettings.getPriorities());
        createTaskPriorityDrop.setPreferredSize(new Dimension(80, 30));
        createTaskPriorityDrop.setBackground(Color.white);
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
    
    
    public String getCreateTaskDescriptionTextField(){
        return createTaskDescriptionTextField.getText();
    }
    
    public Task getTask(){
        return task;
    }
    
    
    //COMPONENTS ADDING
    public void addComponents(NewSubTaskView newSubtaskView){
        containerTaskDescription.add(newTaskDescription);
        containerTaskDescription.add(createTaskDescriptionTextField);
        containerTaskDescription.add(newTaskWarning);
        
        containerPriorityOptions.add(createTaskPriorityDrop);
        containerPriority.add(newTaskPriority);
        containerPriority.add(containerPriorityOptions);
        
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

        newSubtaskView.add(createTaskMainPanel);
    }
    
    
    public void createNewSubTask(){
        SubTask subtask = new SubTask();
        subtask.setDescription(createTaskDescriptionTextField.getText());
        subtask.setPriorityOrder((Integer)createTaskPriorityDrop.getSelectedItem());
        task.addSubTask(subtask);
    }
    
    public void showWarning(){
        newTaskWarning.setVisible(true);
    }
    
    public void emptyFields(){
        createTaskDescriptionTextField.setText("");
        createTaskPriorityDrop.setSelectedItem(10);
        newTaskWarning.setVisible(false);
    }

    public void setTask(Task task) {
        this.task = task;
    }

}
