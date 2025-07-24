import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class TaskTracker {

    public static void main(String[] args) throws IOException{
        String contentJson = Files.readString(Paths.get("tasks.json"));
        Task[] task = TaskRepository.fromJson(contentJson);
        String[] tarefas = Task.toJson(task);
        System.out.println(tarefas[0]);





    }
}