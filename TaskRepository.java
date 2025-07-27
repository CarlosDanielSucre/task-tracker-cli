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


    public static void whatToDo (String[] args) throws IOException {
        if(args[0].equals("add")){
            if(args.length > 2){
                System.out.println("To add a task, you can include only a description. Please use the format: java TaskCLI add \"description\"");
            }else{
                addTask(args[1]);
            }
        }
        if(args[0].equals("update")){
            if(args.length > 3){
                System.out.println("To update a task, you can include only a description. Please use the format: java TaskCLI update <ID> \"description\"");
            }else{
                try{
                    int id = Integer.parseInt(args[1]);
                    updateTask(id,args[2]);
                }catch (NumberFormatException  e){
                    System.out.println(e);
                    System.out.println("Invalid ID: not a number");
                }

            }
        }
        if(args[0].equals("delete")) {
            if (args.length > 2) {
                System.out.println("To delete a task, you must type only an id. Please use the format: java TaskCLI delete <ID>");
            } else {
                try {
                    int id = Integer.parseInt(args[1]);
                    deleteTask(id);
                } catch (NumberFormatException e) {
                    System.out.println(e);
                    System.out.println("Invalid ID: not a number");
                }
            }
        }
        if(args[0].equals("mark-in-progress")){
            if (args.length > 2) {
                System.out.println("To mark in progress a task, you must type only an id. Please use the format: java TaskCLI mark-in-progress <ID>");
            }else{
                try {
                    int id = Integer.parseInt(args[1]);
                    markInProgress(id);
                } catch (NumberFormatException e) {
                    System.out.println(e);
                    System.out.println("Invalid ID: not a number");
                }
            }
        }
        if(args[0].equals("mark-done")){
            if (args.length > 2) {
                System.out.println("To mark done a task, you must type only an id. Please use the format: java TaskCLI mark-done <ID>");
            }else{
                try {
                    int id = Integer.parseInt(args[1]);
                    markDone(id);
                } catch (NumberFormatException e) {
                    System.out.println(e);
                    System.out.println("Invalid ID: not a number");
                }
            }
        }
        if(args[0].equals("list")){
            if (args.length > 1) {
                System.out.println("To show the list of task, you must type only list comand. Please use the format: java TaskCLI list");
            }else{
                listAllTasks();
            }
        }
        if(args[0].equals("help")){
            showHelp();
        }
    }
     //
     //
     //
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


    public static void listAllTasks () {
        System.out.println("List of tasks:");
        System.out.println("--------------");
        for(int i = 0; i < tasks.size() ; i++) {
            System.out.println(
                    "ID: " + tasks.get(i).getId() + "\n" +
                            "  - Description: " + tasks.get(i).getDescription() + "\n" +
                            "  - Status: " + tasks.get(i).getStatus() + "\n" +
                            "  - Created: " + tasks.get(i).getCreatedAt() + "\n" +
                            "  - Updated: " + tasks.get(i).getUpdateAt() + "\n" +
                            "------"
            );
            System.out.println();
        }
    }
    public static int increasedId(){
        return tasks.get(tasks.size()-1).getId() + 1;
    }

    public static void addTask(String description) {

        Task newTask = new Task(increasedId(), description, "To do", formattedDateTime, formattedDateTime);
        tasks.add(newTask);
        System.out.println("Add Task");
        try{
            UpdateJson();
        }catch (IOException e){
            System.out.println(e);
            System.out.println("There are problem with UptadeJson");
        }

    }
    public static void updateTask(int id, String description) {

        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getId() == id){
                tasks.get(i).setDescription(description);
                tasks.get(i).setUpdateAt(formattedDateTime);
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
    public static void deleteTask(int id) {
        boolean remove = false;
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getId() == id){
                tasks.remove(i);
                remove = true;
            }

        }
        try{
            UpdateJson();
            System.out.println("Removed");
        }catch (IOException e){
            System.out.println(e);
            System.out.println("There are problem with UptadeJson");
        }
        if(!remove){
            System.out.println("Invalid ID");

        }
    }

    public static void markInProgress(int id){
        boolean marked = false;
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getId() == id){
                tasks.get(i).setStatus("in-progress");
                marked = true;
            }

        }
        try{
            UpdateJson();
            System.out.println("status updated");
        }catch (IOException e){
            System.out.println(e);
            System.out.println("There are problem with UptadeJson");
        }
        if(!marked){
            System.out.println("Invalid ID");
        }
    }

    public static void markDone(int id){
        boolean marked = false;
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getId() == id){
                tasks.get(i).setStatus("done");
                marked = true;
            }

        }
        try{
            UpdateJson();
            System.out.println("status updated");
        }catch (IOException e){
            System.out.println(e);
            System.out.println("There are problem with UptadeJson");
        }
        if(!marked){
            System.out.println("Invalid ID");
        }
    }

    public static void showHelp(){
        System.out.println("""

Task Tracker CLI - Usage Guide 
------------------------------

    Commands:
  add "<description>"             Add a new task
  update <id> "<new description>" Update an existing task
  delete <id>                     Delete a task
  mark-in-progress <id>          Mark a task as in progress
  mark-done <id>                 Mark a task as done
  list                           List all tasks
  list todo                      List tasks with status "todo"
  list in-progress               List tasks with status "in-progress"
  list done                      List tasks with status "done"
  help                           Show this help message

Examples:
  java TaskCLI add "Buy groceries"
  java TaskCLI update 1 "Buy groceries and cook dinner"
  java TaskCLI delete 1
  java TaskCLI mark-done 2
  java TaskCLI list in-progress
""");
    }


}