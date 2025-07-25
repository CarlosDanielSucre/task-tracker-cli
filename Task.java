import java.nio.file.StandardOpenOption;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class Task{
    private int id;
    private String description;
    private String status;
    private String createdAt;
    private String updateAt;

    public int getId () {
        return this.id;
    }
    public String getDescription () {
        return this.description;
    }
    public String getStatus () {
        return this.status;
    }
    public String getCreatedAt () {
        return this.createdAt;
    }
    public String getUpdateAt () {
        return this.updateAt;
    }

    public Task(int id, String description, String status, String createdAt, String updateAt) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public String toJson() {
        return String.format("  {\n    \"id\":%d,\n    \"description\":\"%s\",\n    \"status\":\"%s\",\n    \"createdAt\":\"%s\",\n    \"updatedAt\":\"%s\"\n  }\n", this.id,
        this.description,
        this.status,
        this.createdAt,
        this.updateAt);
    }

    public void addTask(String taskJson) throws IOException {
        Files.writeString(Paths.get("tasks.json"),taskJson, StandardOpenOption.APPEND);
    }
    public static String[] toJson (Task[] task){
        String[] tasksStrings = null;
        for(int i = 0; i < task.length ; i++){
            tasksStrings[i] = task[i].toString();
        }
        return tasksStrings;
    }



    public String toString(){
        return String.format("  {\n    \"id\":%d,\n    \"description\":\"%s\",\n    \"status\":\"%s\",\n    \"createdAt\":\"%s\",\n    \"updatedAt\":\"%s\"\n  }\n",
                this.id,
                this.description,
                this.status,
                this.createdAt,
                this.updateAt);
    }

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