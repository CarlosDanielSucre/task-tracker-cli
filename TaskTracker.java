import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TaskTracker{

    public static void main(String[] args) {
        TaskRepository.readTasksJsonContent();

            // Esto es EXTREMADAMENTE FRÁGIL y solo funciona para casos MUY específicos
            // NO ES UN PARSER JSON GENÉRICO
           /* if (jsonString.contains("\"clave1\":")) {
                int startIndex = jsonString.indexOf("\"clave1\":") + "\"clave1\":".length();
                // Buscar el inicio y fin del valor de la clave1
                int valueStartIndex = -1;
                int valueEndIndex = -1;

                // Encontrar el primer '"' después de la clave1
                for (int i = startIndex; i < jsonString.length(); i++) {
                    if (jsonString.charAt(i) == '"') {
                        valueStartIndex = i + 1; // El valor real empieza después de la comilla
                        break;
                    }
                }

                // Encontrar el siguiente '"' para cerrar el string
                if (valueStartIndex != -1) {
                    for (int i = valueStartIndex; i < jsonString.length(); i++) {
                        if (jsonString.charAt(i) == '"' && jsonString.charAt(i - 1) != '\\') { // Cuidado con comillas escapadas
                            valueEndIndex = i;
                            break;
                        }
                    }
                }

                if (valueStartIndex != -1 && valueEndIndex != -1) {
                    String valorClave1 = jsonString.substring(valueStartIndex, valueEndIndex);
                    System.out.println("Valor de clave1 (extraído manualmente): " + valorClave1);
                } else {
                    System.out.println("No se pudo extraer el valor de clave1.");
                }
            }


        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }*/
    }
}