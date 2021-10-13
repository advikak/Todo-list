package model;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {

    private List<Task> todo;

    // EFFECTS: set is empty
    public ToDoList() {
        todo = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECTS: adds a task to the TodoList
    public void addTask(Task addedTask) {
        todo.add(addedTask);

    }

    // EFFECTS: Returns true if Task is in todoList
    // and false otherwise
    public boolean contains(Task containsTask) {
        return true;
    }


    // EFFECTS: Returns the number of items in the todolist
    public int listSize() {
        return todo.size();
    }

    // EFFECTS: Returns the todo list
    public ToDoList getList() {
        return null;
    }

}
