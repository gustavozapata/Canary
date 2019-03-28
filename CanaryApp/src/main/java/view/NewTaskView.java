package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.AppModel;
import model.User;
import controller.NewTaskListener;
import controller.TaskListener;
import controller.UserSystem;
import model.Task;

/**
 *
 * @author Gustavo
 */
public class NewTaskView extends JDialog {

    //PANELS #1
    private TaskPanel createTaskMainPanel = new TaskPanel();
    private TaskPanel createTaskNorth = new TaskPanel();
    private TaskPanel createTaskCentre = new TaskPanel();
    private TaskPanel createTaskSouth = new TaskPanel();

    //PANELS #2
    private TaskPanel containerTaskDescription = new TaskPanel();
    private TaskPanel containerCentre = new TaskPanel();
    private TaskPanel containerPriority = new TaskPanel();
    private TaskPanel containerPriorityOptions = new TaskPanel();
    private TaskPanel containerTaskAssigned = new TaskPanel();

    
    
    //COMPONENTS
    private JLabel newTaskTitle = new JLabel();
    private JLabel newTaskDescription = new JLabel();
    private JLabel newTaskCategory = new JLabel();
    private JLabel newTaskPriority = new JLabel();
    private JLabel newTaskAssigned = new JLabel();
    private JLabel newTaskWarning = new JLabel();
    
    private JTextField createTaskDescriptionTextField = new JTextField();
    private JComboBox<String> createTaskCategoryDrop;
    private JComboBox<String> createTaskAssignedDrop;
    private JComboBox<Integer> createTaskPriorityDrop;
    private JButton createTaskButton = new JButton();
    private Date date = new Date();
    private Task task;
    
    
    //MODEL
    private AppModel taskSettings = new AppModel();
    
    
    //STYLES
    private NewTaskStyle newTaskStyle = new NewTaskStyle();
    
    
    //LISTENERS
    private NewTaskListener newTaskListener = new NewTaskListener();
    private TaskListener taskListener = new TaskListener();


    //SINGLETON
    public static NewTaskView instance = null;
    private NewTaskView(){
        this.setSize(700, 400);
        this.setLocation(300, 150);
        this.setResizable(false);
        this.setLocationRelativeTo(AppView.getInstance());
               
        setComponents();
        styleComponents();
        setPanels();
        
        addComponents(); 
        
        createTaskButton.addMouseListener(newTaskListener);
//        createTaskButton.addMouseListener(taskListener);
    }
    
    //SINGLETON METHOD
    public static NewTaskView getInstance(){
        if(NewTaskView.instance == null){
            instance = new NewTaskView();
        }
        return instance;
    }
    
    public void setUserDropDown(){
        createTaskAssignedDrop.removeAllItems();
        for(User user : UserSystem.loadedUsers){
            createTaskAssignedDrop.addItem(user.getUserName());
        }
    }
    
    public void setComponents(){
        createTaskCategoryDrop = new JComboBox(taskSettings.getCategories());
        createTaskPriorityDrop = new JComboBox(taskSettings.getPriorities());
        createTaskAssignedDrop = new JComboBox();
        setUserDropDown();
        
        setNewTaskTitle("New Task");
        setNewTaskDescription("Task Description");
        setNewTaskCategory("Category");
        setNewTaskPriority("Priority");
        setNewTaskAssigned("Assigned To");
        setCreateTaskButton("Create");
        setNewTaskWarning("Please add a task description");
    }
    
    public void styleComponents(){
        newTaskPriority.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 50));

        createTaskDescriptionTextField.setPreferredSize(new Dimension(520, 30));
        createTaskCategoryDrop.setPreferredSize(new Dimension(150, 30));
        createTaskCategoryDrop.setBackground(Color.white);
        createTaskPriorityDrop.setPreferredSize(new Dimension(80, 30));
        createTaskPriorityDrop.setBackground(Color.white);
        createTaskAssignedDrop.setPreferredSize(new Dimension(100, 30));
        createTaskAssignedDrop.setBackground(Color.white);
        
        newTaskWarning.setVisible(false);
    }
    
    public void setPanels(){
        createTaskMainPanel.setLayout(new BorderLayout());
        createTaskMainPanel.setBackground(Color.WHITE);

        createTaskNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
        createTaskNorth.setBorder(BorderFactory.createEmptyBorder(0, 25, 15, 0));
        createTaskSouth.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        containerCentre.setLayout(new BoxLayout(containerCentre, BoxLayout.Y_AXIS));
        containerPriority.setLayout(new BoxLayout(containerPriority, BoxLayout.Y_AXIS));
        containerTaskAssigned.setLayout(new BoxLayout(containerTaskAssigned, BoxLayout.Y_AXIS));
        containerTaskDescription.setLayout(new BoxLayout(containerTaskDescription, BoxLayout.Y_AXIS));
        containerTaskDescription.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 110));
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
    
    public void setNewTaskCategory(String text){
        newTaskCategory.setText(text);
        newTaskStyle.styleNewTaskSubtitle(newTaskCategory);
    }
    
    public void setNewTaskPriority(String text){
        newTaskPriority.setText(text);
        newTaskStyle.styleNewTaskSubtitle(newTaskPriority);
    }
    
    public void setNewTaskAssigned(String text){
        newTaskAssigned.setText(text);
        newTaskStyle.styleNewTaskSubtitle(newTaskAssigned);
    }
    
    public void setNewTaskWarning(String text){
        newTaskWarning.setText(text);
        newTaskStyle.styleNewTaskWarning(newTaskWarning);
    }
    
    public void setCreateTaskButton(String text){
        createTaskButton.setText(text);
        createTaskButton.setName("create_task_btn");
        newTaskStyle.styleCreateTaskButton(createTaskButton);
    }
    
    public void setEditTaskButton(String text){
        createTaskButton.setText(text);
        createTaskButton.setName("save_task_btn");
        newTaskStyle.styleCreateTaskButton(createTaskButton);
    }
    
    public void setSubTaskButton(String text){
        createTaskButton.setText(text);
        createTaskButton.setName("create_subtask_btn");
        newTaskStyle.styleCreateTaskButton(createTaskButton);
    }
    
    
    public JLabel getNewTaskWarning(){
        return this.newTaskWarning;
    }
    
    public String getCreateTaskDescriptionTextField(){
        return createTaskDescriptionTextField.getText();
    }
    
    
    //COMPONENTS ADDING
    public void addComponents(){
        
        containerTaskAssigned.add(newTaskAssigned);
        containerTaskAssigned.add(createTaskAssignedDrop);

        containerPriorityOptions.add(createTaskPriorityDrop);

        containerPriority.add(newTaskPriority);
        containerPriority.add(containerPriorityOptions);
        containerCentre.add(newTaskCategory);
        containerCentre.add(createTaskCategoryDrop);
        containerTaskDescription.add(newTaskDescription);
        containerTaskDescription.add(createTaskDescriptionTextField);
        containerTaskDescription.add(newTaskWarning);
        
        createTaskNorth.add(newTaskTitle);
        createTaskCentre.add(containerTaskDescription, BorderLayout.WEST);
        createTaskCentre.add(containerCentre, BorderLayout.CENTER);
        createTaskCentre.add(containerPriority, BorderLayout.EAST);
        createTaskCentre.add(containerTaskAssigned);
        createTaskSouth.add(createTaskButton);

        createTaskMainPanel.add(createTaskNorth, BorderLayout.NORTH);
        createTaskMainPanel.add(createTaskCentre, BorderLayout.CENTER);
        createTaskMainPanel.add(createTaskSouth, BorderLayout.SOUTH);

        this.add(createTaskMainPanel);
    }
    
    public void showWarning(){
        newTaskWarning.setVisible(true);
    }
    
    public void emptyFields(){
        createTaskDescriptionTextField.setText("");
        createTaskCategoryDrop.setSelectedItem("University");
        createTaskPriorityDrop.setSelectedItem(10);
        newTaskWarning.setVisible(false);
    }
    
    public void setEditReady() {
        createTaskButton.setText("Save");
        createTaskButton.setName("save_task_btn");
        setNewTaskTitle("Edit Task");
        newTaskWarning.setVisible(false);
    }
    
    
    //METHOD THAT CREATES A NEW TASK
    public Task createTask(){
        Task task = new Task();
        task.setDescription(createTaskDescriptionTextField.getText());
        task.setPriorityOrder((Integer)createTaskPriorityDrop.getSelectedItem());
        task.setCategory(createTaskCategoryDrop.getSelectedItem().toString());
        for(User user : UserSystem.loadedUsers){
            if(user.getUserName().equals(createTaskAssignedDrop.getSelectedItem().toString())){
                task.setUser(user);
                break;
            }
        }
        task.setCompletionDate(date);
        task.setComplete(false);
        return task;
    }
    
    public Task getTask() {
        return task;
    }
    
    public void setTask(Task task){
        this.task = task;
    }
    
    
    public void setTaskToEdit(Task taskToEdit) {
        createTaskDescriptionTextField.setText(taskToEdit.getDescription());
        createTaskCategoryDrop.setSelectedItem(taskToEdit.getCategory());
        createTaskPriorityDrop.setSelectedItem(taskToEdit.getPriorityOrder());
        createTaskAssignedDrop.setSelectedItem(taskToEdit.getUser().getUserName());
    }
    
    
    public void saveEditedTask(Task taskEdited){
        taskEdited.setDescription(createTaskDescriptionTextField.getText());
        taskEdited.setPriorityOrder((Integer)createTaskPriorityDrop.getSelectedItem());
        taskEdited.setCategory(createTaskCategoryDrop.getSelectedItem().toString());
        for(User user : UserSystem.loadedUsers){
            if(user.getUserName().equals(createTaskAssignedDrop.getSelectedItem().toString())){
                taskEdited.setUser(user);
                break;
            }
        }
    }

}
