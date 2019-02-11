package model;

import java.util.ArrayList;

public class SubTaskContainer {
    /* A subtask container contains subtasks.
    A subtask container can be attached to any class to enable it to hold subtasks
    */
    private ArrayList<SubTask> subtask = new ArrayList<SubTask>();
    
    public ArrayList<SubTask> getSubTask(){ 
        return this.subtask;
    }
   
    public void AddSubTask(SubTask subtask){
        this.subtask.add(subtask);
    }
    
    
    
    
    
    
    
    
}
