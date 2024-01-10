package Tema2;

public class Partido {
int golLocal ;
int golVisitante;

public Partido(int golesLocal, int golesVisitante) {
	golLocal = golesLocal ;
	golVisitante = golesVisitante;
}


public int getGolesTotal() {
	return golLocal + golVisitante;
	
}
	
public String quiniela() {
	if (golLocal > golVisitante) {
		return "1";
	} else if (golLocal < golVisitante) {
		return "2";
	} else {
		return "x";
	}
	
	
}

}
