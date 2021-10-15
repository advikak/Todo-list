package model;

// This class represents a task, used to create other task objects which will be used in the array list ToDoList
// also includes methods related to the task
public class Task {

    private String task;
    private boolean complete;

    //EFFECTS: Constructing a task with a description and default as incomplete
    public Task(String task) {
        this.task = task;
        this.complete = false;
    }

    //EFFECTS: return whether the task is complete (true) or not (false)
    public boolean isComplete() {
        return complete;
    }

    //MODIFIES: this
    //EFFECTS: sets the task to complete (true)
    public void setComplete() {
        this.complete = true;
    }

    //EFFECTS: returns the description of the task
    public String getTaskDescription() {
        return task;
    }
}

