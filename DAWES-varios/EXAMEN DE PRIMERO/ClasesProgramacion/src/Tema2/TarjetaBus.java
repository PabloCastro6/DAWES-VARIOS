package Tema2;

public class TarjetaBus {
	
	private String cliente;
	private int edad;
	private double saldo;
	
	
	public  TarjetaBus (String cliente, int edad, double saldoInicial) {
		this.cliente = cliente;
		this.edad = edad;
		this.saldo = saldoInicial;
	}

	
	public void viaje() {
		double tarifa;
		
		
		if(edad < 8) {
			tarifa = 0;
		} else if (edad <26) {
			tarifa = 0.80;
		} else if  (edad > 65) {
			tarifa = 0.60;
		} else {
			tarifa = 1.50;
		}
		
		
		if (saldo >= tarifa) {
			saldo -= tarifa;
			
			System.out.println("Cliente: " + cliente);
			System.out.println("Edad:" + edad);
			System.out.println("Tarida" + tarifa);
			
		}else {
			System.out.println("Salgo negativo");
		}
	}
}
