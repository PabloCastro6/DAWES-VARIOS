package herencia;

public class Humano extends Animal implements Comparable <Humano> {
	int edad;
	
	public Humano() {
		this.patas = 2;
		
	}

	@Override
	public int compareTo(Humano o) {
		if (this.edad < o.edad ) {
			return -1;
		} else if (this.edad > o.edad) {
			return 1;
		} else {
			return 0;
		}
		
		
	}

}
