import ejercicio5.Animal;
import ejercicio5.Gato;
import ejercicio5.Perro;
import ejercicio5.PuedeHablar;

public class Ejercicio5 {
    public static void main(String[] args) {
        Animal a = new Animal();
        Gato g = new Gato();
        Animal p = new Perro();

        try {
            a.hablar();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        g.hablar();
        hacerHablar(p);
        
        System.out.println(Animal.getTipo());
        System.out.println(Gato.getTipo());
        System.out.println(Perro.getTipo());
    }

    public static void hacerHablar(PuedeHablar puedeHablar) {
        puedeHablar.hablar();
    }
}
