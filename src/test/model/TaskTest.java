package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Tests for the Task class
class TaskTest {

    private Task testTask;

    @BeforeEach
    public void setup() {
        testTask = new Task("Go grocery shopping");
    }

    @Test
    public void testConstructor() {
        assertEquals("Go grocery shopping", testTask.getTaskDescription());
    }

    @Test
    public void testCompletenessOfNewTask() {
        assertFalse(testTask.isComplete());
    }

    @Test
    public void testCompleteTask() {
        assertTrue(testTask.setComplete());
    }

}
