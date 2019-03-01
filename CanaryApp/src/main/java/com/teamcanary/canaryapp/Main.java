package com.teamcanary.canaryapp;

import controller.GUIManager;
import controller.TaskSystem;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import model.SubTask;
import model.Task;
import model.User;
import com.google.gson.Gson;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import view.AppPanel;
import view.AppWindow;
import view.TasksContainerView;
import view.TodoPanel;
import view.TodoText;

public class Main {
    public static void main(String[] args){
        
        //------>>>>>>>> TO BE MOVED TO THE RIGHT CLASS
      //  String paulJsonUrl = "http://nooblab.com/p2.json";
     //   HttpClient client = HttpClientBuilder.create().build();
      //  HttpGet request = new HttpGet(paulJsonUrl);


        //------>>>>>>>> TO BE MOVED TO THE RIGHT CLASS
        //Gson gson = new Gson();
        
        
        //CREATING DEFAULT TESTING TASKS
//        User u1 = new User("Kylan","Haffie","Mazemace","Todocanary123");
//        Task t1 = TaskSystem.taskManager.newTask("Eat",u1);
//        Task t2 = TaskSystem.taskManager.newTask("Sleep",u1);
//        Task t3 = TaskSystem.taskManager.newTask("Code",u1);
//        Task t4 = TaskSystem.taskManager.newTask("Repeat",u1);
//        Task t5 = TaskSystem.taskManager.newTask("Mental Breakdown",u1);
//        SubTask s1 = TaskSystem.taskManager.newSubTask(t5,"Repeat Again",u1);
   

        GUIManager.createWindow();
        GUIManager.createTaskView();
    }
}
