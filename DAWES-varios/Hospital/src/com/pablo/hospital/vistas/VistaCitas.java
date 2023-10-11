package com.pablo.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.pablo.hospital.controllers.CitasController;
import com.pablo.hospital.dtos.AlergiaDTO;
import com.pablo.hospital.dtos.CitasDTO;


import utils.MiScanner;

public class VistaCitas {
	public void menuGeneralCita() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		int n = 0;

		do {
			System.out.println("Introduzca la operación que desee realizar: ");

			System.out.println("       MENÚ PRINCIPAL PARA LA CREACION DE CITAS");
			System.out.println("===========================================================");
			System.out.println("1. Buscar cita");
			System.out.println("2. Insertar cita");
			System.out.println("3. Actualizar cita ");
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
				menuBuscarCita();
				continue;
			}

			if (n == 2) {
				menuInsertarCita();
				continue;
			}

			if (n == 3) {
				menuActualizarCita();
				continue;
		}

		} while (n != 6);

	}
	
	private void menuBuscarCita() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el id de la cita: ");
		String id = sc.nextLine();

		System.out.println("Introduzca por favor el id del paciente de la cita: ");
		String pacienteID = sc.nextLine();
		
		System.out.println("Introduzca por favor el id del medico de la cita: ");
		String medicoID = sc.nextLine();
		
		System.out.println("Introduzca por favor la fecha de la cita: ");
		String fecha = sc.nextLine();
		
		System.out.println("Introduzca por favor la hora de la cita: ");
		String hora = sc.nextLine();
		
		System.out.println("Introduzca por favor el estado de la cita: ");
		String estado = sc.nextLine();
		
		CitasController controladorCitas = new CitasController();
		List <CitasDTO> listaCita = controladorCitas.buscarCita(id,  pacienteID,  medicoID,  fecha,  hora,  estado);
		
		for (CitasDTO cita : listaCita) {
			System.out.println();

		}
	
	}
	
	private void menuInsertarCita() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		

		
		System.out.println("Introduzca por favor el id del paciente: ");
		String pacienteID = sc.nextLine();
		
		System.out.println("Introduzca por favor el Id del medico : ");
		String medicoID = sc.nextLine();
		
		
		System.out.println("Introduzca por favor la fecha de la cita: ");
		String fecha = sc.nextLine();
		
		System.out.println("Introduzca por favor la hora de la cita: ");
		String hora = sc.nextLine();
		
		System.out.println("Introduzca por favor el estado de la cita: ");
		String estado = sc.nextLine();


		
		CitasController controladorCitas = new CitasController();
		int resultado = controladorCitas.insertarCita( pacienteID,  medicoID,  fecha,  hora,  estado);
		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}

	}
	
	private void menuActualizarCita() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		

		System.out.println("Introduzca por favor el id de la cita: ");
		Integer iD = Integer.parseInt(sc.nextLine());
		
		

		System.out.println("Introduzca por favor el id del paciente: ");
		String pacienteID =sc.nextLine();
		
		System.out.println("Introduzca por favor el Id del medico : ");
		String medicoID = sc.nextLine();
		
		
		System.out.println("Introduzca por favor la fecha de la cita: ");
		String fecha = sc.nextLine();
		
		System.out.println("Introduzca por favor la hora de la cita: ");
		String hora = sc.nextLine();
		
		System.out.println("Introduzca por favor el estado de la cita: ");
		String estado = sc.nextLine();


		
		CitasController controladorCitas = new CitasController();
		int resultado = controladorCitas.actualizarCita( iD,  pacienteID,  medicoID,  fecha,  hora,  estado);
		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}

	}
}