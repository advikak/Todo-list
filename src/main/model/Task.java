package model;

import org.json.JSONObject;
import persistence.Writable;

// This class represents a task, used to create other task objects which will be used in the array list ToDoList
// also includes methods related to the task
public class Task implements Writable {

    private String task;

    //EFFECTS: Constructing a task with a description and default as incomplete
    public Task(String task) {
        this.task = task;
    }

    //EFFECTS: returns the description of the task
    public String getTaskDescription() {
        return task;
    }

    @Override
    public String toString() {
        return task;
    }

    @Override
    // EFFECTS: stores task in JSONobject
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", task);
        return json;
    }
}

