/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author Gustavo
 */
public class Main {
    public static void main(String[] args){
        JFrame window = new JFrame("TODO CANARIO");
        
        FlowLayout layout = new FlowLayout();
                
        JLabel appTitle = new JLabel("ToDo Canario");
        appTitle.setFont(new Font("Sans-Serif", Font.BOLD, 50));
        
        window.setLayout(layout);
        window.add(appTitle);
        window.setSize(1200, 700);
        window.getContentPane().setBackground(Color.WHITE);
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   
    }
}
