/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Gustavo
 */
public class SubTaskListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent().getName().equals("subtask_edit_btn")){
            System.out.println("subtask edit btn");
        } else if (e.getComponent().getName().equals("subtask_delete_btn")){
            System.out.println("subtask delete btn");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
