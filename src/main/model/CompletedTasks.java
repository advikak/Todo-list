package model;

import java.util.ArrayList;

public class CompletedTasks {

    private ArrayList<Task> complete;

    // EFFECTS: set is empty
    public CompletedTasks() {
        complete = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECTS: adds a task to the completed tasks list
    public void addCompletedTask(Task addedTask) {
        complete.add(addedTask);
    }

    // EFFECTS: Returns true if Task is in completed todoList
    // and false otherwise
    public boolean containsCompleteTask(Task completedTask) {
        return complete.contains(completedTask);
    }
}
