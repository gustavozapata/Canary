/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import view.AppPanel;
import view.AppWindow;
import view.TasksContainerView;
import view.TodoPanel;
import view.TodoText;

/**
 *
 * @author K1713627
 */
public class GUIManager {
    
    public static TasksContainerView task_view;
    public static AppWindow window = new AppWindow();
    
    public static void refresh(){
        task_view.createView();
        System.out.println("REFRESH");
        
    }
    
    public static void createWindow(){
        window.setTitle("TODO CANARIO");
        window.setAppTitle("To-Do Canario");
        window.setAppFooter("Contact Canary");
        window.setAppNewTask("New Task");
        window.setAppLogin("Login");
        
    }
    
    public static void createTaskView(){

           //APP - PANELS
        AppPanel appTopPanel = new AppPanel(new BorderLayout());
        AppPanel appCentrePanel = new AppPanel(new BorderLayout());
        AppPanel appBottomPanel = new AppPanel();
        
        AppPanel appSettingsPanel = new AppPanel();
        appSettingsPanel.setPreferredSize(new Dimension(130, 100));
        
        AppPanel newTaskPanel = new AppPanel();
        newTaskPanel.setLayout(new BoxLayout(newTaskPanel, BoxLayout.Y_AXIS));
        newTaskPanel.setPreferredSize(new Dimension(130, 100));
  
        
        
        //TODO - PANELS
        TodoPanel todoPanel = new TodoPanel(new BorderLayout());
        TodoPanel tasksPanel = new TodoPanel();
        TodoPanel toolbarPanel = new TodoPanel();
        toolbarPanel.renderToolbarPanel();
        
        //TODO - TASKS
        TasksContainerView tasksview = new TasksContainerView();
        tasksPanel.add(tasksview);
        GUIManager.task_view = tasksview;
        
        //TODO - LABELS
        TodoText noTasksMsg = new TodoText();
        noTasksMsg.setNoTaskMsg();
        
        
        
        //##### ADDING #####
        
        //TODO
        tasksPanel.add(noTasksMsg);
        
        //TODO
        todoPanel.add(toolbarPanel, BorderLayout.NORTH);
        todoPanel.add(tasksPanel, BorderLayout.CENTER);
        
        
        //APP
        newTaskPanel.add(window.getAppPlusSign());
        newTaskPanel.add(window.getAppNewTask());
        
        appSettingsPanel.add(window.getAppLogin());
        
        appTopPanel.add(window.getAppTitle(), BorderLayout.CENTER);
        appTopPanel.add(newTaskPanel, BorderLayout.WEST);
        appTopPanel.add(appSettingsPanel, BorderLayout.EAST);
        
        appCentrePanel.add(todoPanel, BorderLayout.CENTER);
        appBottomPanel.add(window.getAppFooter());
        
        
       
        
        //MAIN WINDOW
        window.add(appTopPanel, BorderLayout.NORTH);
        window.add(appCentrePanel, BorderLayout.CENTER);
        window.add(appBottomPanel, BorderLayout.SOUTH);
        window.setVisible(true);
    }
    
    
    
    
    
    
}
