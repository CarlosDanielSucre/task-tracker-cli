import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

    public class TaskRepository {

        public static String[] fromJson(String json) {
            json = json.trim().replace(" ", "");
            String[][] parts = json.split("}");
            String[] pair = json.split(",");;
            int id = 0;
            String desc = "", status = "", created = "", updated = "";
            String[] pair = json.split(",");;
            for (String part : parts) {
                pair = part.split(":");

              /*  switch (key) {
                    case "id": id = Integer.parseInt(value); break;
                    case "description": desc = value; break;
                    case "status": status = value; break;
                    case "createdAt": created = value; break;
                    case "updatedAt": updated = value; break;
                }*/
            }

           // return new Task(id, desc, status, created, updated);
            return parts;
        }
}