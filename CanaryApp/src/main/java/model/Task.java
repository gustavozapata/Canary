package model;

import controller.TaskSort;
import static java.lang.Integer.min;
import java.util.ArrayList;
import java.util.Date;

public class Task implements Comparable<Task>{
    public static int taskCounter = 0;
    private String description;
    private User user;
    private Date completionDate; 
    private Integer priorityOrder;
    private String category = "";
    private ArrayList<SubTask> subtasks = new ArrayList();
    private boolean isComplete;

    public Task() {
        taskCounter++;
        System.out.println("taskCounter: " + taskCounter);
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
    
    public void deleteSubtask(SubTask subtask){
        this.subtasks.remove(subtask);
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

    public int getPriorityOrder() {
        return priorityOrder;
    }

    public void setPriorityOrder(Integer priorityOrder) {
        this.priorityOrder = priorityOrder;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public int compareTo(Task o) {
        if(TaskSort.sortTaskBy == "Priority"){
       return  o.getPriorityOrder()-this.getPriorityOrder();
        }
        else if(TaskSort.sortTaskBy == "Description"){
            int result = this.description.charAt(0) - o.description.charAt(0);
            for (int i = 0; i < min(this.description.length(),o.description.length()); i++) {
              result = this.description.charAt(i) - o.description.charAt(i);
              if(result!=0){
                  break;
              }
             }
            return result;   
        }
        else if (TaskSort.sortTaskBy == "Date"){
            if(this.getCompletionDate().before(o.getCompletionDate())){
                return -1;
            }
            else{
                return 1;
            }
        }
        
        
        return this.getPriorityOrder() -o.getPriorityOrder();
    }
}


