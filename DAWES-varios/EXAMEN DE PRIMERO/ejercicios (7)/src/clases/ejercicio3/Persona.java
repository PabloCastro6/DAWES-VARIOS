package ejercicio3;

import java.util.ArrayList;

public class Persona {
    private String nombre;
    private int edad;

    private Persona[] padres;
    private ArrayList<Persona> hermanos;
    private ArrayList<Persona> hijos;

    public Persona(String nombre, int edad, Persona padre1, Persona padre2) {
        this.nombre = nombre;
        this.edad = edad;
        this.padres = new Persona[2];
        this.hermanos = new ArrayList<>();
        this.hijos = new ArrayList<>();
        this.padres[0] = padre1;
        this.padres[1] = padre2;
        if (padre1 != null) {
            padre1.anadirHijo(this);
        }
        if (padre2 != null) {
            padre2.anadirHijo(this);
        }
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    private void anadirHermano(Persona hermano) {
        if (!this.hermanos.contains(hermano)) {
            this.hermanos.add(hermano);
            hermano.anadirHermano(this);
        }
    }

    public int getNumeroHermanos() {
        return this.hermanos.size();
    }

    private void anadirHijo(Persona hijo) {
        for (Persona persona : this.hijos) {
            persona.anadirHermano(hijo);
            // hijo.anadirHermano(persona);
        }
        this.hijos.add(hijo);
    }

    public int getNumeroHijos() {
        return this.hijos.size();
    }

    public boolean esHijoUnico() {
        return this.getNumeroHermanos() == 0;
    }
}
