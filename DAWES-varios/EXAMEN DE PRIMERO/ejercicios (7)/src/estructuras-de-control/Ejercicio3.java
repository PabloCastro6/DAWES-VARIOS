public class Ejercicio3 {
    public static void main(String[] args) {
        float volumenPiscina = 100; // metros cúbicos
        float volumenCubo = 1.3f; // metros cúbicos
        float volumenActual = 0;
        int numeroCubos = 0;
        
        while (volumenActual < volumenPiscina) {
            if (volumenActual + volumenCubo > volumenPiscina) break; 
            volumenActual += volumenCubo;
            numeroCubos++;
        }
        
        System.out.printf("Nº de cubos: %d. Volumen actual: %.2f", numeroCubos, volumenActual);
    }    
}
