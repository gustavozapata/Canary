/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author Gustavo
 */
public class TodoText extends JLabel {
    public TodoText(String text) {
        super(text, null, LEADING);
    }
    public TodoText(){
        super("", null, LEADING);
    }
    
    public void setNoTaskMsg(){
        this.setText("Nothing To Do! It's time to relax");
        this.setFont(new Font("Sans-Serif", Font.ITALIC, 20));
        this.setForeground(new Color(200, 200, 200));
        this.setBorder(BorderFactory.createEmptyBorder(200, 0, 0, 0));
    }
    
    public void setNewTaskTitle(String text){
        this.setText(text);
        this.setFont(new Font("Sans-serif", Font.BOLD, 27));
        this.setForeground(new Color(235,17,69));
    }
    
    public void setNewTaskLabel(String text){
        this.setText(text);
        this.setFont(new Font("Sans-serif", Font.BOLD, 23));
        this.setForeground(new Color(74,74,74));
    }
}
