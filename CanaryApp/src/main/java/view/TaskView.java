package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.TaskContainer;
import model.Task;
import model.User;

public class TaskView extends JPanel {
    
    TaskPanel topPart = new TaskPanel("Task");
    TaskPanel bottomPart = new TaskPanel("Task");
    TaskPanel checkBoxPanel = new TaskPanel("Task");
    TaskPanel taskDescriptionPanel = new TaskPanel("Task");
    TaskPanel actionsPanel = new TaskPanel("Task");
    TaskPanel taskInfoPanel = new TaskPanel("Task");
    
    TaskLabel taskDescription = new TaskLabel();
    TaskLabel taskCategory = new TaskLabel();
    TaskLabel taskAssignee = new TaskLabel();
    TaskLabel taskPriority = new TaskLabel();
    TaskLabel taskDate = new TaskLabel();
    
    JLabel deleteIcon;
    
    JCheckBox taskCheckBox = new JCheckBox();
    
    Task linkedTask;

    public TaskView() {
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(241, 241, 241));
        this.setPreferredSize(new Dimension(900, 90));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        
        topPart.setLayout(new BorderLayout());
        
        bottomPart.setPreferredSize(new Dimension(200, 25));
        actionsPanel.setPreferredSize(new Dimension(80, 25));
        checkBoxPanel.setPreferredSize(new Dimension(60, 25));
        
        try {
            BufferedImage deleteImg = ImageIO.read(new File("src/images/delete.png"));
            deleteIcon = new JLabel(new ImageIcon(deleteImg));
            deleteIcon.setPreferredSize(new Dimension(5,5));
        } catch(Exception e){}
        
        
//        topPart.setBorder(BorderFactory.createLineBorder(Color.blue));
//        bottomPart.setBorder(BorderFactory.createLineBorder(Color.red));
//        checkBoxPanel.setBorder(BorderFactory.createLineBorder(Color.orange));
//        taskDescriptionPanel.setBorder(BorderFactory.createLineBorder(Color.pink));
//        actionsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//        taskInfoPanel.setBorder(BorderFactory.createLineBorder(Color.magenta));
        
        taskInfoPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));
        
        topPart.add(checkBoxPanel, BorderLayout.WEST);
        topPart.add(taskDescriptionPanel, BorderLayout.CENTER);
        topPart.add(actionsPanel, BorderLayout.EAST);
        bottomPart.add(taskInfoPanel);
        
        addElementsToTask();
        addToTaskContainer();
        
        this.add(topPart, BorderLayout.CENTER);
        this.add(bottomPart, BorderLayout.SOUTH);
    }
    
    public void addElementsToTask(){
        taskDescription.setText(NewTaskView.createTaskDescriptionTextField.getText());
        taskDescription.setBorder(BorderFactory.createEmptyBorder(12, 0, 0, 0));
        taskDescription.setFont(new Font("Sans-Serif", Font.PLAIN, 20));
        
        taskCheckBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));
        taskAssignee.setText("Assigned to: " + NewTaskView.createTaskAssignedDrop.getSelectedItem().toString());
        taskCategory.setText(NewTaskView.createTaskCategoryDrop.getSelectedItem().toString());
        taskPriority.setText("Priority: " + NewTaskView.groupPriority.getSelection().getActionCommand());
        taskPriority.setOpaque(true);
        taskPriority.setBackground(new Color(248,220,39));
        taskPriority.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), new EmptyBorder(0, 5, 0, 5)));
        
        taskCategory.setOpaque(true);
        taskCategory.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), new EmptyBorder(0, 5, 0, 5)));
        setTaskCategory();
        
        actionsPanel.add(deleteIcon);
        
        taskDescriptionPanel.add(taskDescription);
        checkBoxPanel.add(taskCheckBox);
        taskInfoPanel.add(taskCategory);
        taskInfoPanel.add(taskAssignee);
        taskInfoPanel.add(taskPriority);
        
    }
    
   public void addToTaskContainer(){
       this.linkedTask = TaskContainer.getInstance().newTask(NewTaskView.createTaskDescriptionTextField.getText(),new User("jhi","jiji","jiji","jkj"));
   }

   public void setTaskCategory(){
       String category = NewTaskView.createTaskCategoryDrop.getSelectedItem().toString();
       if(category.equals("University")){
           taskCategory.setBackground(new Color(42,188,204));
       } else if(category.equals("Home")){
           taskCategory.setBackground(new Color(151,42,204));
           taskCategory.setForeground(Color.white);
       }
   }
}
