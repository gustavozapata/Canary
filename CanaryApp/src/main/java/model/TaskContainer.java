package model;

import java.util.ArrayList;


public class TaskContainer {
    
    private ArrayList<Task> tasks = new ArrayList<Task>();
    
    public ArrayList<Task> getAll(){ 
        return this.tasks;
    }

    public void addItem(Task task){
        this.tasks.add(task);
    }

    public void addItems(ArrayList<SubTask> task){
        this.tasks.addAll(task);     
    }
    
    
    public Task newTask(String Description, User user){
        System.out.println("New Task!");
        Task task = new Task(this,Description,user);
        this.addItem(task);
        return task; 
    }
}
