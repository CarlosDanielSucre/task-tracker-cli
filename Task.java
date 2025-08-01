import java.nio.file.StandardOpenOption;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.util.ArrayList;

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
    public void setDescription (String newDescription) {
        this.description = newDescription;
    }
    public void setUpdateAt (String newDate) {
        this.updateAt = newDate;
    }
    public void setStatus (String status) {
        this.status = status;
    }

    public Task(int id, String description, String status, String createdAt, String updateAt) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public void addTask(String taskJson) throws IOException {
        Files.writeString(Paths.get("tasks.json"),taskJson, StandardOpenOption.APPEND);
    }


    public String toString(){
        return String.format("  {\n    \"id\":%d,\n    \"description\":\"%s\",\n    \"status\":\"%s\",\n    \"createdAt\":\"%s\",\n    \"updatedAt\":\"%s\"\n  }\n",
                this.id,
                this.description,
                this.status,
                this.createdAt,
                this.updateAt);
    }

    public static ArrayList<Task> fromJson(String json) {
        ArrayList<Task> tasks = new ArrayList<>();

        if (json == null || json.trim().isEmpty() || "{}".equals(json.trim()) || "[]".equals(json.trim())) {
            System.out.println("Input JSON is blank or empty, returning empty task list.");
            return tasks;
        }else{
            try {
                json = json.trim()
                        .replace("[", "")
                        .replace("]", "")
                        .replace("},", "}|");

                String[] taskStrings = json.split("\\|");
                for (String taskStr : taskStrings) {
                    taskStr = taskStr
                            .replace("{", "")
                            .replace("}", "")
                            .replace("\"", "")
                            .trim();

                    if (taskStr.isEmpty()) continue;

                    String[] fields = taskStr.split(",");
                    int id = 0;
                    String description = "", status = "", createdAt = "", updatedAt = "";
                    for (String field : fields) {
                        field = field.trim();

                        if (field.isEmpty() || !field.contains(":")) {
                            System.err.println("Skipping malformed field: '" + field + "'");
                            continue;
                        }

                        String[] pair = field.split(":", 2);

                        if (pair.length < 2) {
                            System.err.println("Skipping invalid key-value: '" + field + "'");
                            continue;
                        }

                        String key = pair[0].trim();
                        String value = pair[1].trim();

                        switch (key) {
                            case "id" -> id = Integer.parseInt(value);
                            case "description" -> description = value;
                            case "status" -> status = value;
                            case "createdAt" -> createdAt = value;
                            case "updatedAt" -> updatedAt = value;
                            default -> System.out.println("Unknown key: " + key);
                        }
                    }

                    tasks.add(new Task(id, description, status, createdAt, updatedAt));
                }

            } catch (Exception e) {
                System.err.println("Error parsing JSON: " + e.getMessage());
                e.printStackTrace();
            }
            return tasks;

        }


    }




}