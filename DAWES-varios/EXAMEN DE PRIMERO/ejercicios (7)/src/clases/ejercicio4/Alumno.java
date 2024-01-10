package ejercicio4;

public class Alumno {
    private String nombre;
    private int edad;
    private int estatura; // En centímetros

    public Alumno(String nombre, int edad, int estatura) {
        this.nombre = nombre;
        this.edad = edad;
        this.estatura = estatura;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getEstatura() {
        return estatura;
    }

    
}
