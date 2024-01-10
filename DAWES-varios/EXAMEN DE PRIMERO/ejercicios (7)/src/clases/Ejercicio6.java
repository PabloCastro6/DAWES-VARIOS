import ejercicio6.Cliente;
import ejercicio6.TarjetaBus;

public class Ejercicio6 {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(20);
        TarjetaBus tarjetaBus = new TarjetaBus(cliente, 10);
        cliente.setTarjetaBus(tarjetaBus);

        System.out.println("Nueva tarjeta con saldo: " + tarjetaBus.getSaldo());
        System.out.println("Pasando la tarjeta...");
        tarjetaBus.pasarTarjeta();
        System.out.println("Saldo actualizado: " + tarjetaBus.getSaldo());
    }
}
