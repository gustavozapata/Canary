/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import model.User;
import view.AppText;


public class TaskView extends JPanel{
    
    
    
    private AppText description = new AppText("New Task");
    private AppText assignee = new AppText("");
    private JCheckBox completed = new JCheckBox();
    
    public TaskView(String task_description, boolean task_completed, User task_assignee){
       
        
        
       BorderLayout borderlayout = new BorderLayout(10,20);
       JPanel layout = new JPanel();
       layout.setLayout(borderlayout);
       
       completed.setSelected(task_completed); 
       layout.add(completed,BorderLayout.WEST);   

       description.setText(task_description);
       description.setHeadingTwo();
       layout.add(description,BorderLayout.CENTER); 
       
       assignee.setText("Assigned to: " + task_assignee.getGivenName());
       layout.add(assignee,BorderLayout.PAGE_END);
 
       layout.setPreferredSize(new Dimension(900,100));
       this.add(layout,BorderLayout.WEST);   
    }   
    
}
