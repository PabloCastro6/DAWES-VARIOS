package com.pablo.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.pablo.hospital.controllers.HabitacionesController;
import com.pablo.hospital.dtos.HabitacionesDTO;
import com.pablo.hospital.utils.MiScanner;

public class VistaHabitaciones {
	
	public void menuGeneralHabitacion() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		int n = 0;

		do {
			System.out.println("Introduzca la operación que desee realizar: ");

			System.out.println("       MENÚ PRINCIPAL PARA LA CREACION DE HABITACIONES");
			System.out.println("===========================================================");
			System.out.println("1. Buscar habitacion");
			System.out.println("2. Insertar habitacion");
			System.out.println("3. Actualizar habitacion ");
			System.out.println("4. Volver al menú principal");
			System.out.println("===============================================");

			n = Integer.parseInt(sc.nextLine());

			if (n == 6) {

				return;
			}

			if (n > 4 || n < 1) {
				System.out.print("Elección inválida, inténtalo otra vez...");
				continue;
			}
			if (n == 1) {
				menuBuscarHabitacion();
				continue;
			}

			if (n == 2) {
				menuInsertarHabitacion();
				continue;
			}

			if (n == 3) {
				menuActualizarHabitacion();
			continue;
	}

		} while (n != 6);

	}

	private void menuBuscarHabitacion() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el id de la habitacion");
		Integer iD = sc.nextInt();
		
		System.out.println("Introduzca por favor el tipo de la habitacion");
		String tipo = sc.nextLine();
		
		System.out.println("Introduzca por favor el estado  de la habitacion");
		String estado = sc.nextLine();
		
		System.out.println("Introduzca por favor el costo por dia de la habitacion");
		Float costoPorDia = sc.nextFloat();
		

		
		
		
		HabitacionesController controladorHabitacion = new HabitacionesController();
		List <HabitacionesDTO> listaHabitaciones = controladorHabitacion.buscarHabitacion( iD,  tipo,  estado,  costoPorDia);
		
		for (HabitacionesDTO habitacion : listaHabitaciones) {
			System.out.println(habitacion);
		}

	}
	
	public void menuInsertarHabitacion() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el tipo de la habitacion");
		String tipo = sc.nextLine();
		System.out.println("Introduzca por favor el estado de la habitacion");
		String estado = sc.nextLine();
		System.out.println("Introduzca por favor el costo por dia de la habitacion");
		Float costoPorDia = sc.nextFloat();
		
		
		HabitacionesController controladorHabitaciones = new HabitacionesController();
		int resultado = controladorHabitaciones.insertarHabitacion( tipo, estado, costoPorDia);
		
		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}
	
	
	
	public void menuActualizarHabitacion() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el id de la habitacion a actualizar: ");
		Integer  iD = sc.nextInt();
		
		System.out.println("Introduzca por favor el tipo de la habitacion a actualizar: ");
		String  tipo = sc.nextLine();
		
		System.out.println("Introduzca por favor el estado de la habitacion a actualizar: ");
		String estado = sc.nextLine();	 	
		
		System.out.println("Introduzca por favor el costo por dia de la habitacion a actualizar: ");
		Float costoPorDia = sc.nextFloat();	
		
	
		
		    
		
		HabitacionesController controladorHabitaciones = new HabitacionesController();
		int resultado = controladorHabitaciones.actualizarHabitacion(iD,  tipo,  estado,  costoPorDia);
		
		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}

	}
}



  


