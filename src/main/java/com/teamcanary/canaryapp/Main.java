package com.teamcanary.canaryapp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import view.AppPanel;
import view.AppWindow;
import view.TodoPanel;
import model.*;
import view.TasksContainerView;


public class Main {
    public static void main(String[] args){
        
         
        Task t1 = TaskSystem.taskManager.newTask("Create a Task");
        Task t2= TaskSystem.taskManager.newTask("Create another Task");
        Task t3 = TaskSystem.taskManager.newTask("Create a final Task");
        Task t4= TaskSystem.taskManager.newTask("Do more stuff!");
        SubTask s1 = TaskSystem.taskManager.newSubTask(t4,"Create a new Subtask");
        
        
        
        s1.toggleComplete();       
        t1.toggleComplete();
        
        
        
        
        //MAIN WINDOW - SETTINGS
        AppWindow window = new AppWindow();
        window.setTitle("TODO CANARIO");
        window.setAppTitle("To-Do Canario");
        window.setAppFooter("Contact Canary");
        window.setAppNewTask("New Task");
        window.setAppLogin("Login");
        
        
        
        //MAIN WINDOW - PANELS
        AppPanel appTopPanel = new AppPanel(new BorderLayout());
        AppPanel appCentrePanel = new AppPanel(new BorderLayout());
        AppPanel appBottomPanel = new AppPanel();
        
        AppPanel appSettingsPanel = new AppPanel();
        
        AppPanel newTaskPanel = new AppPanel();
        newTaskPanel.setLayout(new BoxLayout(newTaskPanel, BoxLayout.Y_AXIS));
  
        
        
        //TODO - PANELS
        TodoPanel todoPanel = new TodoPanel(new BorderLayout());
        TodoPanel tasksPanel = new TodoPanel();
        TodoPanel toolbarPanel = new TodoPanel();
        toolbarPanel.renderToolbarPanel();
        
        
        
        
        
        // -------------- MOVE THIS TO ANOTHER CLASS ---------------
        newTaskPanel.setPreferredSize(new Dimension(130, 100));
        window.getAppNewTask().setBorder(BorderFactory.createEmptyBorder(0,30,0,0));
        window.getAppPlusSign().setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
        
        appSettingsPanel.setPreferredSize(new Dimension(130, 100));
        window.getAppLogin().setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
        //-----------------------------------------------------------
        
        
        
        
        
        //##### ADDING #####
        
        //TODO
        todoPanel.add(toolbarPanel, BorderLayout.NORTH);
        todoPanel.add(tasksPanel, BorderLayout.WEST);
        
        
        //APP
        newTaskPanel.add(window.getAppPlusSign());
        newTaskPanel.add(window.getAppNewTask());
        
        appSettingsPanel.add(window.getAppLogin());
        
        appTopPanel.add(window.getAppTitle(), BorderLayout.CENTER);
        appTopPanel.add(newTaskPanel, BorderLayout.WEST);
        appTopPanel.add(appSettingsPanel, BorderLayout.EAST);
        
        appCentrePanel.add(todoPanel, BorderLayout.CENTER);
        
        TasksContainerView tasks = new TasksContainerView();     
        tasksPanel.add(tasks);
        
        appBottomPanel.add(window.getAppFooter());
        
        
       
        
        //MAIN WINDOW
        window.add(appTopPanel, BorderLayout.NORTH);
        window.add(appCentrePanel, BorderLayout.CENTER);
        window.add(appBottomPanel, BorderLayout.SOUTH);
        window.setVisible(true);
    }
}
        
