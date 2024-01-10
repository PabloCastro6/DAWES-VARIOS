package Ejercicio;

public class Personas {
	
	Persona persona1 = new Persona (25, 175.5);
	Persona persona2 = new Persona (30, 165);
	
	
	ComparadorEdad comparadorEdad = new ComparadorEdad();
	int resultadoEdad = comparadorEdad.compareTo(persona1);{
	
	if (resultadoEdad < 0) {
	    System.out.println("persona1 es más joven que persona2");
	} else if (resultadoEdad > 0) {
	    System.out.println("persona1 es más vieja que persona2");
	} else {
	    System.out.println("persona1 y persona2 tienen la misma edad");
	}
	

}

}
