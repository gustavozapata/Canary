package model;public class SubTask extends Task {
    public SubTask(TaskContainer taskContainer, String taskDescription, User user){ // Doesnt duplicate variables, just passes them in
        super(taskDescription, user); // Uses superclasses constructor
    }
}

