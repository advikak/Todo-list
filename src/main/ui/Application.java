package ui;

import model.Task;
import model.ToDoList;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// This class references code from this
// https://github.students.cs.ubc.ca/CPSC210/TellerApp
// This class is for user interface, todolist application in the console
public class Application {

    private static final String JSON_STORE = "./data/todolist.json";
    private Scanner input;
    private ToDoList todo;
    private ToDoList completeTasks;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    //EFFECTS: runs the application
    public Application() throws FileNotFoundException {
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
        System.out.println("\tr -> remove a task from the list");
        System.out.println("\tc -> view completed tasks");
        System.out.println("\ts -> save todolist to file");
        System.out.println("\tl -> load todolist from file");
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
        } else if (command.equals("r")) {
            removeTaskFromTodo();
        } else if (command.equals("c")) {
            viewCompletedTasks();
        } else if (command.equals("s")) {
            saveToDo();
        } else if (command.equals("l")) {
            loadToDo();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes ToDoList and completed task list
    private void init() {
        completeTasks = new ToDoList();
        todo = new ToDoList();
        input = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
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
                completeTasks.addTask(todo.getSpecificTask(num - 1));
                todo.removeTask(todo.getSpecificTask(num - 1));
            } else {
                System.out.println("Number is invalid, please try again");
            }
        }
    }

    // EFFECTS: Removes a task from the todolist
    public void removeTaskFromTodo() {
        if (todo.isEmpty()) {
            System.out.println("Todo list is empty, please make another selection");
        } else {
            System.out.println("Which task would you like to remove from list? (Enter number): ");
            for (int i = 0; i < todo.listSize(); i++) {
                System.out.println((i + 1) + ": " + todo.getSpecificTask(i).getTaskDescription());
            }
            int num = input.nextInt();
            if (todo.listSize() >= num && num > 0) {
                todo.removeTask(todo.getSpecificTask(num - 1));
            } else {
                System.out.println("Number is invalid, please try again");
            }
        }
    }

    // EFFECTS: Allows user to view list of completed tasks
    public void viewCompletedTasks() {
        if (completeTasks.isEmpty()) {
            System.out.println("No tasks have been completed");
        } else {
            for (int i = 0; i < completeTasks.listSize(); i++) {
                System.out.println((i + 1) + ": " + completeTasks.getSpecificTask(i).getTaskDescription());
            }
        }
    }

    // EFFECTS: saves the todolist to file
    private void saveToDo() {
        try {
            jsonWriter.open();
            jsonWriter.write(todo);
            jsonWriter.close();
            System.out.println("Saved todolist to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads todolist from file
    private void loadToDo() {
        try {
            todo = jsonReader.read();
            System.out.println("Loaded todolist from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}

