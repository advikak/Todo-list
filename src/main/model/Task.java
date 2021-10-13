package model;

// This class represents a task, used to create other task objects which will be used in the array list ToDoList
public class Task {

    private String task;
    private boolean complete;

    public Task(String task) {
        this.task = task;
        this.complete = false;
    }

    //EFFECTS: return whether the task is complete (true) or not (false)
    public boolean isComplete() {
        return complete;
    }

    //EFFECTS: sets the task to complete (true)
    public boolean setComplete() {
        this.complete = true;
        return true;
    }

    //EFFECTS: returns the description of the task
    public String getTask() {
        return task;
    }
}

