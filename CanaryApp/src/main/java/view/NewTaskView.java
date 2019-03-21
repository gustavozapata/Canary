package view;

import controller.NewTaskListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
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
import model.DateLabelFormatter;
import model.Task;
import model.TaskContainer;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

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
    private TaskPanel containerTaskDate = new TaskPanel();

    
    
    //COMPONENTS
    private JLabel newTaskTitle = new JLabel();
    private JLabel newTaskDescription = new JLabel();
    private JLabel newTaskCategory = new JLabel();
    private JLabel newTaskPriority = new JLabel();
    private JLabel newTaskAssigned = new JLabel();
    private JLabel newTaskDate = new JLabel();
    
    private JTextField createTaskDescriptionTextField = new JTextField();
    private JComboBox<String> createTaskCategoryDrop;
    private JComboBox<String> createTaskAssignedDrop;
    private JRadioButton lowPriority;
    private JRadioButton mediumPriority;
    private JRadioButton highPriority;
    private ButtonGroup groupPriority = new ButtonGroup();
    private JButton createTaskButton = new JButton();
    private JDatePickerImpl datePicker;
    private JDatePanelImpl datePanel;
    
    
    //MODEL
    private AppModel taskSettings = new AppModel();
    
    
    //STYLES
    private NewTaskStyle newTaskStyle = new NewTaskStyle();
    
    
    //LISTENERS
    private NewTaskListener newTaskListener = new NewTaskListener();


    //SINGLETON
    public static NewTaskView instance = null;
    private NewTaskView(){
        this.setSize(700, 400);
        this.setLocation(300, 150);
        this.setResizable(false);
        
        createTaskButton.addMouseListener(newTaskListener);
               
        setComponents();
        styleComponents();
        setPanels();
        
        addComponents(this); 
    }
    
    //SINGLETON METHOD
    public static NewTaskView getInstance(){
        if(NewTaskView.instance == null){
            instance = new NewTaskView();
        }
        return instance;
    }
    
    public void setComponents(){
        createTaskCategoryDrop = new JComboBox(taskSettings.getCategories());
        createTaskAssignedDrop = new JComboBox(taskSettings.getCategories());
        lowPriority = new JRadioButton(taskSettings.getPriorities()[0]);
        mediumPriority = new JRadioButton(taskSettings.getPriorities()[1]);
        highPriority = new JRadioButton(taskSettings.getPriorities()[2]);
        
        setNewTaskTitle("New Task");
        setNewTaskDescription("Task Description");
        setNewTaskCategory("Category");
        setNewTaskPriority("Priority");
        setNewTaskAssigned("Assigned To");
        setNewTaskDate("Date");
        setCreateTaskButton("Create");
        
        //DATE PICKER
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setPreferredSize(new Dimension(110, 27));
        datePicker.setBackground(Color.white);
    }
    
    public void styleComponents(){
        newTaskPriority.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 75));

        createTaskDescriptionTextField.setPreferredSize(new Dimension(520, 30));
        createTaskCategoryDrop.setPreferredSize(new Dimension(150, 30));
        createTaskCategoryDrop.setBackground(Color.white);
        createTaskAssignedDrop.setPreferredSize(new Dimension(100, 30));
        createTaskAssignedDrop.setBackground(Color.white);

        lowPriority.setBackground(Color.white);
        mediumPriority.setBackground(Color.white);
        highPriority.setBackground(Color.white);
        
        lowPriority.setActionCommand("Low");
        mediumPriority.setActionCommand("Medium");
        highPriority.setActionCommand("High");
        mediumPriority.setSelected(true);
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
        containerTaskDate.setBorder(BorderFactory.createEmptyBorder(20, 330, 0, 0));
    }
    
    
    //COMPONENTS SETTERS
    public void setNewTaskTitle(String text){
        this.newTaskTitle.setText(text);
        newTaskStyle.styleNewTaskTitle(this.newTaskTitle);
    }
    
    public void setNewTaskDescription(String text){
        this.newTaskDescription.setText(text);
        newTaskStyle.styleNewTaskSubtitle(this.newTaskDescription);
    }
    
    public void setNewTaskCategory(String text){
        this.newTaskCategory.setText(text);
        newTaskStyle.styleNewTaskSubtitle(this.newTaskCategory);
    }
    
    public void setNewTaskPriority(String text){
        this.newTaskPriority.setText(text);
        newTaskStyle.styleNewTaskSubtitle(this.newTaskPriority);
    }
    
    public void setNewTaskAssigned(String text){
        this.newTaskAssigned.setText(text);
        newTaskStyle.styleNewTaskSubtitle(this.newTaskAssigned);
    }
    
    public void setNewTaskDate(String text){
        this.newTaskDate.setText(text);
        newTaskStyle.styleNewTaskSubtitle(this.newTaskDate);
    }
    
    public void setCreateTaskButton(String text){
        this.createTaskButton.setText(text);
        this.createTaskButton.setName("create_task_btn");
        newTaskStyle.styleCreateTaskButton(this.createTaskButton);
    }
    
    
    //COMPONENTS ADDING
    public void addComponents(NewTaskView newTaskView){
        groupPriority.add(highPriority);
        groupPriority.add(mediumPriority);
        groupPriority.add(lowPriority);
        
        containerTaskAssigned.add(newTaskAssigned);
        containerTaskAssigned.add(createTaskAssignedDrop);

        containerPriorityOptions.add(highPriority);
        containerPriorityOptions.add(mediumPriority);
        containerPriorityOptions.add(lowPriority);

        containerPriority.add(newTaskPriority);
        containerPriority.add(containerPriorityOptions);
        containerCentre.add(newTaskCategory);
        containerCentre.add(createTaskCategoryDrop);
        containerTaskDescription.add(newTaskDescription);
        containerTaskDescription.add(createTaskDescriptionTextField);
        containerTaskDate.add(newTaskDate);
        containerTaskDate.add(datePicker);
        
        createTaskNorth.add(newTaskTitle);
        createTaskNorth.add(containerTaskDate);
        createTaskCentre.add(containerTaskDescription, BorderLayout.WEST);
        createTaskCentre.add(containerCentre, BorderLayout.CENTER);
        createTaskCentre.add(containerPriority, BorderLayout.EAST);
        createTaskCentre.add(containerTaskAssigned);
        createTaskSouth.add(createTaskButton);

        createTaskMainPanel.add(createTaskNorth, BorderLayout.NORTH);
        createTaskMainPanel.add(createTaskCentre, BorderLayout.CENTER);
        createTaskMainPanel.add(createTaskSouth, BorderLayout.SOUTH);

        newTaskView.add(createTaskMainPanel);
    }
    
    
    public Task createNewTask(){
        Task task = new Task();
        task.setTaskDescription(createTaskDescriptionTextField.getText());
        task.setPriority(groupPriority.getSelection().getActionCommand());
        task.setCategory(createTaskCategoryDrop.getSelectedItem().toString());
        task.setAssignedToString(createTaskAssignedDrop.getSelectedItem().toString());
        task.setDate((Date) datePicker.getModel().getValue());
        return task;
    }

}
