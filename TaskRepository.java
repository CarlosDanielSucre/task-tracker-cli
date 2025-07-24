import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

    public class TaskRepository {

        public static Task[] fromJson(String json) {
            json = json.trim()
                    .replace("[", "")
                    .replace("]", "")
                    .replace("},", "}|"); // separador de tareas

            String[] taskStrings = json.split("\\|");
            Task[] tasks = new Task[taskStrings.length];

            for (int i = 0; i < taskStrings.length; i++) {
                String taskStr = taskStrings[i]
                        .replace("{", "")
                        .replace("}", "")
                        .replace("\"", "")
                        .trim();

                String[] fields = taskStr.split(",");
                int id = 0;
                String description = "", status = "", createdAt = "", updatedAt = "";

                for (String field : fields) {
                    String[] pair = field.split(":", 2);
                    String key = pair[0].trim();
                    String value = pair[1].trim();

                    switch (key) {
                        case "id": id = Integer.parseInt(value); break;
                        case "description": description = value; break;
                        case "status": status = value; break;
                        case "createdAt": createdAt = value; break;
                        case "updatedAt": updatedAt = value; break;
                    }
                }

                tasks[i] = new Task(id, description, status, createdAt, updatedAt);
            }

            return tasks;
        }
}