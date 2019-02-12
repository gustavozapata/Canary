package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Gustavo
 */
public class AppWindow extends JFrame {
    
    //SINGLETON CLASS - (ONLY ONE INSTANCE OF THE CLASS CAN BE CREATED)
    /*public static MainWindow instance = null;
    private MainWindow(){
        super();
    }
    public static MainWindow getInstance(){
        if(MainWindow.instance == null){
            instance = new MainWindow();
        }
        return instance;
    }*/
    
    public AppWindow() {
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(1200, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    // TODO: DOUBLE CHECK WITH PAUL
    //##### PANELS #####
    private AppPanel appTopPanel = new AppPanel();
    private AppPanel appBottomPanel = new AppPanel();
    private AppPanel appCentrePanel = new AppPanel();
    private AppPanel appLeftPanel = new AppPanel();
    private AppPanel appRightPanel = new AppPanel();
    
    //##### COMPONENTS #####
    private AppText appTitle = new AppText();
    private AppText appFooter = new AppText();
    private AppText appPlusSign = new AppText("+");
    private AppText appNewTask = new AppText();
    private AppText appLogin = new AppText();
    
    
    //COMPONENTS GETTERS AND SETTERS
    public void setAppTitle(String text){
        this.appTitle.setText(text);
        this.appTitle.setHeadingOne();
    }
    public AppText getAppTitle(){
        return this.appTitle;
    }
    
    public void setAppFooter(String text){
        this.appFooter.setText(text);
        this.appFooter.setHeadingSix();
    }
    public AppText getAppFooter(){
        return this.appFooter;
    }
    
    public AppText getAppPlusSign(){
        this.appPlusSign.setPlusSign();
        return this.appPlusSign;
    }
    
    public void setAppNewTask(String text){
        this.appNewTask.setText(text);
    }
    public AppText getAppNewTask(){
        return this.appNewTask;
    }
    
    public void setAppLogin(String text){
        this.appLogin.setText(text);
    }
    public AppText getAppLogin(){
        return this.appLogin;
    }
}
