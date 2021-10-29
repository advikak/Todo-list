package persistence;

import model.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;

// for checking tasks for tests
public class JsonTest {
    protected void checkTasks(String description, Task t1) {
        assertEquals(description, t1.getTaskDescription());
    }
}
