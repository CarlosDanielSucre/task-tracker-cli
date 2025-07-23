import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class TaskTracker {

    public static void main(String[] args) throws IOException{
        String contentJson = Files.readString(Paths.get("tasks.json"));
        String[] task1 = TaskRepository.fromJson(contentJson);
        System.out.println(Arrays.toString(task1));
        System.out.println(task1[0]);
        System.out.println(task1[1]);

        Task task = new Task(2, "Write a book", "in progress", "18/05/2025", "18/05/2025");





    }
}