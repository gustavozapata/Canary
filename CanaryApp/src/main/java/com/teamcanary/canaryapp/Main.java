package com.teamcanary.canaryapp;

import controller.TaskFilter;
import controller.TaskSort;
import java.util.ArrayList;
import model.Task;
import model.TaskContainer;
import model.User;
import view.AppView;

/**
 *
 * @author k1715308
 */
public class Main {
    public static void main(String[] args){
        
        AppView mainWindow = AppView.getInstance();
        
        
        //KYLAN, I COMMENTED THIS OUT SINCE I'M TRYING TO MATCH PAUL'S WEB SERVICE DATA WITH HIS
//        TaskContainer.getInstance().newTask("Medium Task", new User("Gustavo","","Gus123","")).setPriority("Medium");
//        TaskContainer.getInstance().newTask("High Task", new User("Kylan","","Ky123","")).setPriority("High");
//        TaskContainer.getInstance().newTask("Low Task", new User("Gustavo","","Gus123","")).setPriority("Low");
        
        
        
//        TaskSort.SortBy("Description");
     
    }
}