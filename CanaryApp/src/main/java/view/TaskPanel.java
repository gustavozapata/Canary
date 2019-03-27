package view;

import java.awt.Color;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author k1715308
 */
public class TaskPanel extends JPanel {

    public TaskPanel() {
        super(true);
        this.setBackground(Color.WHITE);
    }

    public TaskPanel(LayoutManager layout) {
        super(layout, true);
        this.setBackground(Color.WHITE);
    }

    public TaskPanel(String type) {
        if (type.equals("Task")) {
            this.setBackground(new Color(241, 241, 241));
        }
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(boxLayout);
    }
}
