package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import model.SubTask;
import model.Task;
import model.TaskContainer;
import controller.TaskSystem;

public class TasksContainerView extends JPanel{
    
    
    
   public TasksContainerView(){
       
       JPanel listPane = new JPanel();
       listPane.setLayout(new BoxLayout(listPane, BoxLayout.Y_AXIS));
          
       System.out.println("Searching for tasks");
       System.out.println(TaskSystem.taskManager.getAll());
       this.setPreferredSize(new Dimension(912, 600));

       
       
       // Getting every Task and Subtask and adding a new TaskView for it
       for (Task task: TaskSystem.taskManager.getAll()) {  
        TaskView new_task = new TaskView(task.getTaskDescription(),task.getComplete(),task.getAssignedTo());
        listPane.add(new_task);
            for (SubTask subtask: task.getSubTaskContainer().getAll()) {  
                TaskView new_subtask = new TaskView(subtask.getTaskDescription(),subtask.getComplete(),subtask.getAssignedTo());
                listPane.add(new_subtask);
            
            }        
                
                
        
        listPane.add(new JSeparator());
       }
       
       this.add(listPane);

   }

       
       
    
       
      

       
    }