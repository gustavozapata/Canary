package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.NewTaskView;

public class AppListener implements MouseListener {
    static NewTaskView newTaskView = new NewTaskView();
    
    @Override
    public void mouseClicked(MouseEvent e) {
        newTaskView.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
