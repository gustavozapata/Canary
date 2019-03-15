package view;

import controller.AppListener;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class AppView extends JFrame {
    
    //PANELS
    private AppPanel appTopPanel = new AppPanel();
    private AppPanel appBottomPanel = new AppPanel();
    private AppPanel appCentrePanel = new AppPanel();
    private AppPanel appLeftPanel = new AppPanel();
    private AppPanel appRightPanel = new AppPanel();
    
    //COMPONENTS
    private AppLabel appTitle = new AppLabel();
    private AppLabel appFooter = new AppLabel();
    private AppLabel appPlusSign = new AppLabel("+");
    private AppLabel appNewTask = new AppLabel();
    private AppLabel appLogin = new AppLabel();
    
    //LISTENERS
    private AppListener appListener = new AppListener();    
    
    //SINGLETON CLASS
    public static AppView instance = null;
    private AppView(){
        super();
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(1200, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        this.appPlusSign.addMouseListener(appListener);
        
        this.appLogin.addMouseListener(appListener);
    }
    
    public static AppView getInstance(){
        if(AppView.instance == null){
            instance = new AppView();
        }
        return instance;
    }
    
    //COMPONENTS GETTERS AND SETTERS
    public void setAppTitle(String text){
        this.appTitle.setText(text);
        this.appTitle.setHeadingOne();
    }
    public AppLabel getAppTitle(){
        return this.appTitle;
    }
    
    public void setAppFooter(String text){
        this.appFooter.setText(text);
        this.appFooter.setHeadingSix();
    }
    public AppLabel getAppFooter(){
        return this.appFooter;
    }
    
    public AppLabel getAppPlusSign(){
        this.appPlusSign.setPlusSign();
        return this.appPlusSign;
    }
    
    public void setAppNewTask(String text){
        this.appNewTask.setText(text);
        this.appNewTask.setBorder(BorderFactory.createEmptyBorder(0,30,0,0));
    }
    public AppLabel getAppNewTask(){
        return this.appNewTask;
    }
    
    public void setAppLogin(String text){
        this.appLogin.setText(text);
        this.appLogin.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
    }
    public AppLabel getAppLogin(){
        return this.appLogin;
    }
}
