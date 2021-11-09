package ui;

import javax.swing.*;
import java.io.FileNotFoundException;

// This class references code from the workroom app
// Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public class Main extends JFrame {

    private void initializeGraphics() {
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            new Application();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}




