package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import view.AppPanel;
import view.AppView;
import view.TaskLabel;
import view.TaskPanel;

/**
 *
 * @author k1715308
 */
public class AppGUIBuilder {
    AppView mainWindow = AppView.getInstance();

    //APP PANELS
    AppPanel appTopPanel = new AppPanel(new BorderLayout());
    AppPanel appCentrePanel = new AppPanel(new BorderLayout());
    AppPanel appBottomPanel = new AppPanel();

    AppPanel appSettingsPanel = new AppPanel();
    AppPanel newTaskPanel = new AppPanel();
    
    //TASK PANELS
    TaskPanel todoPanel = new TaskPanel(new BorderLayout());
    TaskPanel toolbarPanel = new TaskPanel();
    
    static TaskPanel taskPanel = new TaskPanel();
    static TaskLabel noTasksMsg = new TaskLabel();
    static TaskPanel containerTasks = new TaskPanel("Task Panel");
    
    JScrollPane containerTasksScroll = new JScrollPane(taskPanel);
    
    public void buildAppWindow(){
        containerTasksScroll.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        containerTasksScroll.getVerticalScrollBar().setUnitIncrement(16);
        appSettingsPanel.setPreferredSize(new Dimension(130, 100));
        newTaskPanel.setLayout(new BoxLayout(newTaskPanel, BoxLayout.Y_AXIS));
        newTaskPanel.setPreferredSize(new Dimension(130, 100));
        
        toolbarPanel.renderToolbarPanel();
        noTasksMsg.setNoTaskMsg();
        
        addComponentsAppWindow();
    }
    
    public void generateLabels(){
        mainWindow.setTitle("TODO CANARIO");
        mainWindow.setAppTitle("To-Do Canario");
        mainWindow.setAppFooter("Contact Canary");
        mainWindow.setAppNewTask("New Task");
        mainWindow.setAppLogin("Login");
    }
    
    public void addComponentsAppWindow(){
        
        taskPanel.add(noTasksMsg);
        
        
        todoPanel.add(toolbarPanel, BorderLayout.NORTH);
        todoPanel.add(containerTasksScroll, BorderLayout.CENTER);
        
        
        //APP
        newTaskPanel.add(mainWindow.getAppPlusSign());
        newTaskPanel.add(mainWindow.getAppNewTask());
        
        appSettingsPanel.add(mainWindow.getAppLogin());
        
        appTopPanel.add(mainWindow.getAppTitle(), BorderLayout.CENTER);
        appTopPanel.add(newTaskPanel, BorderLayout.WEST);
        appTopPanel.add(appSettingsPanel, BorderLayout.EAST);
        
        appCentrePanel.add(todoPanel, BorderLayout.CENTER);
        appBottomPanel.add(mainWindow.getAppFooter());
        
        
        //MAIN WINDOW
        mainWindow.add(appTopPanel, BorderLayout.NORTH);
        mainWindow.add(appCentrePanel, BorderLayout.CENTER);
        mainWindow.add(appBottomPanel, BorderLayout.SOUTH);
        mainWindow.setVisible(true);
    }
    
    
    //ADD NEW TASK TO THE TASK PANEL
    public static void renderTasks(){
        taskPanel.remove(noTasksMsg);
        containerTasks.createNewTask();
        taskPanel.add(containerTasks);
        taskPanel.revalidate();
        taskPanel.repaint();
    }
}
