package model;

import java.util.ArrayList;

//
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

    // EFFECTS: Returns the task in todolist
    public Task getSpecificTask(int i) {
        return todo.get(i);
    }
}
