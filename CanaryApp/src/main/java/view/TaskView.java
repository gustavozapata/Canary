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
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
    
    public TaskView(String task_description, boolean task_completed, User task_assignee,boolean isSubTask){
       
        
        

       completed.setSelected(task_completed);
       description.setText(task_description);
       description.setHeadingTwo();
       JPanel layout = new JPanel();

        if(isSubTask){
            description.setHeadingThree();
            BoxLayout boxlayout = new BoxLayout(layout, BoxLayout.X_AXIS);
            layout.setLayout(boxlayout); 
           AppText image = new AppText("");
           image.setIcon(new ImageIcon("src/main/java/images/BlankBorder.png"));
           layout.add(image);
           layout.add(completed);
           layout.add(description); 
           layout.setPreferredSize(new Dimension(900,50));
       }
        else{
             description.setHeadingTwo();
             BorderLayout borderlayout = new BorderLayout(1,20);
   
             layout.setLayout(borderlayout);
            
            
            layout.add(completed,BorderLayout.WEST);   
            layout.add(description,BorderLayout.CENTER); 
            layout.setPreferredSize(new Dimension(900,100));
            assignee.setText("Assigned to: " + task_assignee.getGivenName());
            layout.add(assignee,BorderLayout.PAGE_END);
            
        }
       
 
       
       this.add(layout);   
       

       
       
       
       
       
       
       
       
       
       
    }   
    
}
