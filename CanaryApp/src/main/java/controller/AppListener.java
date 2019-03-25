package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import view.AppView;
import view.NewTaskView;
import view.LoginView;

public class AppListener implements MouseListener {

    private NewTaskView newTaskView = NewTaskView.getInstance();
    private LoginView loginView = LoginView.getInstance();

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
        if(e.getComponent().getName().equals("fetch_btn")){
            System.out.println("Fetching...");
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
