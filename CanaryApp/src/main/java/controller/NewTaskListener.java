package controller;

import static controller.AppListener.newTaskView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Gustavo
 */


public class NewTaskListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        newTaskView.setVisible(false);
//        test.renderTasks();
        AppGUIBuilder.renderTasks();
//        validate();
//        repaint();
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
