package ui;

import model.Task;
import model.ToDoList;

import java.util.Scanner;

public class Application {

    private Scanner input;
    private ToDoList todo;

    //EFFECTS: runs the application
    public Application() {
        runApp();     //code based on TellerApp
    }

    private void runApp() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    private void displayMenu() {
        System.out.println("Select action to perform on your todo list: ");
        System.out.println("\ta -> add task");
        System.out.println("\tv -> view todo list");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            addTaskToList();
        } else if (command.equals("v")) {
            printTodoList();
        }  else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes ToDoList
    private void init() {
        todo = new ToDoList();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    public void addTaskToList() {
        System.out.print("Enter your task: ");
        String task = input.next();
        Task t1 = new Task(task);
        todo.addTask(t1);
    }

    // EFFECTS:
    public void printTodoList() {
        System.out.println("Your todo list: ");
        todo.viewTodoList();
    }
}



