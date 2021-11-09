package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Display {

    JFrame frame = new JFrame();

    // EFFECTS: sets a background display for the application
    public void backgroundGraphics() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(224,224,224));
        panel.setBounds(300,0,700, 400);

        JLabel label = new JLabel();
        label.setText("Todo List");
        label.setFont(new Font("Verdana", Font.BOLD, 19));
        label.setBounds(60, 20, 100, 30);
        label.setForeground(new Color(255,255,255));

        frame.setSize(700, 400);
        frame.setTitle("Your todo list app");
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(64, 64, 64));
        frame.add(label);
        frame.add(panel);
        addMenu();

    }

    @SuppressWarnings("checkstyle:MethodLength")
    public void addMenu() {
        JButton b1 = new JButton("Add Task");
        b1.setBounds(60,70,100, 40);
        b1.setSize(150,40);
        frame.add(b1);

        JButton b2 = new JButton("Remove Task");
        b2.setBounds(60,120,100, 40);
        b2.setSize(150,40);
        frame.add(b2);

        JButton b3 = new JButton("Mark as complete");
        b3.setBounds(60,170,100, 40);
        b3.setSize(150,40);
        frame.add(b3);

        JButton b4 = new JButton("View Completed");
        b4.setBounds(60,220,100, 40);
        b4.setSize(150,40);
        frame.add(b4);

        JButton b5 = new JButton("Save");
        b5.setBounds(60,270,100, 40);
        b5.setSize(150,40);
        frame.add(b5);

        JButton b6 = new JButton("Load todo list");
        b6.setBounds(60,320,100, 40);
        b6.setSize(150,40);
        frame.add(b6);
    }


}
