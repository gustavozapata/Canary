package com.teamcanary.canaryapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Gustavo
 */
public class OldMain {
    public static void main(String[] args) throws IOException {
        JFrame window = new JFrame("TODO CANARIO");
        window.setLayout(new BorderLayout());
        window.setSize(1200, 700);
        //window.getContentPane().setBackground(Color.WHITE);
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                
        
        //#########  COMPONENTS  ###########
        
        //TITLE
        JLabel appTitle = new JLabel("ToDo Canario");
        appTitle.setFont(new Font("Sans-Serif", Font.BOLD, 40));
        appTitle.setHorizontalAlignment(JLabel.CENTER);
        
        //ADD TASK
        JLabel addTask = new JLabel("+");
        addTask.setFont(new Font("Sans-Serif", Font.BOLD, 60));
        addTask.setForeground(new Color(28, 226, 219));
        addTask.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JLabel addTaskText = new JLabel("New Task");
        addTaskText.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        addTaskText.setForeground(new Color(112, 112, 112));
        
        //CONTACT CANARY
        JLabel contactUs = new JLabel("Contact Canary");
        contactUs.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        contactUs.setHorizontalAlignment(JLabel.CENTER);
        contactUs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Map attributes = contactUs.getFont().getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        contactUs.setFont(contactUs.getFont().deriveFont(attributes));
        
        
        
        //#########  PANELS  ###########
        
        //TOP PANEL
        JPanel addTaskPanel = new JPanel();
        BoxLayout addTaskLayout = new BoxLayout(addTaskPanel, BoxLayout.Y_AXIS);
        addTaskPanel.setBackground(Color.WHITE);
        addTaskPanel.setLayout(addTaskLayout);
        addTaskPanel.setBorder(new EmptyBorder(0, 15, 0, 0));
//        addTaskPanel.setBorder(BorderFactory.createLineBorder(new Color(112,112,112)));
        
        addTask.setBorder(BorderFactory.createEmptyBorder(0, 18, 0, 0));
        addTask.setHorizontalAlignment(JLabel.CENTER);
        
        
        addTaskPanel.add(addTask);
        addTaskPanel.add(addTaskText);
        
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(addTaskPanel, BorderLayout.WEST);
        topPanel.add(appTitle, BorderLayout.CENTER);
        topPanel.setBackground(Color.WHITE);
        
        
        
        //MIDDLE PANEL
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BorderLayout());
        middlePanel.setSize(300,300);
        middlePanel.setBackground(Color.WHITE);
        middlePanel.setPreferredSize(new Dimension(600, 400));
        middlePanel.setMaximumSize(new Dimension(500, 400));
        middlePanel.setBorder(BorderFactory.createLineBorder(new Color(112,112,112)));
        
        //BORDER COLOR + MARGIN
        //Border border = BorderFactory.createLineBorder(new Color(112,112,112));
        //middlePanel.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(20, 20, 20, 20)));
                       
        
        
        //BOTTOM PANEL
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(contactUs);
        bottomPanel.setBackground(Color.WHITE);
        
        
        
        //TODO LAYOUT
        JPanel topTodoPanel = new JPanel();
        JPanel centerTodoPanel = new JPanel();
        
        centerTodoPanel.setLayout(new BoxLayout(centerTodoPanel, BoxLayout.Y_AXIS));
        centerTodoPanel.setBackground(Color.WHITE);
        topTodoPanel.setBackground(new Color(186, 207, 223));
        
        //PANELS TO FILL UP SPACE (WE MIGHT WANT TO REMOVE THEM)
        JPanel westPanel = new JPanel();
        westPanel.setPreferredSize(new Dimension(100, 300));
        westPanel.setBackground(Color.WHITE);
        JPanel eastPanel = new JPanel();
        eastPanel.setPreferredSize(new Dimension(100, 300));
        eastPanel.setBackground(Color.WHITE);
        
        //SCROLLPANE AT SOME POINT HERE
        //ScrollPane tasksScroll = new JScrollPane(centerTodoPanel);
        //middlePanel.add(tasksScroll, BorderLayout.CENTER);
        
        
        JCheckBox taskCompleteCheckBox = new JCheckBox();
        JLabel taskDescription = new JLabel("Make an stunning Java Swing App");
        
        //TASK CONTAINER
        JPanel centerTaskPanel = new JPanel(new BorderLayout());
        JPanel taskInformationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        centerTaskPanel.add(taskDescription, BorderLayout.NORTH);
        centerTaskPanel.add(taskInformationPanel, BorderLayout.CENTER);
        
        JPanel taskActionsPanel = new JPanel();
        JLabel editTask = new JLabel("Edit");
        taskActionsPanel.add(editTask);
        
//        BufferedImage image = ImageIO.read(new File("/edit2.png"));
//        JLabel label = new JLabel(new ImageIcon(image));
//        taskActionsPanel.add(label);

        JLabel assignee = new JLabel("Assigned to: Kylan Haffie");
        taskInformationPanel.add(assignee);




        
        JPanel taskCompletePanel = new JPanel();
        taskCompletePanel.add(taskCompleteCheckBox);
        
        JPanel taskPanel = new JPanel(new BorderLayout());
        taskPanel.add(taskCompletePanel, BorderLayout.WEST);
        taskPanel.add(centerTaskPanel, BorderLayout.CENTER);
        taskPanel.add(taskActionsPanel, BorderLayout.EAST);
        
        centerTodoPanel.add(taskPanel);
        
        //ADDING TOOLBAR AND MAIN TASK PANEL
        middlePanel.add(topTodoPanel, BorderLayout.NORTH);
        middlePanel.add(centerTodoPanel, BorderLayout.CENTER);
        
        window.add(topPanel, BorderLayout.NORTH);
        window.add(middlePanel, BorderLayout.CENTER);
        window.add(bottomPanel, BorderLayout.SOUTH);
        window.add(westPanel, BorderLayout.WEST);
        window.add(eastPanel, BorderLayout.EAST);
        
        System.out.println(Arrays.toString(Toolkit.getDefaultToolkit().getFontList()));
    }
}

