package model;

import java.util.ArrayList;
import java.util.Date;

public class Task {
    public static int taskCounter = 0;
    private String taskDescription;
    private User owner;
    private User assignedTo;
    private String assignee; //DELETE ONCE TESTING IS DONE
    private Date date;  //or private String date;
    private String priority;
    private String category;
    private ArrayList<SubTask> subtasks;
    
    private boolean complete;
    
    public Task(String taskDescription, User user){
        taskCounter++;
        this.taskDescription = taskDescription;
        this.setAssignedTo(user);
    }

    public Task() {
        //TESTING PROPERTIES
//        this.category = "University";
//        this.priority = "Medium";
//        this.assignee = "Test";
//        this.date = new Date();
//        this.taskDescription = "amar";
    }
    
    public boolean getComplete() {
        return this.complete;
    }
    
    public void setComplete(boolean isComplete){
        this.complete = isComplete;
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

    public String getTaskDescription() {
        return this.taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public User getOwner() {
        return this.owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getAssignedTo() {
        return this.assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public void setAssignedToString(String assignee){
        this.assignee = assignee;
    }
    public String getAssignedToString(){
        return this.assignee;
    }
    
    
}
