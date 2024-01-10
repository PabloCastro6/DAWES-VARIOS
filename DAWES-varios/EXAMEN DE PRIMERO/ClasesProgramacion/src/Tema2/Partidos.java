package Tema2;

import java.util.ArrayList;

public class Partidos {

	public static void main(String[] args) {
		ArrayList<Partido> partidos = new ArrayList(); 
		
		partidos.add(new Partido(1,2));
		partidos.add(new Partido(3,3));
		partidos.add(new Partido(3,4));
		partidos.add(new Partido(6,2));
		partidos.add(new Partido (5,3));
		
//		System.out.println(partidos.get(2).getGolesTotal());	
//		System.out.println(partidos.get(0).quiniela());
		
		ArrayList<Partido> resultados1x2 = new ArrayList<>();
	
		for (int i=0; i<partidos.size()  ; i++) {
			Partido partido = partidos.get(i);
		//	System.out.println(partidos.get(i).quiniela());
			String resultado = partido.quiniela();
			
			
			if (resultado.equals("1 x 2")) {
				resultados1x2.add(partido);
			}
			
		}

		
		for (Partido partido : resultados1x2) {
			System.out.println(partido.quiniela());
		}
	}

}

	
