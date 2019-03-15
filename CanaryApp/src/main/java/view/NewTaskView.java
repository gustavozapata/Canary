package view;

import controller.NewTaskListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.AppModel;
import model.DateLabelFormatter;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Gustavo
 */
public class NewTaskView extends JDialog {

    private AppModel taskSettings = new AppModel();

    //PANELS
    private TaskPanel createTaskMainPanel = new TaskPanel();
    private TaskPanel createTaskNorth = new TaskPanel();
    private TaskPanel createTaskCentre = new TaskPanel();
    private TaskPanel createTaskSouth = new TaskPanel();

    private TaskPanel containerTaskDescription = new TaskPanel();
    private TaskPanel containerCentre = new TaskPanel();
    private TaskPanel containerPriority = new TaskPanel();
    private TaskPanel containerPriorityOptions = new TaskPanel();
    private TaskPanel containerTaskAssigned = new TaskPanel();
    private TaskPanel containerTaskDate = new TaskPanel();

    
    
    //COMPONENTS
    private TaskLabel createTaskTitle = new TaskLabel();
    private TaskLabel createTaskDescription = new TaskLabel();
    private TaskLabel createTaskCategory = new TaskLabel();
    private TaskLabel createTaskPriority = new TaskLabel();
    private TaskLabel createTaskAssigned = new TaskLabel();
    private TaskLabel createTaskDate = new TaskLabel();

    static JTextField createTaskDescriptionTextField = new JTextField();
    private JComboBox<String> createTaskCategoryDrop = new JComboBox(taskSettings.getCategories());
    private JComboBox<String> createTaskAssignedDrop = new JComboBox(taskSettings.getCategories());
    private ButtonGroup groupPriority = new ButtonGroup();
    private JRadioButton lowPriority = new JRadioButton(taskSettings.getPriorities()[0]);
    private JRadioButton mediumPriority = new JRadioButton(taskSettings.getPriorities()[1]);
    private JRadioButton highPriority = new JRadioButton(taskSettings.getPriorities()[2]);
    private JButton createTaskButton = new JButton();
    private JDatePickerImpl datePicker;
    private JDatePanelImpl datePanel;

    private NewTaskListener newTaskListener = new NewTaskListener();

    public NewTaskView(String type) {
    }

    public NewTaskView() {
        this.setSize(700, 400);
        this.setLocation(300, 150);
        this.setResizable(false);
        this.createTaskButton.addMouseListener(newTaskListener);
        
        
        //DATE PICKER
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        //PANEL FORMATTING
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

        //COMPONENTS FORMATTING
        createTaskTitle.setNewTaskTitle("New Task");
        createTaskDescription.setNewTaskLabel("Task Description");
        createTaskCategory.setNewTaskLabel("Category");
        createTaskPriority.setNewTaskLabel("Priority");
        createTaskAssigned.setNewTaskLabel("Assigned To");
        createTaskDate.setNewTaskLabel("Date");

        createTaskPriority.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 75));

        createTaskDescriptionTextField.setPreferredSize(new Dimension(520, 30));
        createTaskCategoryDrop.setPreferredSize(new Dimension(150, 30));
        createTaskCategoryDrop.setBackground(Color.white);
        createTaskAssignedDrop.setPreferredSize(new Dimension(100, 30));
        createTaskAssignedDrop.setBackground(Color.white);

        lowPriority.setBackground(Color.white);
        mediumPriority.setBackground(Color.white);
        highPriority.setBackground(Color.white);

        groupPriority.add(lowPriority);
        groupPriority.add(mediumPriority);
        groupPriority.add(highPriority);

        createTaskButton.setText("Create");
        createTaskButton.setForeground(Color.WHITE);
        createTaskButton.setFont(new Font("Sans-serif", Font.BOLD, 18));
        createTaskButton.setBackground(new Color(112, 112, 112));
        datePicker.setPreferredSize(new Dimension(110, 27));
        datePicker.setBackground(Color.white);

        
        //ADDING
        containerTaskAssigned.add(createTaskAssigned);
        containerTaskAssigned.add(createTaskAssignedDrop);

        containerPriorityOptions.add(highPriority);
        containerPriorityOptions.add(mediumPriority);
        containerPriorityOptions.add(lowPriority);

        containerPriority.add(createTaskPriority);
        containerPriority.add(containerPriorityOptions);

        containerCentre.add(createTaskCategory);
        containerCentre.add(createTaskCategoryDrop);

        containerTaskDescription.add(createTaskDescription);
        containerTaskDescription.add(createTaskDescriptionTextField);
        
        containerTaskDate.add(createTaskDate);
        containerTaskDate.add(datePicker);
        
        createTaskNorth.add(createTaskTitle);
        createTaskNorth.add(containerTaskDate);
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

    public ArrayList getProperties() {
        ArrayList newTaskProperties = new ArrayList();

        newTaskProperties.add(createTaskDescriptionTextField.getText());

        return newTaskProperties;
    }

}
