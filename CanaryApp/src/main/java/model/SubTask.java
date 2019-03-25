package model;


public class SubTask {
    
    private String description;
    private String priority;
    
    
    public SubTask(TaskContainer taskContainer, String taskDescription){ // Doesnt duplicate variables, just passes them in
//        super(taskDescription, user); // Uses superclasses constructor
    }
    
    public SubTask(){
        
    }
    
    
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
