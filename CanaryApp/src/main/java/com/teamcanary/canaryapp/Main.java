
package com.teamcanary.canaryapp;

import java.awt.BorderLayout;
import javax.swing.WindowConstants;
import view.MainWindow;

import model.*;

public class Main {
    public static void main(String[] args){
        
        //MAIN WINDOW
        MainWindow window = new MainWindow();
        
        Task t1 = new Task("Create a Task");
        SubTask s1 = new SubTask("Create a SubTask");
        SubTask s2 = new SubTask("Create a Second SubTask");
        s2.toggleComplete();
        t1.getSubTaskContainer().AddSubTask(s1);
        t1.getSubTaskContainer().AddSubTask(s2);
        
        t1.getDebugger().Print();
        
        
        
        
                
    }
}
