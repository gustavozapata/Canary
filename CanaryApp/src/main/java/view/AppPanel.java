package view;

import java.awt.Color;
import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 *
 * @author k1715308
 */
public class AppPanel extends JPanel {
    public AppPanel(){
        super(true);
        this.setBackground(Color.WHITE);
    }
    public AppPanel(LayoutManager layout) {
        super(layout, true);
        this.setBackground(Color.WHITE);
    }
}
