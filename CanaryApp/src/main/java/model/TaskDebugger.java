
package model;


public class TaskDebugger {
    
    Task task;
    public TaskDebugger(){
        
        
    }
    public void setTask(Task task){
       this.task = task;    
    }
    public void Print(){
        System.out.println("------------------------------TASK--------------------------------------");
        System.out.println("TASK DESCRIPTION: " + task.getTaskDescription());
        System.out.println("COMPLETE: " + task.getComplete());
        System.out.println("PRIORITY: " + task.getPriority());
        System.out.println("ASSIGNEE: " + task.getAssignedTo());
        for (SubTask subtask: task.getSubTaskContainer().getSubTask()) {   
            System.out.println("---------------------------SUBTASK--------------------------------------");
            System.out.println("SUBTASK DESCRIPTION: " + subtask.getTaskDescription());
            System.out.println("COMPLETE: " + subtask.getComplete());
            System.out.println("PRIORITY: " + subtask.getPriority());
            System.out.println("ASSIGNEE: " + subtask.getAssignedTo());
        }
        System.out.println("------------------------------------------------------------------------");
    }
    
}
