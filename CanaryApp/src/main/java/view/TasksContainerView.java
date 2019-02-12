/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class TasksContainerView extends JPanel{
    
    
    
   public TasksContainerView(TaskContainer container){
       
       JPanel listPane = new JPanel();
       listPane.setLayout(new BoxLayout(listPane, BoxLayout.Y_AXIS));
       //listPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
       
       
       System.out.println("Searching for tasks");
       System.out.println(container.getAll());
       
       
       // Getting every Task and Subtask and adding a new TaskView for it
       for (Task task: container.getAll()) {  
        TaskView new_task = new TaskView(task.getTaskDescription(),task.getComplete());
        listPane.add(new_task);
            for (SubTask subtask: task.getSubTaskContainer().getAll()) {  
                TaskView new_subtask = new TaskView(subtask.getTaskDescription(),subtask.getComplete());
                listPane.add(new_subtask);
            }        
                
                
        
        listPane.add(new JSeparator());
       }
       
       this.add(listPane);

       

       
       
    
       
      

       
    }
   
}
