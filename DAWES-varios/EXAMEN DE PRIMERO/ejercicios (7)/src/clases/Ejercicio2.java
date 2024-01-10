import ejercicio2.Piscina;

public class Ejercicio2 {
    public static void main(String[] args) {
        Piscina p = new Piscina(100);
        float cubo = 1.3f;
        int contador = 0;

        while (!p.estaLlena()) {
            try {
                p.echarAgua(cubo);
            } catch (Exception e) {
                System.err.println("No entra otro cubo.");
                break;
            }
            contador++;
        }
        System.out.printf("Hemos utilizado %d cubos para llenar %.2f litros.\n", contador, p.getVolumenOcupado());
    }
}
