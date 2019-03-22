/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Task;
import model.TaskContainer;

public class TaskFilter {
    
public static void FilterBy(String  filterBy, String  filter){
    
    TaskContainer container = TaskContainer.getInstance();
    
    ArrayList<Task> filteredTasks = container.getAll();
    
    ArrayList<Task> taskToRemove = new ArrayList<Task>();
 
        if (filterBy.equals("Description")){       
            for (Task task : filteredTasks) 
            { 
                if(!task.getTaskDescription().equals(filter)){
                    taskToRemove.add(task);
                }
             }
        }  
        else if(filterBy.equals("Username")){
              for (Task task : filteredTasks) 
            { 
                if(!task.getAssignedTo().getUserName().equals(filter)){
                    taskToRemove.add(task);
                }
             }          
        }
                 
    for (Task task : taskToRemove) 
    { 
       filteredTasks.remove(task);    
    }
    
    container.clear();
    container.addItems(filteredTasks);
}



}

