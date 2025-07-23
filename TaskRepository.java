import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

    public class TaskRepository {

        // Este método declara que puede lanzar IOException.
        // Si el archivo no existe o hay un error de lectura, el programa fallará aquí.
        public static String readTasksJsonContent(){
            String fileName = "tasks.json";
            StringBuilder jsonContent = new StringBuilder();

            // El 'try-with-resources' sigue siendo la forma más limpia de abrir y asegurar
            // que el lector se cierre, incluso si hay una excepción.
            // La excepción no se captura aquí, sino que se propaga.
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Eliminamos espacios al inicio y final de cada línea.
                    jsonContent.append(line.trim());
                }
            }
            // No hay bloque catch aquí. Si FileReader o BufferedReader lanzan una IOException,
            // el método terminará inmediatamente y lanzará esa misma IOException.

            String jsonString = jsonContent.toString();
            // Opcional: imprimir el contenido. Podrías quitar esta línea si solo quieres el retorno.
            System.out.println("Contenido del JSON (como String): " + jsonString);

            return jsonString; // Devolvemos la cadena JSON construida

    }
}