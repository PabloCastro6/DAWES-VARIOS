package ejercicio2;

public class Piscina {
    private float capacidad;
    private float volumenOcupado;

    public Piscina(float capacidad) {
        super();
        this.capacidad = capacidad;
        this.volumenOcupado = 0f;
    }

    

    public void echarAgua(float volumenAgua) throws Exception {
        if (this.volumenOcupado + volumenAgua > this.capacidad) {
            throw new Exception("Piscina desbordada " + (this.volumenOcupado + volumenAgua - this.capacidad) + " litros.");
        }
        this.volumenOcupado = this.volumenOcupado + volumenAgua;
    }

    public void sacarAgua(float volumenAgua) throws Exception {
        if (this.volumenOcupado - volumenAgua < 0) {
            throw new Exception("Volumen insuficiente de agua restante.");
        }
        this.volumenOcupado = this.volumenOcupado - volumenAgua;
    }

    public boolean estaLlena() {
        return this.volumenOcupado == this.capacidad;
    }

    public boolean estaVacia() {
        return this.volumenOcupado == 0f;
    }



    public float getCapacidad() {
        return capacidad;
    }



    public float getVolumenOcupado() {
        return volumenOcupado;
    }

}
