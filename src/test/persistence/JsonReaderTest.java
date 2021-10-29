package persistence;

import model.Task;
import model.ToDoList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ToDoList wr = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyToDo() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyToDo.json");
        try {
            ToDoList tdl = reader.read();

            assertEquals(0, tdl.listSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }



        @Test
    void testReaderNormalToDo() {
        JsonReader reader = new JsonReader("./data/testReaderNormalToDo.json");
        try {
            ToDoList tdl = reader.read();
            List<Task> tasks = tdl.getTasks();
            assertEquals(2, tasks.size());
            checkTasks("Get food", tasks.get(0));
            checkTasks("Do homework", tasks.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }


}
