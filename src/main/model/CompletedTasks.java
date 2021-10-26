package model;

import java.util.ArrayList;

// Arraylist to show completed tasks from a todolist
public class CompletedTasks {

    private ArrayList<Task> complete;

    // EFFECTS: completed tasks set is empty
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

    // EFFECTS: Returns the number of items in the todolist
    public int completedListSize() {
        return complete.size();
    }

    // EFFECTS: Returns the task in completed tasks list at index i
    public Task getSpecificTask(int i) {
        return complete.get(i);
    }

    //EFFECTS: Returns true if todolist is empty, false otherwise
    public boolean completeIsEmpty() {
        return (complete.size() == 0);
    }
}
