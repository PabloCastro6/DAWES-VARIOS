public class Ejercicio1 {
    public static void main(String[] args) {
        int km = 250;
        int personas = 1;
        int precioCentimos = 2000 * personas; // 20€ * 100cent/€ = 2000cent
        
        if (km > 200) {
            precioCentimos += 3 * (km - 200);
        }
        if (km > 400) {
            precioCentimos -= precioCentimos * 15 / 100;
        }
        if (personas >= 3) {
            precioCentimos -= precioCentimos * 10 / 100;
        }
        System.out.println("Precio del viaje: " + ((precioCentimos / personas) / 100.0) + "€");
    }    
}