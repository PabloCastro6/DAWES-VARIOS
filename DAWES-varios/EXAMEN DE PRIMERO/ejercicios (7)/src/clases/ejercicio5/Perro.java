package ejercicio5;

public class Perro extends Animal {
    @Override
    public void hablar() {
        System.out.println("Guau...");
    }
    
    public static boolean esFelino() {
        return false;
    }
    
    public static String getTipo() {
        return "Perro";
    }
}
