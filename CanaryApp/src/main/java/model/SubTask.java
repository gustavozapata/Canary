package model;

public class SubTask extends Task {
    public SubTask(TaskContainer taskContainer, String taskDescription, User user){ // Doesnt duplicate variables, just passes them in
        super(taskContainer, taskDescription, user); // Uses superclasses constructor
    }
}
