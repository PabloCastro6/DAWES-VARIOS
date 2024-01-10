import java.util.ArrayList;

import ejercicio4.Alumno;
import ejercicio4.Clase;

public class Ejercicio4 {
    public static void main(String[] args) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Pedro", 15, 179));
        alumnos.add(new Alumno("Juana", 14, 168));
        alumnos.add(new Alumno("Sara", 20, 173));
        Clase clase1 = new Clase(alumnos);

        System.out.println("Media de edad: " + clase1.getMediaEdad());
        System.out.println("Media de estatura: " + clase1.getMediaEstatura());
    }
}
