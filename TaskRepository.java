import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

    public class TaskRepository {

    public static void listAllTasks (Task[] tasks) {
        System.out.println("List of tasks:");
        for(int i = 0; i < tasks.length ; i++) {
            System.out.println("ID: "+tasks[i].getId()+
                               "  - Description: "+ tasks[i].getDescription() +
                               "  - Status: " + tasks[i].getStatus());
        }
    }


}