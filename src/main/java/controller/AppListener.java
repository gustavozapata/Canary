package controller;

import com.google.gson.Gson;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import static org.apache.http.protocol.HTTP.USER_AGENT;
import view.AppView;
import view.NewTaskView;
import view.LoginView;
import model.Task;
import model.TaskContainer;

public class AppListener implements MouseListener {

    private NewTaskView newTaskView = NewTaskView.getInstance();
    private LoginView loginView = LoginView.getInstance();
    private AppView appView;
    private TaskContainer taskContainer = TaskContainer.getInstance();

    @Override
    public void mouseClicked(MouseEvent e) {
        
        //NEW TASK BUTTON
        if (e.getComponent().getName().equals("plus_btn")) {
            newTaskView.emptyFields();
            newTaskView.setVisible(true);
            newTaskView.setNewTaskTitle("New Task");
            newTaskView.setCreateTaskButton("Create");
            newTaskView.setLocationRelativeTo(AppView.getInstance());
        }

        //LOGIN BUTTON 
        if (e.getComponent().getName().equals("login_btn")) {
            loginView.setVisible(true);
            loginView.setLocationRelativeTo(AppView.getInstance());
            loginView.setUsernameField("");
            loginView.setPasswordField("");
        }

        //SAVE BUTTON
        if (e.getComponent().getName().equals("save_btn")) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save current game");
            int selection = fileChooser.showSaveDialog(null);
            if (selection == JFileChooser.APPROVE_OPTION) {
                File saveFile = fileChooser.getSelectedFile();
//                try {
//                    FileUtils.writeStringToFile(saveFile, Task.getJson());
//                } catch (IOException ex) {
//                    JOptionPane.showMessageDialog(null, "Failed to save");
//                }
            }
        }

        //LOAD BUTTON
        if (e.getComponent().getName().equals("load_btn")) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Load previous game");
            int selection = fileChooser.showOpenDialog(null);
            if (selection == JFileChooser.APPROVE_OPTION) {
                try {
                    File saveFile = fileChooser.getSelectedFile();
                    String inboundJson = FileUtils.readFileToString(saveFile);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Failed to load");
                }
            }
        }

        //FETCH BUTTON
        if (e.getComponent().getName().equals("fetch_btn")) {
            appView = AppView.getInstance();
            try {
                String url = "http://www.nooblab.com/p2.json";
                
                HttpClient client = HttpClientBuilder.create().build();
                HttpGet httpGet = new HttpGet(url);
                httpGet.addHeader("User-Agent", USER_AGENT);
                HttpResponse response = client.execute(httpGet);
                
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));
                
                Gson gson = new Gson();
                Task[] results = gson.fromJson(reader, Task[].class);
                for (Task result : results) {
                    result.setCategory("Web Service");
                    taskContainer.addItem(result);
                }
                appView.renderNewTask();
                System.out.println("taskContainer.length: " + taskContainer.getAll().size());
                
            } catch (IOException ex) {
                Logger.getLogger(AppListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
