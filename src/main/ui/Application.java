package ui;

import model.CompletedTasks;
import model.Task;
import model.ToDoList;

import java.util.Scanner;

// This class references code from this
// https://github.students.cs.ubc.ca/CPSC210/TellerApp
// This class is for user interface, todolist application in the console
public class Application {

    private Scanner input;
    private ToDoList todo;
    private CompletedTasks completeTasks;

    //EFFECTS: runs the application
    public Application() {
        runApp();     //code based on TellerApp
    }

    // MODIFIES: this
    // EFFECTS: processes the users input
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

    //EFFECTS: displays the menu with options for selection
    private void displayMenu() {
        System.out.println("Select action to perform on your todo list: ");
        System.out.println("\ta -> add task");
        System.out.println("\tv -> view todo list");
        System.out.println("\tm -> mark task as complete");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            addTaskToList();
        } else if (command.equals("v")) {
            printTodoList();
        } else if (command.equals("m")) {
            markAsComplete();
        } else {
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

    //EFFECTS: User enters task which adds to todolist
    public void addTaskToList() {
        System.out.print("Enter your task: ");
        String task = input.next();
        Task t1 = new Task(task);
        todo.addTask(t1);
    }

    //EFFECTS: Prints the full todolist on incomplete tasks
    public void printTodoList() {
        System.out.println("Your todo list: ");
        if (todo.isEmpty()) {
            System.out.println("Nothing! You've completed all your tasks");
        } else {
            for (int i = 0; i < todo.listSize(); i++) {
                System.out.println((i + 1) + ": " + todo.getSpecificTask(i).getTaskDescription());
            }
        }
    }

    //EFFECTS: Marks task at number entered as completed and removes it from todolist
    public void markAsComplete() {
        if (todo.isEmpty()) {
            System.out.println("Todo list is empty, please make another selection");
        } else {
            System.out.println("Which task would you like to mark as complete? (Enter number): ");
            for (int i = 0; i < todo.listSize(); i++) {
                System.out.println((i + 1) + ": " + todo.getSpecificTask(i).getTaskDescription());
            }
            int num = input.nextInt();
            if (todo.listSize() >= num && num > 0) {
                todo.getSpecificTask(num - 1).setComplete();
                todo.removeTask(todo.getSpecificTask(num - 1));
            } else {
                System.out.println("Number is invalid, please try again");
            }
        }
    }
}

