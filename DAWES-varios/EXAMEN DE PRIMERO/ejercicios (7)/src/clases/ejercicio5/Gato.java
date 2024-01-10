package ejercicio5;

public class Gato extends Animal {
    @Override
    public void hablar() {
        System.out.println("Miau...");
    }

    public static boolean esFelino() {
        return true;
    }
    
    public static String getTipo() {
        return "Gato";
    }
}
