import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    // Almacena el código fuente que se va a analizar.

public class Scanner {
    private final String source;

    // Lista de tokens que se generarán al analizar el código fuente.

    private final List<Token> tokens = new ArrayList<>();

    // Tabla de palabras reservadas (palabras clave) y su tipo asociado.

    private static final Map<String, TipoToken> palabrasReservadas;

    // Bloque estático para inicializar el mapa de palabras reservadas.

    static {
        palabrasReservadas = new HashMap<>();        // Asociación de palabras reservadas del lenguaje con su tipo de token correspondiente.

        palabrasReservadas.put("and", TipoToken.AND);
        palabrasReservadas.put("distinct", TipoToken.DISTINCT);
        palabrasReservadas.put("false", TipoToken.FALSE);
        palabrasReservadas.put("from", TipoToken.FROM);
        palabrasReservadas.put("is", TipoToken.IS);
        palabrasReservadas.put("not", TipoToken.NOT);
        palabrasReservadas.put("null", TipoToken.NULL);
        palabrasReservadas.put("or", TipoToken.OR);
        palabrasReservadas.put("select", TipoToken.SELECT);
        palabrasReservadas.put("true", TipoToken.TRUE);
        palabrasReservadas.put("where", TipoToken.WHERE);

    }

        /**
     * Constructor de la clase Scanner.
     * 
     * @param source Código fuente que será analizado.
     */

    Scanner(String source){
        this.source = source + " ";          // Se añade un espacio extra al final del código fuente para facilitar el análisis.
    }

       /**
     * Método que escanea el código fuente y devuelve una lista de tokens.
     * 
     * @return Lista de tokens generados al analizar el código fuente.
     */

    List<Token> scanTokens(){

        // Variables locales para el análisis.

        int estado = 0;         // Estado actual del autómata o análisis.
        char caracter = 0;      // Caracter actual leído del código fuente.
        String lexema = "";     // Lexema actual que se está construyendo.
        int inicioLexema = 0;   // Índice de inicio del lexema en el código fuente.

        // Ciclo que recorre cada caracter del código fuente.

        for(int i=0; i<source.length(); i++){
            caracter = source.charAt(i);

                    // Lógica de escaneo y manejo de estados faltaría aquí.

        }
        tokens.add(new Token(TipoToken.EOF, "", source.length()));          // Al final del análisis, se añade un token especial para indicar el final del archivo (EOF).

        return tokens;    // Retorna la lista de tokens generados.
    }

}
