/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Task;
import model.TaskContainer;
import view.AppView;

public class TaskFilter {

    static ArrayList<Task> old_tasks;
    static ArrayList<Task> unfilteredTasks = new ArrayList<Task>();

    
    public static void revert() {
        TaskContainer.getInstance().addItems(unfilteredTasks);
        AppView.getInstance().reRender();
        unfilteredTasks = new ArrayList<Task>();

    }
    

    public static void filterByUsername(String username) {
         filterBy("User",username);
        
        
    }

    public static void filterBy(String filterBy, String filter) {
        revert();

        ArrayList<Task> filteredTasks = TaskContainer.getInstance().getAll();

        ArrayList<Task> taskToRemove = new ArrayList<Task>();

        System.out.println(filter);
        if(filter!="All"){
        if (filterBy.equals("Description")) {
            for (Task task : filteredTasks) {
                if (!task.getDescription().equals(filter)) {
                    taskToRemove.add(task);
                }
            }
        } else if (filterBy.equals("Username")) {
            for (Task task : filteredTasks) {
                if (!task.getUser().getUserName().equals(filter)) {
                    taskToRemove.add(task);
                }
            }
        } else if (filterBy.equals("Catagory")) {
            for (Task task : filteredTasks) {
                if (!task.getCategory().equals(filter)) {
                    taskToRemove.add(task);
                }
            }           
        }
        else if(filterBy.equals("Priority")){
            for (Task task : filteredTasks) {
                if (!Integer.toString(task.getPriorityOrder()).equals(filter)) {
                    taskToRemove.add(task);
                }
            }
        }
        else if(filterBy.equals("User")){
            for (Task task : filteredTasks) {
                if (!task.getUser().getUserName().equals(filter)) {
                    taskToRemove.add(task);
                }
            }
        }

        for (Task task : taskToRemove) {
            filteredTasks.remove(task);
            unfilteredTasks.add(task);
        }
        TaskContainer.getInstance().clear();
        TaskContainer.getInstance().addItems(filteredTasks);
        }
        AppView.getInstance().reRender();

        //Redraw GUI
    }

}
