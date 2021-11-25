package ui;

import model.Task;
import model.ToDoList;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

// Display class sets the display/graphics of the gui, including button functionality
public class Display extends JFrame {

    private JTextField text = new JTextField(25);
    private JList list = new JList();
    private ToDoList todo = new ToDoList();
    private TodoListModel m1;

    private static final String JSON_STORE = "./data/todolist.json";
    private JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    private JsonReader jsonReader = new JsonReader(JSON_STORE);

    private JButton b1 = new JButton("Add");
    private JButton b2 = new JButton("Remove");
    private JButton b3 = new JButton("Load");
    private JButton b4 = new JButton("Save");
    private JScrollPane scrollPane = new JScrollPane(list);

    // EFFECTS: sets a display for the application
    public Display() {
        setFrame();
        setLayout(new GridLayout(2,1));

        JPanel panel = new JPanel();
        add(panel);
        panel.add(scrollPane);

        list.setModel(m1 = new TodoListModel(todo));

        addMenu();
    }

    // EFFECTS: Sets the frame display of the program
    private void setFrame() {
        setSize(350, 350);
        setTitle("Your todo list app");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(new Color(64, 64, 64));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                todo.printLog();
            }
        });

    }

    // MODIFIES: this
    //EFFECTS: Sets user story buttons and text field as the menu
    public void addMenu() {
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(new Color(92,92,92));
        add(menuPanel);

        text.setHorizontalAlignment(JTextField.CENTER);
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
                    Task task = new Task(text.getText());
                    m1.addElement(task);
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
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    todo = jsonReader.read();
                    viewTodo(todo);
                    todo.loadedList();
                } catch (IOException i) {
                    System.out.println("Unable to read from file: " + JSON_STORE);
                }
            }
        });
    }

    // EFFECTS: saves the todolist
    public void saveTodo(JButton b4) {
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jsonWriter.open();
                    jsonWriter.write(todo);
                    jsonWriter.close();
                    savePopUp();
                } catch (FileNotFoundException i) {
                    System.out.println("Unable to write to file: " + JSON_STORE);
                }
            }
        });
    }

    // EFFECTS: loads the saved todolist and sets that as the model
    public void viewTodo(ToDoList todo) {
        m1 = new TodoListModel(todo);
        list.setModel(m1);

    }

    // EFFECTS: popup window that says application has been saved + visual component with the dog image
    public void savePopUp() {
        ImageIcon doggo = new ImageIcon("dog.png");
        Image dog = doggo.getImage();
        Image newDog = dog.getScaledInstance(80,50, java.awt.Image.SCALE_SMOOTH);
        ImageIcon thisDog = new ImageIcon(newDog);

        JOptionPane.showMessageDialog(null,
                "Your todolist has been saved",
                "Saved",
                JOptionPane.WARNING_MESSAGE, thisDog);
    }


}

