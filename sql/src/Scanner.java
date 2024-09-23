import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scanner {
    private final String source;

    private final List<Token> tokens = new ArrayList<>();

    private static final Map<String, TipoToken> palabrasReservadas;
    static {
        palabrasReservadas = new HashMap<>();

        palabrasReservadas.put("and", TipoToken.AND);
        palabrasReservadas.put("or", TipoToken.OR);
        palabrasReservadas.put("select", TipoToken.SELECT);
        palabrasReservadas.put("from", TipoToken.FROM);
        palabrasReservadas.put("where", TipoToken.WHERE);
        palabrasReservadas.put("distinct", TipoToken.DISTINCT);
        palabrasReservadas.put("false", TipoToken.FALSE);
        palabrasReservadas.put("is", TipoToken.IS);
        palabrasReservadas.put("not", TipoToken.NOT);
        palabrasReservadas.put("null", TipoToken.NULL);
        palabrasReservadas.put("true", TipoToken.TRUE);

    }


 Scanner(String source) {
    this.source = source + " ";  // Añadimos un espacio adicional al final
}

// Método principal para escanear y generar tokens
public List<Token> scanTokens() {
    String lexema = "";  // El lexema que vamos a construir
    char caracter;
    for (int i = 0; i < source.length(); i++) {
        caracter = source.charAt(i);

        // Ignoramos espacios en blanco y saltos de línea
        if (caracter == ' ' || caracter == '\n' || caracter == '\t') {
            continue;
        }

        // Detectamos letras iniciales para palabras reservadas o identificadores
        if (Character.isLetter(caracter)) {
            lexema += caracter;

            // Seguimos escaneando mientras haya letras (construyendo el lexema)
            while (i + 1 < source.length() && Character.isLetter(source.charAt(i + 1))) {
                i++;
                lexema += source.charAt(i);
            }

            // Verificamos si el lexema es una palabra reservada
            TipoToken tipo = palabrasReservadas.get(lexema);
            if (tipo != null) {
                // Si es una palabra reservada, generamos el token correspondiente
                tokens.add(new Token(tipo, lexema));
            } else {
                // Si no es una palabra reservada, será un identificador
                tokens.add(new Token(TipoToken.IDENTIFICADOR, lexema));
            }

            // Reiniciamos el lexema para el siguiente ciclo
            lexema = "";
        }
        // Detectar números
        else if (Character.isDigit(caracter)) {
            // Detectamos un número, seguimos avanzando mientras haya dígitos
            while (i < source.length() && Character.isDigit(source.charAt(i))) {
                lexema += source.charAt(i);
                i++;
            }
            i--;  // Ajustamos el índice porque el último carácter ya no era un dígito
            tokens.add(new Token(TipoToken.NUMERO, lexema));
            lexema = "";
        }
        // Detectar cadenas entre comillas dobles
        else if (caracter == '"') {
            i++;  // Saltar la primera comilla
            // Leer hasta que se encuentre la siguiente comilla
            while (i < source.length() && source.charAt(i) != '"') {
                lexema += source.charAt(i);
                i++;
            }
            tokens.add(new Token(TipoToken.CADENA, lexema));  // Guardamos la cadena sin las comillas
            lexema = "";
        }
    }

    // Al final añadimos el token EOF
    tokens.add(new Token(TipoToken.EOF, "", source.length()));

    return tokens;
}
}
