/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.SubTask;
import model.Task;
import model.TaskContainer;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import static org.apache.http.protocol.HTTP.USER_AGENT;
import view.AppView;
import view.LoginView;
import view.NewSubTaskView;
import view.NewTaskView;
import view.SubTaskView;

/**
 *
 * @author Gustavo
 */
public class AppListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

        //CREATE TASK BUTTON
        if (e.getComponent().getName().equals("plus_btn")) {

            System.out.println("new task button");

            AppView.getInstance().resetFilter();
            AppView.getInstance().resetSort();
            NewTaskView.getInstance().setUserDropDown();
            NewTaskView.getInstance().setVisible(true);
            NewTaskView.getInstance().emptyFields();
            NewTaskView.getInstance().setNewTaskTitle("New Task");
            NewTaskView.getInstance().getNewTaskWarning().setVisible(false);
            NewTaskView.getInstance().setCreateTaskButton("Create");

            //LOGIN BUTTON
        } else if (e.getComponent().getName().equals("login_btn")) {
            System.out.println("login button");
            LoginView.getInstance().setVisible(true);
            LoginView.getInstance().setLocationRelativeTo(AppView.getInstance());
            LoginView.getInstance().setUsernameField("");
            LoginView.getInstance().setPasswordField("");

            //FETCH BUTTON
        } else if (e.getComponent().getName().equals("fetch_btn")) {
            System.out.println("fetch button");

            AppView.getInstance().resetFilter();
            AppView.getInstance().resetSort();

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
                    UserSystem.loadUser(result.getUser().getUserName(), result.getUser().getUserLevel());
                    if (result.getSubTasks().size() > 0) {
                        for (SubTask subtask : result.getSubTasks()) {
                            subtask.setTask(result);
                        }
                    }
                    TaskContainer.getInstance().addItem(result);
                }
                System.out.println("taskContainer.size(): " + TaskContainer.getInstance().getAll().size());
                //renders all the tasks in the taskContainer
                AppView.getInstance().renderNewTask();
            } catch (IOException ex) {
                Logger.getLogger(AppListener.class.getName()).log(Level.SEVERE, null, ex);
            }

            //LOAD BUTTON
        } else if (e.getComponent().getName().equals("load_btn")) {
            System.out.println("load button");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Load File");
            int selection = fileChooser.showOpenDialog(null);
            if (selection == JFileChooser.APPROVE_OPTION) {
                try {
                    File saveFile = fileChooser.getSelectedFile();
                    String inboundJson = FileUtils.readFileToString(saveFile);
                    Task[] tasks = JsonManager.read(saveFile.toString());
                    System.out.println(tasks);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Failed to load");
                }
            }

            //SAVE BUTTON
        } else if (e.getComponent().getName().equals("save_btn")) {
            System.out.println("save button");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save current game");
            int selection = fileChooser.showSaveDialog(null);
            if (selection == JFileChooser.APPROVE_OPTION) {
                File saveFile = fileChooser.getSelectedFile();
                try {
                    JsonManager.write(saveFile.toString(), TaskContainer.getInstance().getAll());
//                try {
//                    FileUtils.writeStringToFile(saveFile, Task.getJson());
//                } catch (IOException ex) {
//                    JOptionPane.showMessageDialog(null, "Failed to save");
//                }
                } catch (IOException ex) {
                    Logger.getLogger(AppListener.class.getName()).log(Level.SEVERE, null, ex);
                }
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
