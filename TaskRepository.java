import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;

    public class TaskRepository{
        private static LocalDateTime now = LocalDateTime.now();
        private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        private static String formattedDateTime = now.format(formatter);
        private static ArrayList<Task> tasks;
        private static Path path = Paths.get("tasks.json");
        static{
            try{
                if(Files.exists(path)){
                    tasks  = Task.fromJson(Files.readString(path));
                }else{
                    tasks = new ArrayList<>();
                }
            }catch(IOException e){
                e.printStackTrace();
                tasks = new ArrayList<>();
            }
        }


        public static void whatToDo (String[] args) {
            if(args[0].equals("add")){

            }
        }
        public static void whatToDo (String comand, int id, String description) {

        }

        public static void whatToDo (String comand, int id) {

        }

        public static void whatToDo (String comand) {

        }

        public static void whatToDo (String comand, String status) {

        }

        public static void UpdateJson() throws IOException {
            String preJson = "[";
            for(int i = 0; i < tasks.size(); i++) {
                preJson += "\n  {\n    \"id\": "+tasks.get(i).getId()+",\n" +
                        "    \"description\": \""+tasks.get(i).getDescription()+"\",\n" +
                        "    \"status\": \""+tasks.get(i).getStatus()+"\",\n" +
                        "    \"createdAt\": \""+tasks.get(i).getCreatedAt()+"\",\n" +
                        "    \"updatedAt\": \""+tasks.get(i).getUpdateAt()+"\"\n" +
                        "  }";

                if(i != tasks.size()-1){
                    preJson += ",";
                }

            }
            preJson += "\n]";
            Path path = Paths.get("tasks.json");
            Files.writeString(path, preJson);
        }


        public static void listAllTasks (Task[] tasks) {
            System.out.println("List of tasks:");
            for(int i = 0; i < tasks.length ; i++) {
            System.out.println("ID: "+tasks[i].getId()+
                               "  - Description: "+ tasks[i].getDescription() +
                               "  - Status: " + tasks[i].getStatus());
                }
        }

        public static void addTask(int id, String description) {
            boolean repeatId = false;
            for(int i = 0; i < tasks.size(); i++){
                if(tasks.get(i).getId() == id){
                    repeatId = true;
                }
            }
            if(repeatId){
                System.out.println("It's not posible to save task with the repeat Id");
            }else{
                Task newTask = new Task(id, description, "To do", formattedDateTime, formattedDateTime);
                tasks.add(newTask);
                System.out.println("Add Task");
                try{
                    UpdateJson();
                }catch (IOException e){
                    System.out.println(e);
                    System.out.println("There are problem with UptadeJson");
                }
            }
        }
        public static void updateTask(int id, String description) {

            for(int i = 0; i < tasks.size(); i++){
                if(tasks.get(i).getId() == id){
                    tasks.get(i).setDescription(description);
                }

            }
            try{
                UpdateJson();
                System.out.println("Atualized");
            }catch (IOException e){
                System.out.println(e);
                System.out.println("There are problem with UptadeJson");
            }
        }


}