package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest {

    private ToDoList testSet;
    private Task t1;
    private Task t2;

    @BeforeEach
    public void setup() {
        testSet = new ToDoList();
        t1 = new Task("Attend Class");
        t2 = new Task("Homework");
    }

    @Test
    public void testAddTask(){
        testSet.addTask(t1);
        testSet.addTask(t2);

        assertTrue(testSet.contains(t1));
        assertTrue(testSet.contains(t2));
        assertEquals(2, testSet.listSize());
    }

}