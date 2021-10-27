package persistence;

import model.Task;
import model.ToDoList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            ToDoList tdl = new ToDoList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
        }
    }

    @Test
    void testWriterEmptyToDo() {
        try {
            ToDoList tdl = new ToDoList();
            JsonWriter writer = new JsonWriter("./data/testReaderEmptyToDo.json");
            writer.open();
            writer.write(tdl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testReaderEmptyToDo.json");
            tdl = reader.read();
            assertEquals(0, tdl.listSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }



}
