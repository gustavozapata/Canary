package model;

import java.util.ArrayList;
import java.util.Date;

public class Task {
    private String taskDescription;
    private User owner;
    private User assignedTo;
    private Date date;  //or private String date;
    private String priority;
    private String category;
    private ArrayList<SubTask> subtasks;
    
    private boolean complete;
    
    public Task(String taskDescription, User user){
        
        this.taskDescription = taskDescription;
        this.setAssignedTo(user);
    }

    Task(TaskContainer aThis, String Description, User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean getComplete() {
        return this.complete;
    }
    
    public void toggleComplete(){
        this.complete = !this.complete;
    }
    
    public ArrayList<SubTask> getSubTasks(){
        return this.subtasks;
    }
    
    public void addSubTask(SubTask subtask){
        this.subtasks.add(subtask);
    }
    
    public void markComplete(){    
        this.complete = true;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
}
