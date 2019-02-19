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
import java.awt.Color;

public class TasksContainerView extends JPanel{
    
    
    
   public TasksContainerView(){
       
       JPanel listPane = new JPanel();
       listPane.setLayout(new BoxLayout(listPane, BoxLayout.Y_AXIS));
       listPane.setSize(new Dimension(900,1000));
       JScrollPane scrollPane = new JScrollPane(listPane);
       scrollPane.setPreferredSize(new Dimension(900,450));
       scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       //listPane.setBackground(Color.green);
       
       // Getting every Task and Subtask and adding a new TaskView for it
       for (Task task: TaskSystem.taskManager.getAll()) {  
        TaskView new_task = new TaskView(task.getTaskDescription(),task.getComplete(),task.getAssignedTo());
        listPane.add(new_task);
           // for (SubTask subtask: task.getSubTaskContainer().getAll()) {  
            //    TaskView new_subtask = new TaskView(subtask.getTaskDescription(),subtask.getComplete(),subtask.getAssignedTo());
             //   listPane.add(new_subtask);        
           // }        
       // listPane.add(new JSeparator());
       }
       
       
       this.add(scrollPane);

   }

       
       
    
       
      

       
    }