package model;

import java.util.ArrayList;
import static model.Task.taskCounter;


public class TaskContainer {
    
    private ArrayList<Task> tasks = new ArrayList<>();
    private static TaskContainer instance;
    
    
    //SINGLETON
    private TaskContainer(){
    }
    
    public static TaskContainer getInstance(){
        if(TaskContainer.instance == null){
             instance = new TaskContainer();
        }
        return instance;
    }
    
    public static void setInstance(TaskContainer container){
        instance = container;
    }
    
    public ArrayList<Task> getAll(){ 
        return this.tasks;
    }

    public void addItem(Task task){
        this.tasks.add(task);
    }

    public void addItems(ArrayList<Task> task){
        this.tasks.addAll(task);    

    }
    
    public void removeTask(Task task){
        tasks.remove(task);
    }
    
    public void clear(){
        this.tasks = new ArrayList<>();
    }
    
    public void printAll(){
        System.out.println("THERE ARE: " +  this.tasks.size());
        for (Task task : this.tasks) {
            System.out.println(task.getDescription());
        }             
    }
}
