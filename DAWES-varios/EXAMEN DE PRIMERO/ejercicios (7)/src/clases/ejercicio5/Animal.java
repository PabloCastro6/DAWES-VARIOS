package ejercicio5;

public class Animal implements PuedeHablar {
    public void hablar() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Método no implementado");
    }

    public static String getTipo() {
        return "Animal genérico";
    }
}
