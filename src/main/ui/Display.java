package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Display extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;

    // MODIFIES: THIS
    // EFFECTS: sets a background display for the application
    public void backgroundGraphics() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(224,224,224));
        panel.setBounds(300,0,700, 400);

        JLabel label = new JLabel();
        label.setText("Todo List");
        label.setFont(new Font("Verdana", Font.BOLD, 19));
        label.setBounds(60, 50, 100, 30);
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


    //EFFECTS: user story buttons as the menu
    public void addMenu() {
        this.b1 = new JButton("LOAD your list");
        b1.setBounds(60,100,100, 40);
        b1.addActionListener(this);
        setButton(b1);

        this.b2 = new JButton("Add Task");
        b2.setBounds(60,150,100, 40);
        setButton(b2);

        this.b3 = new JButton("Remove Task");
        b3.setBounds(60,200,100, 40);
        setButton(b3);

        this.b4 = new JButton("Save");
        b4.setBounds(60,250,100, 40);
        setButton(b4);

    }


    // EFFECTS: Sets button characteristics
    private void setButton(JButton b1) {
        b1.setSize(150,40);
        b1.setForeground(Color.WHITE);
        frame.add(b1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

