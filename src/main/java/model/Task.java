package model;

import java.util.Date;

public class Task {
    private String taskDescription;
    private User owner;
    private User assignedTo;
    private Date date;  //or private String date;
    private String priority;
    private String category;
    private SubTaskContainer subTaskContainer;
    private TaskContainer taskContainer;
    
    private boolean complete;
    private TaskDebugger debugger;
    
    public Task(TaskContainer taskContainer, String taskDescription, User user){
        this.setSubTaskContainer(new SubTaskContainer());
        this.setTaskContainer(taskContainer);
        this.taskDescription = taskDescription;
        this.setAssignedTo(user);
        this.setDebugger(new TaskDebugger());
    }
    public void setTaskContainer(TaskContainer taskContainer){
        this.taskContainer = taskContainer;
    }
    
    public TaskContainer getTaskContainer(){
        return this.taskContainer;
    }
    
    public TaskDebugger getDebugger(){   
        return this.debugger;
    }
    
    public void setDebugger(TaskDebugger debugger){
        this.debugger = debugger;
        this.debugger.setTask(this);
    }
    public boolean getComplete() {
        return this.complete;
    }
    
    public void toggleComplete(){
        this.complete = !this.complete;
    }
    
    public void markComplete(){    
        this.complete = true;
    }public SubTaskContainer getSubTaskContainer() {
        return this.subTaskContainer;
    }

    public void setSubTaskContainer(SubTaskContainer container) {
        this.subTaskContainer = container;
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
