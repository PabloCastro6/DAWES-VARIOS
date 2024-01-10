package Tema2;

public class Ejercicio16 {

	public static void main(String[] args) {
		int numero = 1;
		
//		if  (numero == 1){
//			System.out.println("Lunes");
//			
//			
//		}else if (numero == 2) {
//			System.out.println("Martes");
//			
//		} else {
//			System.out.println("El numero no es valido");
//		}

		switch (numero) {
		case 1: 
			System.out.println("lunes");
			break;
			
		case 2:
			System.out.println("martes");
		break;
			default:
				System.out.println("eL NUMERO NO ES VALIDO.");
			
		} 
		
	} 

}
