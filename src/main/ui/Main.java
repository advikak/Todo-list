package ui;

import javax.swing.*;
import java.io.FileNotFoundException;

// This class references code from the workroom app
// Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public class Main extends JFrame {

    public static void main(String[] args) {
        try {
            new Application();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}




