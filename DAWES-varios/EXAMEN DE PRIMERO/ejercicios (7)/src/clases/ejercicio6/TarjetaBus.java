package ejercicio6;

public class TarjetaBus {
    private Cliente cliente;
    private float saldo;        // En euros
    private float precioBase;   // En euros

    public TarjetaBus(Cliente cliente, float saldo) {
        this.precioBase = 1.50f;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void pasarTarjeta() {
        if (this.esClienteNinno()) {
            this.saldo = this.saldo - 0;
        } else if (this.esClienteJoven()) {
            this.saldo = this.saldo - 0.80f;
        } else if (this.esClienteJubilado()) {
            this.saldo = this.saldo - 0.60f;
        } else {
            this.saldo = this.saldo - this.precioBase;
        }
    }

    private boolean esClienteNinno() {
        return this.cliente.getEdad() <= 7;
    }

    private boolean esClienteJoven() {
        // return this.cliente.getEdad() > 7 && this.cliente.getEdad() <= 25;
        return this.cliente.getEdad() <= 25 && !esClienteNinno();
    }

    private boolean esClienteJubilado() {
        return this.cliente.getEdad() >= 65;
    }
}
