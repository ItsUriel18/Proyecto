/*Falta lógica de análisis en Scanner.java:

La clase Scanner.java tiene una estructura inicial, pero la lógica que realmente procesa el texto y convierte los caracteres en tokens (como identificadores, números, operadores, etc.) 
no está implementada. Solo agrega un token EOF al final de la entrada.
Deberías implementar la lógica para reconocer diferentes tipos de tokens. Por ejemplo, deberías manejar el reconocimiento de números, palabras clave, identificadores, operadores, símbolos, etc.
Necesidad de manejo de estados en el escaneo:

Un analizador léxico necesita un autómata finito o manejo de estados para identificar correctamente los tokens. El código de Scanner.java debería tener una estructura que 

cambie entre estados dependiendo del carácter que se está procesando.
Por ejemplo, si el carácter actual es una letra, se debería construir un identificador o palabra clave. Si es un dígito, se debería construir un número, y así sucesivamente.
Manejo de errores en el escaneo:

El manejo de errores en el análisis léxico es crucial. En el archivo Principal.java tienes una estructura para reportar errores, pero el Scanner.java 
también debería tener lógica para detectar tokens inválidos y reportar estos errores.
Comentarios y espacios en blanco:

Necesitarás manejar comentarios y espacios en blanco. Estos no se convierten en tokens, pero deben ser ignorados por el analizador léxico.*/


// Ejemplo básico de lógica en el método scanTokens
for(int i = 0; i < source.length(); i++) {
    char c = source.charAt(i);
    
    switch(c) {
        case '(': 
            tokens.add(new Token(TipoToken.LEFT_PAREN, "(", linea));
            break;
        case ')': 
            tokens.add(new Token(TipoToken.RIGHT_PAREN, ")", linea));
            break;
        case '+': 
            tokens.add(new Token(TipoToken.PLUS, "+", linea));
            break;
        // Manejo de más símbolos, identificadores, números, etc.
    }
}


// Para un identificador o palabra clave
if (Character.isLetter(c)) {
    lexema += c;
    // Continua hasta que ya no sea letra o número
    while (Character.isLetterOrDigit(peek())) {
        lexema += advance();
    }
    // Verifica si es una palabra reservada
    TipoToken tipo = palabrasReservadas.getOrDefault(lexema, TipoToken.IDENTIFICADOR);
    tokens.add(new Token(tipo, lexema, linea));
}
