package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Tests for the CompletedTasks class
public class CompletedTasksTest {

    private CompletedTasks testCompleteSet;
    private Task t1;
    private Task t2;
    private Task t3;

    @BeforeEach
    public void setup() {
        testCompleteSet = new CompletedTasks();
        t1 = new Task("Attend Class");
        t2 = new Task("Homework");
        t3 = new Task("Yoga");
    }

    @Test
    public void addCompletedTask() {
        testCompleteSet.addCompletedTask(t1);
        testCompleteSet.addCompletedTask(t2);
        assertTrue(testCompleteSet.containsCompleteTask(t1));
        assertFalse(testCompleteSet.containsCompleteTask(t3));
    }

}
