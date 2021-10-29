package persistence;

import org.json.JSONObject;

// This class references code from the workroom app
// Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public interface Writable {
    // EFFECTS: returns this as a JSON object
    JSONObject toJson();
}