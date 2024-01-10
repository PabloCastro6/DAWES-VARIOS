import ejercicio3.Persona;

public class Ejercicio3 {
    public static void main(String[] args) {
        Persona p1 = new Persona("Padre", 70, null, null);
        Persona p2 = new Persona("Madre", 73, null, null);

        Persona persona = new Persona("Persona", 38, p1, p2);
        Persona hermano = new Persona("Hermano", 42, p1, p2);

        // p1.anadirHijo(persona);
        // p2.anadirHijo(persona);
        // persona.anadirHermano(hermano);
        // p1.anadirHijo(hermano);
        // p2.anadirHijo(hermano);
        // hermano.anadirHermano(persona);

        System.out.println(persona.getNombre() + " es hijo unico?: " + persona.esHijoUnico());
        System.out.println(hermano.getNombre() + " es hijo unico?: " + hermano.esHijoUnico());
    }
}
