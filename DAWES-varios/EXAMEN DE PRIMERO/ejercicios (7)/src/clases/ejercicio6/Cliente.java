package ejercicio6;

public class Cliente {
    private int edad;
    private TarjetaBus tarjetaBus;

    public Cliente(int edad) {
        this.edad = edad;
        tarjetaBus = null;
    }

    public int getEdad() {
        return edad;
    }

    public void setTarjetaBus(TarjetaBus tarjetaBus) {
        this.tarjetaBus = tarjetaBus;
    }
}
