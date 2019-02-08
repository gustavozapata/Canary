/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Gustavo
 */
public class MainWindow extends JFrame {
    
    public MainWindow() {
        this.setTitle("TODO CANARIO");
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(1200, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    
    //SINGLETON CLASS - (ONLY ONE INSTANCE OF THE CLASS CAN BE CREATED)
    /*public static MainWindow instance = null;
    private MainWindow(){
        super();
    }
    public static MainWindow getInstance(){
        if(MainWindow.instance == null){
            instance = new MainWindow();
        }
        return instance;
    }*/
}
