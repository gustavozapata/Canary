package view;

import com.google.gson.Gson;
import controller.AppListener;
import controller.TaskFilter;
import controller.TaskSort;
import controller.UserSystem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import model.SubTask;
import model.Task;
import model.TaskContainer;
import model.User;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Gustavo
 */
public final class AppView extends JFrame {

    int highest_priority = 5;

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
    private JLabel toolbarList = new JLabel();
    private JComboBox<String> filterComboBox;
    private JComboBox<String> listComboBox;
    private JComboBox<String> sortComboBox;

    //STYLES
    private AppStyle appStyle = new AppStyle();

    //LISTENERS
    private AppListener appListener = new AppListener();

    //MODEL
    private AppModel taskSettings = new AppModel();

    //SINGLETON
    public static AppView instance = null;
    private TaskContainer taskContainer = TaskContainer.getInstance();

    private AppView() {
        super();
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(1200, 700);
        this.setTitle("TODO CANARY");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setComponents();
        setPanels();
        addComponents();

        loadUsers();

        appIconPlus.addMouseListener(appListener);
        appLogin.addMouseListener(appListener);
        saveIcon.addMouseListener(appListener);
        loadIcon.addMouseListener(appListener);
        fetchIcon.addMouseListener(appListener);

        this.setVisible(true);
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
        setAppFooter("Developed by Canary");
        setAppIconPlus("+");
        setAppNewTask("New Task");
        setAppLogin("Login");
        setAppSave("Save");
        setAppLoad("Load");
        setAppFetch("Fetch");
        setAppNoTasksMsg("");

        setToolbarLabels();
        setToolbarComboBox();
        setListComboBox();

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
        toolbarList.setText("Lists");
        appStyle.styleToolbarItem(toolbarFilter);
        appStyle.styleToolbarItem(toolbarSort);
        appStyle.styleToolbarItem(toolbarList);
    }

    public void resetFilter() {
        filterComboBox.setSelectedIndex(0);
        filter();
    }

    public void resetSort() {
        sortComboBox.setSelectedIndex(0);
        filter();
    }

    public void filter() {
        String item = filterComboBox.getSelectedItem().toString();
        if (item.contains("Priority: ")) {
            item = item.substring(10);
            TaskFilter.filterBy("Priority", item);
        } else {
            TaskFilter.filterBy("Catagory", item);
        }
    }

    public void filterUsers(String username) {
        TaskFilter.filterByUsername(username);

    }

    public void sort() {
        String item = sortComboBox.getSelectedItem().toString();
        TaskSort.sortBy(item);
    }

    public void setToolbarComboBox() {
        // FOR FILTERING

        filterComboBox = new JComboBox();
        filterComboBox.addItem("All");
        for (String catagory : taskSettings.getCategories()) {
            filterComboBox.addItem(catagory);
        }

        filterComboBox.addItem("Web Service");

        for (int counter = 0; counter <= highest_priority; counter++) {
            filterComboBox.addItem("Priority: " + Integer.toString(counter));
        }

        appStyle.styleComboBox(filterComboBox);

        filterComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (filterComboBox.getSelectedItem().toString() != "None") {

                    filter();
                    if (sortComboBox.getSelectedItem().toString() != "None") {
                        sort();
                    }
                }

            }
        });

        // FOR SORTING
        sortComboBox = new JComboBox();
        appStyle.styleComboBox(sortComboBox);
        sortComboBox.addItem("None");
        sortComboBox.addItem("Priority");
        sortComboBox.addItem("Description");
        sortComboBox.addItem("Date");
        sortComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sortComboBox.getSelectedItem().toString() != "None") {
                    sort();
                    if (filterComboBox.getSelectedItem().toString() != "All") {
                        filter();
                    }
                }

            }
        });

    }

    public void setListComboBox() {
        listComboBox = new JComboBox();
        appStyle.styleComboBox(listComboBox);
        listComboBoxAction();
    }

    public void listComboBoxAction() {
        listComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (listComboBox.getSelectedItem().equals("All")) {
//                    loadAllTasks();
                }
            }
        });
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
    public void addComponents() {

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

        this.add(appTopPanel, BorderLayout.NORTH);
        this.add(appCentrePanel, BorderLayout.CENTER);
        this.add(appBottomPanel, BorderLayout.SOUTH);
    }

    public void reRender() {
        System.out.println("ReRendering EVerything");
        containerTasks.removeAll();
        containerTasks.revalidate();
        containerTasks.repaint();
        renderNewTask();

    }

    //METHOD THAT RENDERS ALL THE TASKS IN THE TASKCONTAINER
    public void renderNewTask() {
        containerTasks.removeAll();
        for (Task task : TaskContainer.getInstance().getAll()) {
            containerTasks.add(new TaskView(task));
            if (task.getSubTasks().size() > 0) {
                for (SubTask subtask : task.getSubTasks()) {
                    containerTasks.add(new SubTaskView(subtask));
                }
            }
            if (TaskContainer.getInstance().getAll().size() <= 0) {
                appNoTasksMsg.setVisible(true);
            } else {
                appNoTasksMsg.setVisible(false);
            }
        }
        taskPanel.add(containerTasks);
        taskPanel.revalidate();
    }

    public void showList() {
        toolbarPanel.add(toolbarList);
        toolbarPanel.add(listComboBox);
        toolbarPanel.revalidate();
    }

    private void loadUsers() {
//        listComboBox.addItem("All");
        File userFile = new File("src/main/java/model/users_json");
        try {
            String userJson = FileUtils.readFileToString(userFile);
            Gson gson = new Gson();
            User[] users = gson.fromJson(userJson, User[].class);
            for (User user : users) {
                listComboBox.addItem(user.getUserName());
            }
        } catch (IOException e) {
        }

    }

    public void hideList() {
        toolbarPanel.remove(toolbarList);
        toolbarPanel.remove(listComboBox);
        toolbarPanel.repaint();
    }

    public void autoLoadTasks(User user) {
        File userFile = new File("src/main/java/model/users_tasks");
        try {
            String taskJson = FileUtils.readFileToString(userFile);
            Gson gson = new Gson();
            Task[] tasks = gson.fromJson(taskJson, Task[].class);
            for (Task task : tasks) {
                if (task.getUser().getUserName().equals(user.getUserName())) {
                    TaskContainer.getInstance().addItem(task);
                    UserSystem.loadUser(task.getUser().getUserName(), task.getUser().getUserLevel());
                }
            }
            
        } catch (IOException e) {
        }
        containerTasks.removeAll();
        renderNewTask();
    }

    public void loadAllTasks() {
        containerTasks.removeAll();
        File userFile = new File("src/main/java/model/users_tasks");
        try {
            String taskJson = FileUtils.readFileToString(userFile);
            Gson gson = new Gson();
            Task[] tasks = gson.fromJson(taskJson, Task[].class);
            for (Task task : tasks) {
                TaskContainer.getInstance().addItem(task);
                UserSystem.loadUser(task.getUser().getUserName(), task.getUser().getUserLevel());
            }
            renderNewTask();
        } catch (IOException e) {
        }
    }
}
