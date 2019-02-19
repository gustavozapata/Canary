package model;

import java.util.ArrayList;
import model.SubTask;
import model.SubTask;
import model.Task;
import model.Task;
import model.User;

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
    
    public Task newTask(String Description, User user){
        Task task = new Task(this,Description,user);
        this.addItem(task);
        return task; 
    }
    public SubTask newSubTask(Task task, String Description, User user){
        SubTask subtask = new SubTask(this,Description, user);
        task.getSubTaskContainer().addItem(subtask);
        return subtask;
    }
}
