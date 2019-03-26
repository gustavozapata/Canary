package view;

import controller.AppListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import javax.swing.WindowConstants;
import model.AppModel;
import model.Task;
import model.TaskContainer;

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

    //PANELS #3
    private AppPanel savePanel = new AppPanel();
    private AppPanel fetchPanel = new AppPanel();
    private AppPanel loadPanel = new AppPanel();

    //COMPONENTS
    private JLabel appTitle = new JLabel();
    private JLabel appFooter = new JLabel();
    private JLabel appIconPlus = new JLabel();
    private JLabel appNewTask = new JLabel();
    private JLabel appLogin = new JLabel();
    private JLabel appSave = new JLabel();
    private JLabel appLoad = new JLabel();
    private JLabel appFetch = new JLabel();
    private JLabel appNoTasksMsg = new JLabel();
    private JLabel saveIcon;
    private JLabel loadIcon;
    private JLabel fetchIcon;

    private JLabel toolbarFilter = new JLabel();
    private JLabel toolbarSort = new JLabel();
    private JComboBox<String> filterComboBox;
    private JComboBox<String> sortComboBox;

    //STYLES
    private AppStyle appStyle = new AppStyle();

    //LISTENERS
    private AppListener appListener = new AppListener();

    //MODEL
    private AppModel taskSettings = new AppModel();
    private TaskContainer taskContainer = TaskContainer.getInstance();

    //SINGLETON
    public static AppView instance = null;

    private AppView() {
        super();
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(1200, 700);
        this.setTitle("TODO CANARY");
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setComponents();
        setPanels();
        addComponents(this);

        appIconPlus.addMouseListener(appListener);
        appLogin.addMouseListener(appListener);
        saveIcon.addMouseListener(appListener);
        loadIcon.addMouseListener(appListener);
        fetchIcon.addMouseListener(appListener);

    }

    //SINGLETON METHOD
    public static AppView getInstance() {
        if (AppView.instance == null) {
            instance = new AppView();
        }
        return instance;
    }

    public void setComponents() {
        setAppTitle("To-Do Canary");
        setAppFooter("Contact Canary");
        setAppIconPlus("+");
        setAppNewTask("New Task");
        setAppLogin("Login");
        setAppSave("Save");
        setAppLoad("Load");
        setAppFetch("Fetch");
        setAppNoTasksMsg("");

        setToolbarLabels();
        setToolbarComboBox();

        initializeImages();
    }

    public void setPanels() {
        appTopPanel.setLayout(new BorderLayout());
        appCentrePanel.setLayout(new BorderLayout());
        todoPanel.setLayout(new BorderLayout());
        newTaskPanel.setLayout(new BoxLayout(newTaskPanel, BoxLayout.Y_AXIS));

        containerTasksScroll.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        containerTasksScroll.getVerticalScrollBar().setUnitIncrement(16);
        BoxLayout boxLayout = new BoxLayout(containerTasks, BoxLayout.Y_AXIS);
        containerTasks.setLayout(boxLayout);

        appSettingsPanel.setPreferredSize(new Dimension(350, 100));
        appSettingsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 35, 10));

        savePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 7));
        loadPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 7));
        fetchPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 7));

        appStyle.setActionPanel(savePanel);
        appStyle.setActionPanel(loadPanel);
        appStyle.setActionPanel(fetchPanel);

        appStyle.setTaskWindow(todoPanel);
        appStyle.setToolBar(toolbarPanel);
    }

    //COMPONENTS SETTERS
    public void setAppTitle(String text) {
        appTitle.setText(text);
        appStyle.setLabelOne(appTitle);
    }

    public void setAppFooter(String text) {
        appFooter.setText(text);
        appStyle.setLabelThree(appFooter);
    }

    public void setAppIconPlus(String text) {
        appIconPlus.setText(text);
        appIconPlus.setName("plus_btn");
        appStyle.setIconPlus(appIconPlus);
    }

    public void setAppNewTask(String text) {
        appNewTask.setText(text);
        appStyle.setLabelFour(appNewTask);
    }

    public void setAppLogin(String text) {
        appLogin.setText(text);
        appLogin.setName("login_btn");
        appStyle.setLabelFive(appLogin);
        appLogin.setBorder(BorderFactory.createEmptyBorder(15, 35, 0, 0));
    }

    public void setAppSave(String text) {
        appSave.setText(text);
        appStyle.styleAppSettings(appSave);
        appSave.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
    }

    public void setAppLoad(String text) {
        appLoad.setText(text);
        appStyle.styleAppSettings(appLoad);
        appLoad.setBorder(BorderFactory.createEmptyBorder(6, 0, 0, 0));
    }

    public void setAppFetch(String text) {
        appFetch.setText(text);
        appStyle.styleAppSettings(appFetch);
        appFetch.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
    }

    public void setAppNoTasksMsg(String text) {
        appNoTasksMsg.setText(text);
        appStyle.setTaskInfo(appNoTasksMsg);
    }

    public void setToolbarLabels() {
        toolbarFilter.setText("Filter");
        toolbarSort.setText("Sort");
        appStyle.styleToolbarItem(toolbarFilter);
        appStyle.styleToolbarItem(toolbarSort);
    }

    public void setToolbarComboBox() {
        filterComboBox = new JComboBox(taskSettings.getCategories());
        sortComboBox = new JComboBox(taskSettings.getPriorities());
        appStyle.styleComboBox(filterComboBox);
        appStyle.styleComboBox(sortComboBox);
    }

    public void initializeImages() {
        try {
            BufferedImage saveImg = ImageIO.read(new File("src/images/save.png"));
            BufferedImage loadImg = ImageIO.read(new File("src/images/load.png"));
            BufferedImage fetchImg = ImageIO.read(new File("src/images/fetch.png"));
            saveIcon = new JLabel(new ImageIcon(saveImg));
            loadIcon = new JLabel(new ImageIcon(loadImg));
            fetchIcon = new JLabel(new ImageIcon(fetchImg));

            setImages();
        } catch (IOException e) {
        }
    }

    public void setImages() {
        saveIcon.setName("save_btn");
        loadIcon.setName("load_btn");
        fetchIcon.setName("fetch_btn");

        saveIcon.setToolTipText("Save Todo List");
        loadIcon.setToolTipText("Load Todo List");
        fetchIcon.setToolTipText("Fetch Todo List");

        saveIcon.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 0));
        loadIcon.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 0));
        fetchIcon.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));

        saveIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loadIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        fetchIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    //COMPONENTS ADDING
    public void addComponents(AppView appView) {
        savePanel.add(saveIcon);
        savePanel.add(appSave);
        loadPanel.add(loadIcon);
        loadPanel.add(appLoad);
        fetchPanel.add(fetchIcon);
        fetchPanel.add(appFetch);

        toolbarPanel.add(toolbarFilter);
        toolbarPanel.add(filterComboBox);
        toolbarPanel.add(toolbarSort);
        toolbarPanel.add(sortComboBox);

        taskPanel.add(appNoTasksMsg);
        todoPanel.add(toolbarPanel, BorderLayout.NORTH);
        todoPanel.add(containerTasksScroll, BorderLayout.CENTER);
        newTaskPanel.add(appIconPlus);
        newTaskPanel.add(appNewTask);

        appSettingsPanel.add(savePanel);
        appSettingsPanel.add(loadPanel);
        appSettingsPanel.add(fetchPanel);
        appSettingsPanel.add(appLogin);

        appTopPanel.add(appTitle, BorderLayout.CENTER);
        appTopPanel.add(newTaskPanel, BorderLayout.WEST);
        appTopPanel.add(appSettingsPanel, BorderLayout.EAST);
        appCentrePanel.add(todoPanel, BorderLayout.CENTER);
        appBottomPanel.add(appFooter);

        appView.add(appTopPanel, BorderLayout.NORTH);
        appView.add(appCentrePanel, BorderLayout.CENTER);
        appView.add(appBottomPanel, BorderLayout.SOUTH);
    }

    public void renderNewTask(TaskView taskView) {
//        taskPanel.remove(appNoTasksMsg);
//        containerTasks.add(taskView);
//        taskPanel.add(containerTasks);
        testingRendering();
//        taskPanel.revalidate();
//        taskPanel.repaint();
    }
    
    //TESTING METHOD
    public void testingRendering() {
        taskPanel.remove(appNoTasksMsg);
        
        for (Task task : taskContainer.getAll()){
            containerTasks.add(new TaskView(task));
        }
        
        taskPanel.add(containerTasks);
        taskPanel.revalidate();
        taskPanel.repaint();
    }
}
