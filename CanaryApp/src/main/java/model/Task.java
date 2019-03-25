package model;

import java.util.ArrayList;
import java.util.Date;

public class Task implements Comparable<Task>{
    public static int taskCounter = 0;
    private String description;
    private User user;
    private Date completionDate; 
    private String priority;
    private String category;
    private ArrayList<SubTask> subtasks;
    private boolean isComplete;
    
    public Task(String taskDescription, User user){
        taskCounter++;
        this.description = taskDescription;
        this.user = user;
    }

    public Task() {
        //TESTING PROPERTIES
//        this.category = "University";
//        this.priority = "Medium";
//        this.assignee = "Test";
//        this.date = new Date();
//        this.description = "amar";
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

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    
    public int getPriorityID(){
        if (this.getPriority() == "Low"){
            return 1;
        }
        else if (this.getPriority() == "Medium"){
            return 2;
        }
        else if (this.getPriority() == "High"){
            return 3;
        }
        return 1;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int compareTo(Task o) {
       return this.getPriorityID()-o.getPriorityID();
    }

    
 
    
}


