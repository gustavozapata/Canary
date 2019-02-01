package project.Model;

import java.util.ArrayList;

public class Task {

    private String title;
    //DateTime date;
    private SubTaskContainer subtask_container;
    private int priority;
    private boolean complete;
    
    
    public Task(){
        this.setComplete((false));
        this.setTitle("");
        this.setPriority(0);
        this.subtask_container = new SubTaskContainer();
    }
    
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public void setPriority(int priority){
        this.priority = priority;
    }
    
    public void setComplete(boolean complete){
        this.complete = complete;
    }
    
}