package controller;
import model.SubTaskContainer;
import model.SubTask;

public class SubTaskOperator {
    
public static void checkAll(SubTaskContainer container){
    for(SubTask subtask: container.getSubTask()){
        System.out.println(subtask.getTaskDescription()); // DEBUG
        
    }
    
    
}
    
    
    
    
    
    
}
