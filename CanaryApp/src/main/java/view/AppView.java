package view;

import controller.AppListener;
import controller.NewTaskListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import javax.swing.WindowConstants;
import model.Task;

/**
 *
 * @author Gustavo
 */
public class AppView extends JFrame {
    
    //PANELS #1
    private AppPanel appTopPanel = new AppPanel();
    private AppPanel appBottomPanel = new AppPanel();
    private AppPanel appCentrePanel = new AppPanel();
    private AppPanel appLeftPanel = new AppPanel();
    private AppPanel appRightPanel = new AppPanel();
    
    //PANELS #2
    private AppPanel todoPanel = new AppPanel();
    private AppPanel toolbarPanel = new AppPanel();
    private AppPanel taskPanel = new AppPanel();
    private AppPanel containerTasks = new AppPanel();
    private AppPanel appSettingsPanel = new AppPanel();
    private AppPanel newTaskPanel = new AppPanel();
    private JScrollPane containerTasksScroll = new JScrollPane(taskPanel);
    
    
    //COMPONENTS
    private JLabel appTitle = new JLabel();
    private JLabel appFooter = new JLabel();
    private JLabel appIconPlus = new JLabel();
    private JLabel appNewTask = new JLabel();
    private JLabel appLogin = new JLabel();
    private JLabel appNoTasksMsg = new JLabel();
    
    private JLabel toolbarFilter = new JLabel();
    
    
    //STYLES
    private AppStyle appStyle = new AppStyle();
    
    
    //LISTENERS
    private AppListener appListener = new AppListener();
    
    
    //SINGLETON
    public static AppView instance = null;
    private AppView(){
        super();
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(1200, 700);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        setComponents();
        setPanels();
        
        addComponents(this);        
        
        
        appIconPlus.addMouseListener(appListener);
        appLogin.addMouseListener(appListener);
        
    }
    
    //SINGLETON METHOD
    public static AppView getInstance(){
        if(AppView.instance == null){
            instance = new AppView();
        }
        return instance;
    }
    
    public void setComponents(){
        setAppTitle("To-Do Canary");
        setAppFooter("Contact Canary");
        setAppIconPlus("+");
        setAppNewTask("New Task");
        setAppLogin("Login");
        setAppNoTasksMsg("");
        
        setToolbarFilter("Filter");
    }
    
    public void setPanels(){
        appTopPanel.setLayout(new BorderLayout());
        appCentrePanel.setLayout(new BorderLayout());
        todoPanel.setLayout(new BorderLayout());
        newTaskPanel.setLayout(new BoxLayout(newTaskPanel, BoxLayout.Y_AXIS));
        
        containerTasksScroll.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        containerTasksScroll.getVerticalScrollBar().setUnitIncrement(16);
        BoxLayout boxLayout = new BoxLayout(containerTasks, BoxLayout.Y_AXIS);
        containerTasks.setLayout(boxLayout);
        
        appSettingsPanel.setPreferredSize(new Dimension(130, 100));
        newTaskPanel.setPreferredSize(new Dimension(130, 100));
        
        appStyle.setTaskWindow(todoPanel);
        appStyle.setToolBar(toolbarPanel);
    }
        
    
    //COMPONENTS SETTERS
    public void setAppTitle(String text){
        appTitle.setText(text);
        appStyle.setLabelOne(appTitle);
    }
    
    public void setAppFooter(String text){
        appFooter.setText(text);
        appStyle.setLabelThree(appFooter);
    }
    
    public void setAppIconPlus(String text){
        appIconPlus.setText(text);
        appIconPlus.setName("plus_btn");
        appStyle.setIconPlus(appIconPlus);
    }
    
    public void setAppNewTask(String text){
        appNewTask.setText(text);
        appStyle.setLabelFour(appNewTask);
    }
    
    public void setAppLogin(String text){
        appLogin.setText(text);
        appLogin.setName("login_btn");
        appStyle.setLabelFive(appLogin);
    }
    
    public void setAppNoTasksMsg(String text){
        appNoTasksMsg.setText(text);
        appStyle.setTaskInfo(appNoTasksMsg);
    }
    
    public void setToolbarFilter(String text){
        toolbarFilter.setText(text);
        toolbarFilter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        appStyle.setToolbarItem(toolbarFilter);
    }
    
    
    //COMPONENTS ADDING
    public void addComponents(AppView appView){
        toolbarPanel.add(toolbarFilter);
        
        taskPanel.add(appNoTasksMsg);
        todoPanel.add(toolbarPanel, BorderLayout.NORTH);
        todoPanel.add(containerTasksScroll, BorderLayout.CENTER);
        newTaskPanel.add(appIconPlus);
        newTaskPanel.add(appNewTask);
        appSettingsPanel.add(appLogin);
        
        appTopPanel.add(appTitle, BorderLayout.CENTER);
        appTopPanel.add(newTaskPanel, BorderLayout.WEST);
        appTopPanel.add(appSettingsPanel, BorderLayout.EAST);
        appCentrePanel.add(todoPanel, BorderLayout.CENTER);
        appBottomPanel.add(appFooter);
        
        
        //MAIN WINDOW
        appView.add(appTopPanel, BorderLayout.NORTH);
        appView.add(appCentrePanel, BorderLayout.CENTER);
        appView.add(appBottomPanel, BorderLayout.SOUTH);
    }
    
    public void renderNewTask(TaskView taskView){
        taskPanel.remove(appNoTasksMsg);
        containerTasks.add(taskView);
        taskPanel.add(containerTasks);
        taskPanel.revalidate();
        taskPanel.repaint();
    }
}
