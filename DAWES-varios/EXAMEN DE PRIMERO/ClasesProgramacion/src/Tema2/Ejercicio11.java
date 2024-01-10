package Tema2;

public class Ejercicio11 {

	public static void main(String[] args) {

			float consumoReal = 100f;

			if (consumoReal < ConstantesEjerc11.LimiteUno) {
				System.out.println(
						"El precio de la unidad correspondiente al consumo " + consumoReal + " es " + ConstantesEjerc11.PrecioUno + ".");
			} else if (consumoReal >= ConstantesEjerc11.LimiteUno && consumoReal <= ConstantesEjerc11.LimiteDos) {
				System.out.println(
						"El precio de la unidad correspondiente al consumo " + consumoReal + " es " + ConstantesEjerc11.PrecioDos + ".");
			} else if (consumoReal > ConstantesEjerc11.LimiteDos && consumoReal <= ConstantesEjerc11.LimiteTres) {
				System.out.println(
						"El precio de la unidad correspondiente al consumo " + consumoReal + " es " + ConstantesEjerc11.PrecioTres + ".");
			} else {
				System.out.println("El precio de la unidad correspondiente al consumo " + consumoReal + " es "+ ConstantesEjerc11.PrecioCuatro + ".");
			}
		}


	}


