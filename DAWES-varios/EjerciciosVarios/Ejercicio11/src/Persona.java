
public class Persona {
	
	private String nombre;
	private int edad;

	public Persona(String nombre, int edad) {
		
		if(nombre == null || nombre.isEmpty()) {
			this.nombre = "Anonimo"; 
			
		} else {
			this.nombre = nombre;
		}
		
		if ( edad < 0) {
			this.edad = - 99;
		} else {
			this.edad = edad;
		}
		
	
		}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Persona() {
		this.nombre = "Anonimo";
		this.edad = -99;
	}
	
	}
		
	

