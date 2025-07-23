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

}