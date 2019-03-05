/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
