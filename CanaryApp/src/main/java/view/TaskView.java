package view;

import controller.AppController;
import controller.TaskListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Task;
import model.User;

public class TaskView extends JPanel {

    //PANELS #1
    private TaskPanel topPart;
    private TaskPanel bottomPart;
    private TaskPanel checkBoxPanel;
    private TaskPanel taskDescriptionPanel;
    private TaskPanel actionsPanel;
    private TaskPanel taskInfoPanel;
        
    //PANELS #2
    private TaskPanel subtaskPanel;
    private TaskPanel editPanel;
    private TaskPanel deletePanel;

    
    //COMPONENTS
    private JLabel taskDescription = new JLabel();
    private JLabel taskCategory = new JLabel();
    private JLabel taskAssignee = new JLabel();
    private JLabel taskPriority = new JLabel();
    private JLabel taskDate = new JLabel();
    private Date selectedDate;

    private JLabel subtaskLabel = new JLabel();
    private JLabel editLabel = new JLabel();
    private JLabel deleteLabel = new JLabel();
    private JCheckBox taskCheckBox = new JCheckBox();
    SimpleDateFormat format;

    //ICONS
    private JLabel deleteIcon;
    private JLabel editIcon;
    private JLabel subtaskIcon;

    
    //STYLES
    private TaskStyle taskStyle = new TaskStyle();

    
    //LISTENERS
    private TaskListener taskListener = new TaskListener();
    private AppController appListener = new AppController();


    public TaskView(Task task) {
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(241, 241, 241));
        this.setPreferredSize(new Dimension(900, 90));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

//        this.taskCheckBox.addMouseListener(this.appListener);
        
        this.topPart = new TaskPanel("Task");
        this.bottomPart = new TaskPanel("Task");
        this.checkBoxPanel = new TaskPanel("Task");
        this.taskDescriptionPanel = new TaskPanel("Task");
        this.actionsPanel = new TaskPanel("Task");
        this.taskInfoPanel = new TaskPanel("Task");

        this.subtaskPanel = new TaskPanel("Task");
        this.editPanel = new TaskPanel("Task");
        this.deletePanel = new TaskPanel("Task");
        
        setPanels();
        initializeImages();
        setComponents();
        
        addElementsToTask(task);
        addComponents();
        
        this.taskCheckBox.addMouseListener(this.taskListener);
        this.subtaskPanel.addMouseListener(this.taskListener);
        this.editPanel.addMouseListener(this.taskListener);
        this.deletePanel.addMouseListener(this.taskListener);
    }
    
    public void setComponents(){
        this.subtaskLabel.setText("Subtask");
        this.editLabel.setText("Edit");
        this.deleteLabel.setText("Delete");
        
        this.subtaskIcon.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 0));
        this.editIcon.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        this.deleteIcon.setBorder(BorderFactory.createEmptyBorder(0, 7, 5, 0));
        
        this.subtaskPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.editPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.deletePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.taskCheckBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        this.subtaskPanel.setName("subtask_btn");
        this.editPanel.setName("edit_btn");
        this.deletePanel.setName("delete_btn");
    }
    
    
    public void setPanels(){
        this.topPart.setLayout(new BorderLayout());
                
        this.bottomPart.setPreferredSize(new Dimension(200, 25));
        this.actionsPanel.setPreferredSize(new Dimension(120, 25));
        this.checkBoxPanel.setPreferredSize(new Dimension(60, 25));
        
        this.taskInfoPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));
        this.actionsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 13, 5));
                        
        taskStyle.styleActionLabel(this.subtaskLabel);
        taskStyle.styleActionLabel(this.editLabel);
        taskStyle.styleActionLabel(this.deleteLabel);
    }
    
    public void initializeImages(){
        try {
            BufferedImage deleteImg = ImageIO.read(new File("src/images/delete.png"));
            BufferedImage editImg = ImageIO.read(new File("src/images/edit.png"));
            BufferedImage subtaskImg = ImageIO.read(new File("src/images/subtask.png"));
            this.deleteIcon = new JLabel(new ImageIcon(deleteImg));
            this.editIcon = new JLabel(new ImageIcon(editImg));
            this.subtaskIcon = new JLabel(new ImageIcon(subtaskImg));

            this.taskCheckBox.setSelectedIcon(new ImageIcon(ImageIO.read(new File("src/images/checked.png"))));
            this.taskCheckBox.setIcon(new ImageIcon(ImageIO.read(new File("src/images/checkbox.png"))));
        } catch (IOException e) {
        }
    }
    
    public void addElementsToTask(Task task) {
        this.taskDescription.setText(task.getTaskDescription());
        this.taskDescription.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        this.taskDescription.setFont(new Font("SansSerif", Font.PLAIN, 20));

        this.taskCheckBox.setName("check_btn");
        this.taskCheckBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));
        this.taskAssignee.setText("Assigned to: " + task.getAssignedToString());
        this.taskCategory.setText(task.getCategory());
        this.taskPriority.setText("Priority: " + task.getPriority());
        this.taskPriority.setOpaque(true);
        this.taskPriority.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), new EmptyBorder(0, 5, 0, 5)));
        
        setPriority(task);
        setDueDate(task);

        this.taskCategory.setOpaque(true);
        this.taskCategory.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), new EmptyBorder(0, 5, 0, 5)));
        
        setTaskCategory(task);
        
    }
    
    public void addComponents(){
        this.subtaskPanel.add(subtaskIcon);
        this.subtaskPanel.add(subtaskLabel);
        this.editPanel.add(editIcon);
        this.editPanel.add(editLabel);
        this.deletePanel.add(deleteIcon);
        this.deletePanel.add(deleteLabel);

        this.actionsPanel.add(subtaskPanel);
        this.actionsPanel.add(editPanel);
        this.actionsPanel.add(deletePanel);

        this.taskDescriptionPanel.add(taskDescription);
        this.checkBoxPanel.add(taskCheckBox);
        this.taskInfoPanel.add(taskCategory);
        this.taskInfoPanel.add(taskAssignee);
        this.taskInfoPanel.add(taskPriority);
        this.taskInfoPanel.add(taskDate);
        
        this.topPart.add(checkBoxPanel, BorderLayout.WEST);
        this.topPart.add(taskDescriptionPanel, BorderLayout.CENTER);
        this.topPart.add(actionsPanel, BorderLayout.EAST);
        this.bottomPart.add(taskInfoPanel);
        
        this.add(topPart, BorderLayout.CENTER);
        this.add(bottomPart, BorderLayout.SOUTH);
    }

    public void setDueDate(Task task) {
//        format = new SimpleDateFormat("dd-MM-yyyy");
//        taskDate.setText("Due: " + format.format(selectedDate));
        selectedDate = (Date) task.getDate();
        taskDate.setText("Due: " + selectedDate);
        taskDate.setForeground(new Color(255, 29, 83));
    }

    public void setPriority(Task task) {
        String priority = task.getPriority();
        if (priority.equals("High")) {
            taskPriority.setBackground(new Color(248, 171, 39));
        } else if (priority.equals("Low")) {
            taskPriority.setBackground(new Color(234, 248, 39));
        } else {
            taskPriority.setBackground(new Color(248, 220, 39));
        }
    }

    public void setTaskCategory(Task task) {
        String category = task.getCategory();
        taskCategory.setForeground(Color.white);
        if (category.equals("University")) {
            taskCategory.setBackground(new Color(42, 188, 204));
        } else if (category.equals("Home")) {
            taskCategory.setBackground(new Color(151, 42, 204));
        } else if (category.equals("Personal")) {
            taskCategory.setBackground(new Color(53, 204, 42));
        } else if (category.equals("Work")) {
            taskCategory.setBackground(new Color(241, 53, 117));
        }
    }
}
