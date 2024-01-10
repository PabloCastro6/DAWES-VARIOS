
public class Ejercicio28 {

	public static void main(String[] args) {
		float altura = 1.77f;
		int edad = 22;
		float peso =  81.3f;
		
		float resultado;
		resultado = (float)(2.447 - (0.09156 * edad)+ (0.1074 * altura) + (0.3362 * peso));
		
		System.out.println("El BTW del paciente con " + edad + " y altura de " + altura + " metros es de: " + resultado);

	}

}
