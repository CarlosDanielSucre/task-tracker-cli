import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class TaskTracker {

    public static void main(String[] args) throws IOException{
        String contentJson = Files.readString(Paths.get("tasks.json"));
        System.out.println("Contenido del archivo JSON:");
        System.out.println(contentJson);

        Task task = new Task(2, "Write a book", "in progress", "18/05/2025", "18/05/2025");

        System.out.println(task.toJson(2, "Write a book", "in progress", "18/05/2025", "18/05/2025"));
    }
}