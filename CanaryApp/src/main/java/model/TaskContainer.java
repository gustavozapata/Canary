package model;

import java.util.ArrayList;

public class TaskContainer {
    
    private ArrayList<Task> task = new ArrayList<Task>();
    
    public ArrayList<Task> getAll(){ 
        return this.task;
    }

    public void addItem(Task task){
        this.task.add(task);
    }

    public void addItems(ArrayList<SubTask> task){
        this.task.addAll(task);     
    }
    
    public Task newTask(String Description){
        Task task = new Task(this,Description);
        this.addItem(task);
        return task; 
    }
    public SubTask newSubTask(Task task, String Description){
        SubTask subtask = new SubTask(this,Description);
        task.getSubTaskContainer().addItem(subtask);
        return subtask;
    }
}
