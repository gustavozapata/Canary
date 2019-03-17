package view;

import controller.AppListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.TaskContainer;
import model.Task;
import model.User;

public class TaskView extends JPanel {

    TaskPanel topPart = new TaskPanel("Task");
    TaskPanel bottomPart = new TaskPanel("Task");
    TaskPanel checkBoxPanel = new TaskPanel("Task");
    TaskPanel taskDescriptionPanel = new TaskPanel("Task");
    TaskPanel actionsPanel = new TaskPanel("Task");
    TaskPanel taskInfoPanel = new TaskPanel("Task");

    TaskPanel subtaskPanel = new TaskPanel("Task");
    TaskPanel editPanel = new TaskPanel("Task");
    TaskPanel deletePanel = new TaskPanel("Task");

    TaskLabel taskDescription = new TaskLabel();
    TaskLabel taskCategory = new TaskLabel();
    TaskLabel taskAssignee = new TaskLabel();
    TaskLabel taskPriority = new TaskLabel();
    TaskLabel taskDate = new TaskLabel();
    Date selectedDate;

    TaskLabel subtaskLabel = new TaskLabel("Subtask");
    TaskLabel editLabel = new TaskLabel("Edit");
    TaskLabel deleteLabel = new TaskLabel("Delete");

    JLabel deleteIcon;
    JLabel editIcon;
    JLabel subtaskIcon;

    TaskStyle taskStyle = new TaskStyle();

    JCheckBox taskCheckBox = new JCheckBox();

    //LISTENERS
    private AppListener appListener = new AppListener();

    Task linkedTask;

    public TaskView() {
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(241, 241, 241));
        this.setPreferredSize(new Dimension(900, 90));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        taskCheckBox.addMouseListener(appListener);

        topPart.setLayout(new BorderLayout());

        bottomPart.setPreferredSize(new Dimension(200, 25));
        actionsPanel.setPreferredSize(new Dimension(120, 25));
        checkBoxPanel.setPreferredSize(new Dimension(60, 25));

        taskStyle.styleActionLabel(subtaskLabel);
        taskStyle.styleActionLabel(editLabel);
        taskStyle.styleActionLabel(deleteLabel);

        try {
            BufferedImage deleteImg = ImageIO.read(new File("src/images/delete.png"));
            BufferedImage editImg = ImageIO.read(new File("src/images/edit.png"));
            BufferedImage subtaskImg = ImageIO.read(new File("src/images/subtask.png"));
            deleteIcon = new JLabel(new ImageIcon(deleteImg));
            editIcon = new JLabel(new ImageIcon(editImg));
            subtaskIcon = new JLabel(new ImageIcon(subtaskImg));

            taskCheckBox.setSelectedIcon(new ImageIcon(ImageIO.read(new File("src/images/checked.png"))));
            taskCheckBox.setIcon(new ImageIcon(ImageIO.read(new File("src/images/checkbox.png"))));
        } catch (IOException e) {
        }

        subtaskIcon.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 0));
        editIcon.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        deleteIcon.setBorder(BorderFactory.createEmptyBorder(0, 7, 5, 0));

//        topPart.setBorder(BorderFactory.createLineBorder(Color.blue));
//        bottomPart.setBorder(BorderFactory.createLineBorder(Color.red));
//        checkBoxPanel.setBorder(BorderFactory.createLineBorder(Color.orange));
//        taskDescriptionPanel.setBorder(BorderFactory.createLineBorder(Color.pink));
//        actionsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//        taskInfoPanel.setBorder(BorderFactory.createLineBorder(Color.magenta));
        taskInfoPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));
        actionsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 13, 5));

        subtaskPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        editPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deletePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        topPart.add(checkBoxPanel, BorderLayout.WEST);
        topPart.add(taskDescriptionPanel, BorderLayout.CENTER);
        topPart.add(actionsPanel, BorderLayout.EAST);
        bottomPart.add(taskInfoPanel);

        addElementsToTask();
        addToTaskContainer();

        this.add(topPart, BorderLayout.CENTER);
        this.add(bottomPart, BorderLayout.SOUTH);
    }

    public void addElementsToTask() {
        taskDescription.setText(NewTaskView.createTaskDescriptionTextField.getText());
        taskDescription.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        taskDescription.setFont(new Font("Sans-Serif", Font.PLAIN, 20));

        taskCheckBox.setName("check_btn");
        taskCheckBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));
        taskAssignee.setText("Assigned to: " + NewTaskView.createTaskAssignedDrop.getSelectedItem().toString());
        taskCategory.setText(NewTaskView.createTaskCategoryDrop.getSelectedItem().toString());
        taskPriority.setText("Priority: " + NewTaskView.groupPriority.getSelection().getActionCommand());
        taskPriority.setOpaque(true);
        taskPriority.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), new EmptyBorder(0, 5, 0, 5)));
        setPriority();

        setDueDate();

        taskCategory.setOpaque(true);
        taskCategory.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), new EmptyBorder(0, 5, 0, 5)));
        setTaskCategory();

        subtaskPanel.add(subtaskIcon);
        subtaskPanel.add(subtaskLabel);
        editPanel.add(editIcon);
        editPanel.add(editLabel);
        deletePanel.add(deleteIcon);
        deletePanel.add(deleteLabel);

        actionsPanel.add(subtaskPanel);
        actionsPanel.add(editPanel);
        actionsPanel.add(deletePanel);

        taskDescriptionPanel.add(taskDescription);
        checkBoxPanel.add(taskCheckBox);
        taskInfoPanel.add(taskCategory);
        taskInfoPanel.add(taskAssignee);
        taskInfoPanel.add(taskPriority);
        taskInfoPanel.add(taskDate);
    }

    public void setDueDate() {
        selectedDate = (Date) NewTaskView.datePicker.getModel().getValue();
        taskDate.setText("Due: " + selectedDate);
        taskDate.setForeground(new Color(255, 29, 83));
    }

    public void setPriority() {
        String priority = NewTaskView.groupPriority.getSelection().getActionCommand();
        System.out.println(priority);
        if (priority.equals("High")) {
            taskPriority.setBackground(new Color(248, 171, 39));
        } else if (priority.equals("Low")) {
            taskPriority.setBackground(new Color(234, 248, 39));
        } else {
            taskPriority.setBackground(new Color(248, 220, 39));
        }
    }

    public void addToTaskContainer() {
        this.linkedTask = TaskContainer.getInstance().newTask(NewTaskView.createTaskDescriptionTextField.getText(), new User("jhi", "jiji", "jiji", "jkj"));
    }

    public void setTaskCategory() {
        String category = NewTaskView.createTaskCategoryDrop.getSelectedItem().toString();
        taskCategory.setForeground(Color.white);
        if (category.equals("University")) {
            taskCategory.setBackground(new Color(42, 188, 204));
        } else if (category.equals("Home")) {
            taskCategory.setBackground(new Color(151, 42, 204));
        } else if (category.equals("Personal")) {
            taskCategory.setBackground(new Color(53, 204, 42));
        } else if (category.equals("Work")) {
            taskCategory.setBackground(new Color(241, 53, 117));
        }
    }
}
