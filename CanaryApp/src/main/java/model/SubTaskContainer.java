package model;

import java.util.ArrayList;
import model.SubTask;

public class SubTaskContainer{
    /* A subtask container contains subtasks.
    A subtask container can be attached to any class to enable it to hold subtasks
    */
    private ArrayList<SubTask> subtask = new ArrayList<SubTask>();
    
  
  
    public ArrayList<SubTask> getAll(){ 
        return this.subtask;
    }
    
   
    public void addItem(SubTask subtask){
        this.subtask.add(subtask);
    }
    
    public void addItems(ArrayList<SubTask> subtask){
        this.subtask.addAll(subtask);     
    }
    
    
    
    
    
    
    
    
}
