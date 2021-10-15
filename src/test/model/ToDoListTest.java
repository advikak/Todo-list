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
        t2 = new Task("Homework");
        t3 = new Task("Yoga");
    }

    @Test
    public void testAddMultipleTasks(){
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
        assertFalse(testSet.contains(t2));
        assertEquals(1, testSet.listSize());
    }

    @Test
    public void testGetSpecificTask() {
        testSet.addTask(t3);
        testSet.addTask(t1);
        testSet.addTask(t2);
        assertTrue(testSet.getSpecificTask(0).getTaskDescription() == "Yoga");
        assertTrue(testSet.getSpecificTask(1).getTaskDescription() == "Attend Class");
        assertTrue(testSet.getSpecificTask(2).getTaskDescription() == "Homework");
    }

    @Test
    public void testListSize() {
        assertEquals(0, testSet.listSize());
    }

    @Test
    public void testContains() {
        testSet.addTask(t1);
        testSet.addTask(t2);
        assertFalse(testSet.contains(t3));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(testSet.isEmpty());
    }

    @Test
    public void testIsNotEmpty() {
        testSet.addTask(t1);
        assertFalse(testSet.isEmpty());
    }

}