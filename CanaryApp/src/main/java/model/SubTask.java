package model;

import java.util.Date;


public class SubTask {
    
    private String description;
    private Integer priorityOrder;
    private Date completionDate;
    private Task task;
    
    public SubTask(){
        
    }
    
    //TESTING METHOD
    public Task getTask(){
        return this.task;
    }
    public void setTask(Task task){
        this.task = task;
    }
    //TESTING
    
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getPriorityOrder() {
        return priorityOrder;
    }

    public void setPriorityOrder(Integer priorityOrder) {
        this.priorityOrder = priorityOrder;
    }
    
    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }
}
