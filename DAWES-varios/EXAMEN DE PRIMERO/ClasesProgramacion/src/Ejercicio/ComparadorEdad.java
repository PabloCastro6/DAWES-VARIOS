package Ejercicio;

public class ComparadorEdad implements Comparable<Persona> {
	
	public int CompareTo (Persona otraPersona) {
		return Integer.compare(this.getEdad(),  otraPersona.getEdad());
	}

	private int getEdad() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareTo(Persona o) {
		// TODO Auto-generated method stub
		return 0;
	}


}
