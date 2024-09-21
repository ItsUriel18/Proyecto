import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

// Bandera para indicar si se han encontrado errores en el código.

public class Principal {
    static boolean existenErrores = false;

// Inicia el ciclo de entrada de comandos del usuario.

    public static void main(String[] args) throws IOException {
        ejecutarPrompt();
    }

    /**
     * Método que se encarga de iniciar el prompt interactivo.
     * Solicita continuamente la entrada del usuario hasta que se presione Ctrl + D.
     * 
     * @throws IOException Si hay un error en la entrada/salida.
     */

    private static void ejecutarPrompt() throws IOException{

        // Se crean los objetos para leer la entrada desde la consola.

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        // Ciclo infinito para leer múltiples líneas de entrada.

        for(;;){
            System.out.print(">>> ");
            String linea = reader.readLine();
            if(linea == null) break;            // Si la entrada es nula (Ctrl + D), salir del ciclo.
            ejecutar(linea);
            existenErrores = false;             // Restablece la bandera de errores después de cada línea.
        }
    }

    /**
     * Método que se encarga de ejecutar una línea de código fuente proporcionada.
     * 
     * @param source La línea de código fuente a ejecutar.
     */

    private static void ejecutar(String source){
        Scanner scanner = new Scanner(source);              // Se crea un objeto Scanner para analizar la línea de código fuente.
        List<Token> tokens = scanner.scanTokens();          // Escanea los tokens de la línea de código fuente.

        for(Token token : tokens){          
            System.out.println(token);                      // Muestra los tokens escaneados.
        }
    }

    /**
     * Método para reportar un error que ocurre en una línea específica.
     * 
     * @param linea Número de línea donde ocurrió el error.
     * @param mensaje Mensaje de error que describe el problema.
     */
    
    static void error(int linea, String mensaje){
        reportar(linea, "", mensaje);       
    }
    /**
     * Método interno que formatea y muestra el error en la consola de errores (stderr).
     * 
     * @param linea Número de línea donde ocurrió el error.
     * @param donde Contexto adicional o información sobre dónde ocurrió el error.
     * @param mensaje Mensaje de error que describe el problema.
     */

    private static void reportar(int linea, String donde, String mensaje){
        System.err.println(
                "[linea " + linea + "] Error " + donde + ": " + mensaje         // Formato de salida del error en stderr.
        );
        existenErrores = true;
    }

}