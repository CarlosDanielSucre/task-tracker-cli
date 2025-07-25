import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class TaskTracker {

    public static void main(String[] args) throws IOException{
        String contentJson = Files.readString(Paths.get("tasks.json"));
        Task[] task = Task.fromJson(contentJson);
        String tarefas = task.toString();
        System.out.println(task[1].getDescription());

        TaskRepository.listAllTasks(task);





    }
}