package model;

import java.util.ArrayList;
import java.util.List;

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

    public void viewTodoList() {
        for (int i = 0; i < todo.size(); i++) {
            System.out.println(todo.get(i).getTaskDescription());
        }
    }
}