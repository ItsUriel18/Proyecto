public enum TipoToken {
    IDENTIFICADOR,

    // Identificador genérico (por ejemplo, nombres de variables, tablas, columnas).
    AND, DISTINCT, FALSE, FROM, IS, NOT, NULL, OR, SELECT, TRUE, WHERE,

    COMA, SEMICOLON, DOT, LEFT_PAREN, RIGHT_PAREN,
    LT, LE, GT, GE, EQUAL, NE,
    PLUS, MINUS, STAR, SLASH,

    // Final de cadena
    EOF
}
