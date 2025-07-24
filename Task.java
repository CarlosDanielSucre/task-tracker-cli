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

    public static Task fromJson(String json) {
        json = json.trim().replace("{", "").replace("}", "");
        String[] parts = json.split(",");
        int id = 0;
        String desc = "", status = "", created = "", updated = "";

        for (String part : parts) {
            String[] pair = part.split(":");
            String key = pair[0].trim().replace("\"", "");
            String value = pair[1].trim().replace("\"", "");

            switch (key) {
                case "id": id = Integer.parseInt(value); break;
                case "description": desc = value; break;
                case "status": status = value; break;
                case "createdAt": created = value; break;
                case "updatedAt": updated = value; break;
            }
        }

        return new Task(id, desc, status, created, updated);
    }

    public String toString(){
        return String.format("  {\n    \"id\":%d,\n    \"description\":\"%s\",\n    \"status\":\"%s\",\n    \"createdAt\":\"%s\",\n    \"updatedAt\":\"%s\"\n  }\n",
                this.id,
                this.description,
                this.status,
                this.createdAt,
                this.updateAt);
    }

}