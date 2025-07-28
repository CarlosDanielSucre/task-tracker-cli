import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.ArrayList;

public class TaskTracker {

    public static void main(String[] args) throws IOException  {


        Path path = Paths.get("tasks.json");


        TaskRepository.whatToDo(args);
    }
}