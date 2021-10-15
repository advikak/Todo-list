package model;

import java.util.ArrayList;

// Class for constructing TodoList and methods related to the list
public class ToDoList {

    private ArrayList<Task> todo;

    // EFFECTS: set is empty
    public ToDoList() {
        todo = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECTS: adds a task to the TodoList
    public void addTask(Task addedTask) {
        todo.add(addedTask);
    }

    //MODIFIES: this
    //EFFECTS: removes a task from the todolist
    public void removeTask(Task removedTask) {
        todo.remove(removedTask);
    }

    // EFFECTS: Returns true if Task is in todoList
    // and false otherwise
    public boolean contains(Task containsTask) {
        return todo.contains(containsTask);
    }

    // EFFECTS: Returns the number of items in the todolist
    public int listSize() {
        return todo.size();
    }

    // EFFECTS: Returns the task in todolist at index i
    public Task getSpecificTask(int i) {
        return todo.get(i);
    }

    //EFFECTS: Returns true if todolist is empty, false otherwise
    public boolean isEmpty() {
        return (todo.size() == 0);
    }
}



//    public void getToDoList() {
//        System.out.println("Your todo list: ");
//        if (todo.size() == 0) {
//            System.out.println("Your todo list is empty! Please select another option");
//        } else {
//            for (int i = 0; i < todo.listSize(); i++) {
//                System.out.println((i + 1) + ": " + todo.getSpecificTask(i).getTaskDescription());
//            }
//        }
//    }
//}
