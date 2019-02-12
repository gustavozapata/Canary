/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class TaskView extends JPanel{
    
    
    
    private AppText textarea = new AppText("New Task");
    private JCheckBox completed = new JCheckBox();
    
    public TaskView(String task_description, boolean task_completed){
       
       textarea.setText(task_description);
       textarea.setHeadingTwo();
       completed.setSelected(task_completed);  
       JPanel listPane = new JPanel();
       listPane.setLayout(new BoxLayout(listPane, BoxLayout.X_AXIS));
       listPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
       listPane.add(textarea);
       listPane.add(completed);
       this.add(listPane);
    }   
    
}
