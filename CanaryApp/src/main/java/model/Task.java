package model;

import java.util.ArrayList;
import java.util.Date;

public class Task {
    public static int taskCounter = 0;
    private String description;
    private User user;
    private Date completionDate; 
    private Integer priorityOrder;
    private String category = "";
    private ArrayList<SubTask> subtasks = new ArrayList();
    private boolean isComplete;

    public Task() {
        taskCounter++;
        System.out.println("taskCounter: " + taskCounter);
    }
    

        
    public boolean isComplete() {
        return this.isComplete;
    }
    
    public void setComplete(boolean isComplete){
        this.isComplete = isComplete;
    }
    
    public void toggleComplete(){
        this.isComplete = !this.isComplete;
    }
    
    public ArrayList<SubTask> getSubTasks(){
        return this.subtasks;
    }
    
    public void addSubTask(SubTask subtask){
        this.subtasks.add(subtask);
    }
    
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCompletionDate() {
        return this.completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public int getPriorityOrder() {
        return priorityOrder;
    }

    public void setPriorityOrder(Integer priorityOrder) {
        this.priorityOrder = priorityOrder;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    //@KYLAN, I COMMENTED THIS OUT SINCE I CHANGED THE PRIORITY SIGNATURE TO NUMBERS
//    @Override
//    public int compareTo(Task o) {
//       return this.getPriorityID()-o.getPriorityID();
//    }
}


