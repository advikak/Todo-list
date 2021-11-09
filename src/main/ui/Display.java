package ui;

import javax.swing.*;
import java.awt.*;

public class Display {

    // EFFECTS: sets a background display for the application
    public void backgroundGraphics() {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setTitle("Your todo list app");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(64, 64, 64));
    }
}
