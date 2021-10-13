package model;

public class Task {

    private String task;
    private boolean complete;

    public Task(String task) {
        this.task = task;
        this.complete = false;

    }

    public boolean isComplete() {
        return complete;
    }

    public boolean setComplete() {
        this.complete = true;
        return true;
    }

    public String getTask() {
        return task;
    }
}

