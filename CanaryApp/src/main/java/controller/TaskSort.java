/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import model.Task;
import model.TaskContainer;

public class TaskSort {
    
    public static void SortBy(String sortBy){
    
        TaskContainer container = TaskContainer.getInstance();
        ArrayList <Task> tasks = container.getAll();

        
        if(sortBy == "Description"){
            System.out.println("Sort"); 
            Collections.sort(tasks);
            
            
            
            
            container.clear();
            container.addItems(tasks);
            container.printAll();
   
        }
       
    }
    
    
  
    
   
}
