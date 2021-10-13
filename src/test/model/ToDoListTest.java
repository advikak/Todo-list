package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Tests for the ToDoList class
class ToDoListTest {

    private ToDoList testSet;
    private Task t1;
    private Task t2;
    private Task t3;

    @BeforeEach
    public void setup() {
        testSet = new ToDoList();
        t1 = new Task("Attend Class");
    }

    @Test
    public void testAddMultipleTasks(){

        t2 = new Task("Homework");
        t3 = new Task("Yoga");

        testSet.addTask(t1);
        testSet.addTask(t2);

        assertTrue(testSet.contains(t1));
        assertTrue(testSet.contains(t2));
        assertFalse(testSet.contains(t3));
        assertEquals(2, testSet.listSize());
    }

    @Test
    public void testAddOneTask(){


        testSet.addTask(t1);
        assertTrue(testSet.contains(t1));

        assertEquals(1, testSet.listSize());
    }

    @Test
    public void testAddNoTasks(){

        assertFalse(testSet.contains(t1));
        assertEquals(0, testSet.listSize());
    }


}