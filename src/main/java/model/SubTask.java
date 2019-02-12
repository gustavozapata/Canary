
package model;


public class SubTask extends Task {

    public SubTask(TaskContainer taskContainer, String taskDescription) {
        super(taskContainer, taskDescription);
    }


//taskDescription, owner, etc, are already defined in Task. We can use them inside this class, we don't need to re-define them
}
