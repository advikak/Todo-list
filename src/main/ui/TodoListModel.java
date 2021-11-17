package ui;

import model.Task;
import model.ToDoList;

import javax.swing.*;

public class TodoListModel extends AbstractListModel {

    private ToDoList list;

    public TodoListModel(ToDoList list) {
        this.list = list;
    }

    public void addElement(Task element) {
        int index = list.listSize();
        list.addTask(element);
        fireIntervalAdded(this, index, index);
    }

    public Task remove(int index) {
        Task rv = list.getSpecificTask(index);
        list.removeIndexTask(index);
        fireIntervalRemoved(this, index, index);
        return rv;
    }

    @Override
    public int getSize() {
        return list.listSize();
    }

    @Override
    public Task getElementAt(int index) {
        return list.getSpecificTask(index);
    }

}
