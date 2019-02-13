/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.TaskContainer;

/**
 *
 * @author Kylan
 */
public class TaskSystem {
    
    
    public static TaskContainer taskManager = new TaskContainer();
    
    public static TaskContainer getTaskContainer(){
        return taskManager;
    }
    
    public static void setTaskCOntainer(TaskContainer new_taskmanager){
        taskManager = new_taskmanager;
        
    }
    
}
