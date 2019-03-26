package view;

import controller.AppController;
import controller.TaskListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.SubTask;
import model.Task;
import model.User;

/**
 *
 * @author Gustavo
 */
public class SubTaskView extends JPanel {

    //PANELS #1
    private TaskPanel topPart;
    private TaskPanel bottomPart;
    private TaskPanel checkBoxPanel;
    private TaskPanel taskDescriptionPanel;
    private TaskPanel actionsPanel;
    private TaskPanel taskInfoPanel;

    //PANELS #2
    private TaskPanel editPanel;
    private TaskPanel deletePanel;

    //COMPONENTS
    private JLabel taskDescription = new JLabel();
    private JLabel taskPriority = new JLabel();
    private JLabel taskDate = new JLabel();

    private JLabel editLabel = new JLabel();
    private JLabel deleteLabel = new JLabel();
    private JCheckBox taskCheckBox = new JCheckBox();

    private SubTask subtask;

    //ICONS
    private JLabel deleteIcon;
    private JLabel editIcon;

    //STYLES
    private TaskStyle taskStyle = new TaskStyle();

    //LISTENERS
    private TaskListener taskListener = new TaskListener();
    private AppController appListener = new AppController();

    public SubTaskView(SubTask subtask) {
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(251, 251, 251));
        this.setPreferredSize(new Dimension(750, 70));
        this.setVisible(true);
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        this.topPart = new TaskPanel("Task");
        this.bottomPart = new TaskPanel("Task");
        this.checkBoxPanel = new TaskPanel("Task");
        this.taskDescriptionPanel = new TaskPanel("Task");
        this.actionsPanel = new TaskPanel("Task");
        this.taskInfoPanel = new TaskPanel("Task");

        this.editPanel = new TaskPanel("Task");
        this.deletePanel = new TaskPanel("Task");

        setPanels();
        initializeImages();
        setComponents();

        addElementsToTask(subtask);
        addComponents();

        this.editPanel.addMouseListener(this.taskListener);
        this.deletePanel.addMouseListener(this.taskListener);

        this.taskCheckBox.addActionListener((ActionEvent e) -> {
            if (this.taskCheckBox.isSelected()) {
//                this.taskDescription.setText("<html><body><span style='text-decoration: line-through;'>"+ this.taskDescription.getText() +"</span></body></html>");
                setCompletionDate(subtask);
            } else {
//                this.taskDescription.setText("<html><body><span style='text-decoration: none;'>"+ this.taskDescription.getText() +"</span></body></html>");
                this.taskDate.setVisible(false);
            }
        });
    }

    public void setComponents() {
        this.editLabel.setText("Edit");
        this.deleteLabel.setText("Delete");

        this.editIcon.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        this.deleteIcon.setBorder(BorderFactory.createEmptyBorder(0, 7, 5, 0));

        this.editPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.deletePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.taskCheckBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.editPanel.setName("edit_btn");
        this.deletePanel.setName("delete_btn");
    }

    public void setPanels() {
        this.topPart.setLayout(new BorderLayout());

        this.bottomPart.setPreferredSize(new Dimension(200, 25));
        this.actionsPanel.setPreferredSize(new Dimension(120, 25));
        this.checkBoxPanel.setPreferredSize(new Dimension(60, 25));

        this.taskInfoPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));
        this.actionsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 13, 5));

        taskStyle.styleActionLabel(this.editLabel);
        taskStyle.styleActionLabel(this.deleteLabel);
    }

    public void initializeImages() {
        try {
            BufferedImage deleteImg = ImageIO.read(new File("src/images/delete.png"));
            BufferedImage editImg = ImageIO.read(new File("src/images/edit.png"));
            this.deleteIcon = new JLabel(new ImageIcon(deleteImg));
            this.editIcon = new JLabel(new ImageIcon(editImg));

            this.taskCheckBox.setSelectedIcon(new ImageIcon(ImageIO.read(new File("src/images/checked.png"))));
            this.taskCheckBox.setIcon(new ImageIcon(ImageIO.read(new File("src/images/checkbox.png"))));
        } catch (IOException e) {
        }
    }

    public void addElementsToTask(SubTask subtask) {
        this.taskDescription.setText(subtask.getDescription());
        this.taskDescription.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        this.taskDescription.setFont(new Font("SansSerif", Font.PLAIN, 20));

        this.taskCheckBox.setName("check_btn");
        this.taskCheckBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));
        this.taskPriority.setText("Priority: " + subtask.getPriority());
        this.taskPriority.setOpaque(true);
        this.taskPriority.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), new EmptyBorder(0, 5, 0, 5)));

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

        this.checkBoxPanel.add(taskCheckBox);
        this.taskInfoPanel.add(taskPriority);
        this.taskInfoPanel.add(taskDate);

        this.topPart.add(checkBoxPanel, BorderLayout.WEST);
        this.topPart.add(taskDescriptionPanel, BorderLayout.CENTER);
        this.topPart.add(actionsPanel, BorderLayout.EAST);
        this.bottomPart.add(taskInfoPanel);

        this.add(topPart, BorderLayout.CENTER);
        this.add(bottomPart, BorderLayout.SOUTH);
    }

    public void setCompletionDate(SubTask subtask) {
        Date date = subtask.getCompletionDate();
        this.taskDate.setText("Completed on: " + date);
        this.taskDate.setForeground(new Color(255, 29, 83));
        this.taskDate.setVisible(true);
    }

    public SubTask getSubTask() {
        return this.subtask;
    }

    public void setPriority(SubTask subtask) {
        String priority = subtask.getPriority();
        if (priority.equals("High")) {
            taskPriority.setBackground(new Color(248, 171, 39));
        } else if (priority.equals("Low")) {
            taskPriority.setBackground(new Color(234, 248, 39));
        } else {
            taskPriority.setBackground(new Color(248, 220, 39));
        }
    }
}
