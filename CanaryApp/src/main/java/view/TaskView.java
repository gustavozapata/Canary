package view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author Gustavo
 */
public class TaskView extends JPanel {

    public TaskView(String type) {
        this.setBackground(new Color(241, 241, 241));
        this.setPreferredSize(new Dimension(900, 90));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
    }

}
