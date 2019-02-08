/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Gustavo
 */
public class Task {
    private String taskDescription;
    private User owner;
    private User assignedTo;
    private Date date;  //or private String date;
    private String priority;
    private String category;
    private SubTaskContainer subTaskContainer;
    private boolean complete;

    public boolean getComplete() {
        return this.complete;
    }
    
    public void toggleComplete(){
        this.complete = !this.complete;
    }
    
    public void markComplete(){    
        this.complete = true;
    }

    
    
    
    public SubTaskContainer getSubTaskContainer() {
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
