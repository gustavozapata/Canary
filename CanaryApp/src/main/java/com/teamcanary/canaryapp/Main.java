
package com.teamcanary.canaryapp;

import java.awt.BorderLayout;
import java.util.Arrays;
import javax.swing.WindowConstants;
import view.MainWindow;

import model.*;
import view.*;
import controller.SubTaskOperator;

public class Main {
    public static void main(String[] args){
        
        //MAIN WINDOW
        MainWindow window = new MainWindow(); 
        TaskContainer taskManager = new TaskContainer();
        
 
        
        
        
        
        Task t1 = taskManager.newTask("Create a Task");
        Task t2= taskManager.newTask("Create another Task");
        Task t3 = taskManager.newTask("Create a final Task");
        Task t4= taskManager.newTask("Do more stuff!");
        SubTask s1 = taskManager.newSubTask(t1, "Create a new Subtask");
        
        s1.toggleComplete();       
        t1.toggleComplete();
        
        
        
        //t1.getDebugger().Print();
        TasksContainerView tasks = new TasksContainerView(taskManager);
        window.add(tasks,BorderLayout.CENTER);
        window.setVisible(true);
            
    }
}
