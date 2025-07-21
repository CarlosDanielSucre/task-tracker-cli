import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
public class TaskRepository {


    public static String readTasksJsonContent(){
        String fileName = "tasks.json";
        StringBuilder jsonContent = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = reader.readLine()) != null){
                jsonContent.append(line.trim()); // Delete space in the init and final of line
            }
            String jsonString =  jsonContent.toString();
            System.out.println("Contenido del JSON (como String): " + jsonString);
        }
        catch (FileNotFoundException e) {
        System.out.println("Arquivo não encontrado: " + e.getMessage());
        // talvez criar o arquivo vazio aqui
    } catch (IOException e) {
        System.out.println("Erro ao ler o arquivo: " + e.getMessage());
    }

        return "";

    }
}