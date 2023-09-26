
public class Persona {
	
	private String nombre;
	private int edad;

	public Persona() {
		
		if(nombre.isEmpty()) {
			this.nombre = "Anonimo"; 
			
		} else {
			this.nombre = nombre;
		}
		
		if ( edad < 0) {
			this.edad = 99;
		} else {
			this.edad = edad;
		}
		
	
		}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}
		
	}

