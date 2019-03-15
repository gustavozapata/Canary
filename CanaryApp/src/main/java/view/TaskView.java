package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
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
    TaskLabel taskAssignee = new TaskLabel();
    TaskLabel taskCategory = new TaskLabel();
    TaskLabel taskDate = new TaskLabel();
    
    Task linkedTask;

    public TaskView() {
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(241, 241, 241));
        this.setPreferredSize(new Dimension(900, 90));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        
        topPart.setLayout(new BorderLayout());
        
        bottomPart.setPreferredSize(new Dimension(200, 25));
        actionsPanel.setPreferredSize(new Dimension(80, 25));
        checkBoxPanel.setPreferredSize(new Dimension(80, 25));
        
        topPart.setBorder(BorderFactory.createLineBorder(Color.blue));
        bottomPart.setBorder(BorderFactory.createLineBorder(Color.red));
        checkBoxPanel.setBorder(BorderFactory.createLineBorder(Color.orange));
        taskDescriptionPanel.setBorder(BorderFactory.createLineBorder(Color.pink));
        actionsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        taskInfoPanel.setBorder(BorderFactory.createLineBorder(Color.magenta));
        
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
        taskDescriptionPanel.add(taskDescription);
    }
    
   public void addToTaskContainer(){
       this.linkedTask = TaskContainer.getInstance().newTask(NewTaskView.createTaskDescriptionTextField.getText(),new User("jhi","jiji","jiji","jkj"));
   }

}
