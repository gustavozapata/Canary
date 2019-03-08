package model;

import java.util.ArrayList;


public class TaskContainer {
    
    private ArrayList<Task> tasks = new ArrayList<Task>();
    private static TaskContainer instance;
    private TaskContainer(){
        
        
    }
    public static TaskContainer getInstance(){
        if(TaskContainer.instance == null){
             instance = new TaskContainer();
        }
        return instance;
    }
    
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
        Task task = new Task(Description,user);
        this.addItem(task);
        return task; 
    }
}
