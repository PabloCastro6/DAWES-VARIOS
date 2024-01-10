package ejercicio4;

import java.util.ArrayList;

public class Clase {
    private ArrayList<Alumno> alumnos;

    public Clase(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos != null ? alumnos : new ArrayList<>();
    }

    public int getTotalAlumnos() {
        return this.alumnos.size();
    }

    public float getMediaEdad() {
        float edadTotal = 0f;
        for (int i = 0; i < alumnos.size(); i++) {
            Alumno alumno = this.alumnos.get(i);
            edadTotal = edadTotal + alumno.getEdad();
        }
        return edadTotal / this.alumnos.size();
    }

    public float getMediaEstatura() {
        float estaturaTotal = 0f;
        for (Alumno alumno : this.alumnos) {
            estaturaTotal = estaturaTotal + alumno.getEstatura();
        }
        return estaturaTotal / this.alumnos.size();
    }
}
