package ui;

import model.Task;
import model.ToDoList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Display extends JFrame {

    private JTextField text = new JTextField(25);
    private JList list = new JList();
    private ToDoList todo = new ToDoList();
    private TodoListModel m1 = new TodoListModel(todo);

    private JButton b1 = new JButton("Add");
    private JButton b2 = new JButton("Remove");
    private JButton b3 = new JButton("Load");
    private JButton b4 = new JButton("Save");

    // EFFECTS: sets a display for the application
    public Display() {
        setFrame();
        setLayout(new GridLayout(2,1));

        JPanel panel = new JPanel();
        add(panel);
        panel.add(new JScrollPane(list));

        list.setModel(m1);

        addMenu();
    }

    // EFFECTS: Sets the frame display of the program
    private void setFrame() {
        setSize(700, 400);
        setTitle("Your todo list app");
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(new Color(64, 64, 64));
    }

    // MODIFIES: this
    //EFFECTS: Sets user story buttons and text field as the menu
    public void addMenu() {
        JPanel menuPanel = new JPanel();
        add(menuPanel);

        menuPanel.add(text);
        menuPanel.add(b1);
        addTask(b1);
        menuPanel.add(b2);
        removeTask(b2);
        menuPanel.add(b3);
        loadTodo(b3);
        menuPanel.add(b4);
        saveTodo(b4);

        revalidate();
    }

    // MODIFIES: this
    // EFFECTS: Adding a task button, this will add task that user had inputted into list
    public void addTask(JButton b1) {
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!text.getText().isEmpty()) {
                    Task item = new Task(text.getText());
                    m1.addElement(item);
                    text.setText(null);
                }
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: Removing a task button, this will remove task that user has selected on the list
    public void removeTask(JButton b2) {
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m1.remove(list.getSelectedIndex());
            }
        });
    }

    // EFFECTS: loads the todolist
    public void loadTodo(JButton b3) {
        // todo
    }

    // EFFECTS: saves the todolist
    public void saveTodo(JButton b4) {
        // todo
    }


}

