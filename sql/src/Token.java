public class Token {        

    final TipoToken tipo;         // Tipo de token (identificador, palabra clave, operador, etc.).
    final String lexema;         // El lexema asociado al token (la representación textual del token en el código fuente).
    final int linea;             // Número de línea en la que aparece el token en el código fuente.

    /**
     * Constructor de la clase Token.
     * 
     * @param tipo   El tipo de token (de la clase TipoToken).
     * @param lexema El valor del lexema que se ha encontrado.
     * @param linea  El número de línea en la que aparece el token.
     */

    public Token(TipoToken tipo, String lexema, int linea) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.linea = linea;
    }

    /**
     * Sobrecarga del constructor de Token.
     * Se usa cuando no se necesita especificar la línea.
     * Por defecto, el número de línea se asigna a 0.
     * 
     * @param tipo   El tipo de token.
     * @param lexema El lexema asociado al token.
     */

    public Token(TipoToken tipo, String lexema) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.linea = 0;             // Línea por defecto cuando no se especifica.
    }

    /**
     * Método toString que devuelve una representación textual del token.
     * Esta representación incluye el tipo de token y el lexema.
     * 
     * @return Cadena de texto que representa el token en el formato: "tipo lexema".
     */

    public String toString(){
        return tipo + " " + lexema + " ";
    }
}
