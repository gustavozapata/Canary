package project.Model;

import java.util.ArrayList;

public class SubTaskContainer {
    
        private ArrayList<SubTask> subtask;
    
    public SubTaskContainer(){
  
    }
                
    public void addSubTask(SubTask subtask){
           this.subtask.add(subtask);
    }
    
    public void clearTask(){
        this.subtask.clear();   
    }
   
    public ArrayList<SubTask> getAllSubTask(){
        return this.subtask;
    }
    
    public SubTask getSubTask(int subtask_id){      
        return this.subtask.get(subtask_id);
    }
}
