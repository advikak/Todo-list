package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.json.JSONObject;

import static org.junit.jupiter.api.Assertions.*;

// Tests for the Task class
class TaskTest {

    private Task testTask;

    @BeforeEach
    public void setup() {
        testTask = new Task("Go grocery shopping");
    }

    @Test
    public void testToString() {
        assertTrue(testTask.toString() == "Go grocery shopping");
    }

    @Test
    public void testConstructor() {
        assertEquals("Go grocery shopping", testTask.getTaskDescription());
    }

    @Test
    public void testToJson() {
        assertEquals("{\"name\":\"Go grocery shopping\"}", JSONObject.valueToString(testTask.toJson()));
    }


}
