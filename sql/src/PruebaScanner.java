public class PruebaScanner {
    public static void main(String[] args) {
        String codigoPrueba = "select * from tabla where columna = 5 and columna2 != 'cadena';";
        
        // Instanciamos el scanner con el código de prueba
        Scanner scanner = new Scanner(codigoPrueba);
        
        // Obtenemos la lista de tokens
        List<Token> tokens = scanner.scanTokens();
        
        // Mostramos los tokens generados
        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}

