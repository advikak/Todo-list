package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Class for constructing TodoList and methods related to the list
public class ToDoList implements Writable {

    private String name;
    private ArrayList<Task> todo;

    // EFFECTS: todolist is empty
    public ToDoList(String name) {
        this.name = name;
        todo = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // EFFECTS: returns an unmodifiable list of thingies in this workroom
    public List<Task> getTasks() {
        return Collections.unmodifiableList(todo);
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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Tasks", tasksToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray tasksToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Task t : todo) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }
}


