package view;

import controller.SubTaskListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.SubTask;

/**
 *
 * @author Gustavo
 */
public class SubTaskView extends JPanel {

    //PANELS #1
    private TaskPanel topPart;
    private TaskPanel bottomPart;
    private TaskPanel taskDescriptionPanel;
    private TaskPanel actionsPanel;
    private TaskPanel taskInfoPanel;

    //PANELS #2
    private TaskPanel editPanel;
    private TaskPanel deletePanel;

    //COMPONENTS
    private JLabel taskDescription = new JLabel();
    private JLabel taskPriority = new JLabel();

    private JLabel editLabel = new JLabel();
    private JLabel deleteLabel = new JLabel();

    private SubTask subtask;

    //ICONS
    private JLabel deleteIcon;
    private JLabel editIcon;

    //STYLES
    private TaskStyle taskStyle = new TaskStyle();

    //LISTENERS
    private SubTaskListener subtaskListener = new SubTaskListener();

    public SubTaskView(SubTask subtask) {
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(221, 221, 221));
        this.setPreferredSize(new Dimension(650, 60));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));

        this.topPart = new TaskPanel("Subtask");
        this.bottomPart = new TaskPanel("Subtask");
        this.taskDescriptionPanel = new TaskPanel("Subtask");
        this.actionsPanel = new TaskPanel("Subtask");
        this.taskInfoPanel = new TaskPanel("Subtask");

        this.editPanel = new TaskPanel("Subtask");
        this.deletePanel = new TaskPanel("Subtask");

        setPanels();
        initializeImages();
        setComponents();

        addElementsToTask(subtask);
        addComponents();

        this.editPanel.addMouseListener(this.subtaskListener);
        this.deletePanel.addMouseListener(this.subtaskListener);
    }

    public void setComponents() {
        this.editLabel.setText("Edit");
        this.deleteLabel.setText("Delete");

        this.editIcon.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        this.deleteIcon.setBorder(BorderFactory.createEmptyBorder(0, 7, 5, 0));

        this.editPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.deletePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.editPanel.setName("subtask_edit_btn");
        this.deletePanel.setName("subtask_delete_btn");
    }

    public void setPanels() {
        this.topPart.setLayout(new BorderLayout());

        this.bottomPart.setPreferredSize(new Dimension(50, 24));
        this.actionsPanel.setPreferredSize(new Dimension(73, 25));

        this.taskInfoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.actionsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 13, 5));
        this.taskInfoPanel.setBorder(BorderFactory.createEmptyBorder(0,15,0,0));

        taskStyle.styleActionLabel(this.editLabel);
        taskStyle.styleActionLabel(this.deleteLabel);
    }

    public void initializeImages() {
        try {
            BufferedImage deleteImg = ImageIO.read(new File("src/images/delete.png"));
            BufferedImage editImg = ImageIO.read(new File("src/images/edit.png"));
            this.deleteIcon = new JLabel(new ImageIcon(deleteImg));
            this.editIcon = new JLabel(new ImageIcon(editImg));
        } catch (IOException e) {
        }
    }

    public void addElementsToTask(SubTask subtask) {
        this.taskDescription.setText(subtask.getDescription());
        this.taskDescription.setBorder(BorderFactory.createEmptyBorder(5, 20, 0, 0));
        this.taskDescription.setFont(new Font("SansSerif", Font.PLAIN, 17));
        
        this.taskPriority.setFont(new Font("SansSerif", Font.BOLD, 10));
        this.taskPriority.setText("Priority: " + subtask.getPriorityOrder());
        this.taskPriority.setOpaque(true);
        this.taskPriority.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), new EmptyBorder(0, 2, 0, 2)));

        setPriority(subtask);

    }

    public void addComponents() {
        this.editPanel.add(editIcon);
        this.editPanel.add(editLabel);
        this.deletePanel.add(deleteIcon);
        this.deletePanel.add(deleteLabel);

        this.actionsPanel.add(editPanel);
        this.actionsPanel.add(deletePanel);

        this.taskDescriptionPanel.add(taskDescription);

        this.taskInfoPanel.add(taskPriority);

        this.topPart.add(taskDescriptionPanel, BorderLayout.CENTER);
        this.topPart.add(actionsPanel, BorderLayout.EAST);
        this.bottomPart.add(taskInfoPanel);

        this.add(topPart, BorderLayout.CENTER);
        this.add(bottomPart, BorderLayout.SOUTH);
    }

    public SubTask getSubTask() {
        return this.subtask;
    }

    public void setPriority(SubTask subtask) {
        int priority = subtask.getPriorityOrder();
        if (priority >= 14) {
            taskPriority.setBackground(new Color(234, 248, 39));
        } else if (priority >= 7) {
            taskPriority.setBackground(new Color(248, 220, 39));
        } else {
            taskPriority.setBackground(new Color(248, 171, 39));
        }
    }
}
