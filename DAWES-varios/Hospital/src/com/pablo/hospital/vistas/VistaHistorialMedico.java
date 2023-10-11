package com.pablo.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.pablo.hospital.controllers.HistorialMedicoController;
import com.pablo.hospital.dtos.HistorialMedicoDTO;
import com.pablo.hospital.utils.MiScanner;




public class VistaHistorialMedico {
	
	public void menuGeneralHistorialMedico() throws ClassNotFoundException, SQLException {
	
	Scanner sc = MiScanner.getInstance();
	int n = 0;

	do {
		System.out.println("Introduzca la operación que desee realizar: ");

		System.out.println("       MENÚ PRINCIPAL PARA LA CREACION DE HISTORIAL MEDICO");
		System.out.println("===========================================================");
		System.out.println("1. Buscar historial medico");
		System.out.println("2. Insertar historial medico");
		System.out.println("3. Actualizar historial medico ");
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
			menuBuscarHistorialMedico();
			continue;
		}

		if (n == 2) {
			menuInsertarHistorialMedico();
			continue;
		}

		if (n == 3) {
			menuActualizarHistorialMedico();
		continue;
}

	} while (n != 6);

}
	
	private void menuBuscarHistorialMedico() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el id para el historial medico");
		Integer iD = sc.nextInt();
		
		System.out.println("Introduzca por favor el pacienteID para el historial medico");
		Integer pacienteID = sc.nextInt();
		
		System.out.println("Introduzca por favor el medicoID para el historial medico");
		Integer medicoID = sc.nextInt();
		
		System.out.println("Introduzca por favor la fecha para el historial medico");
		String fecha = sc.nextLine();
		
		System.out.println("Introduzca por favor el diagnostico para el historial medico");
		String diagnostico = sc.nextLine();
		
		System.out.println("Introduzca por favor el tratamiento para el historial medico");
		String tratamiento = sc.nextLine();
		
		
		HistorialMedicoController controladorHistorial = new HistorialMedicoController();
		List<HistorialMedicoDTO> listaHistorial = controladorHistorial.buscarHistorialMedico( iD,  pacienteID,  medicoID,  fecha,  diagnostico,
			 tratamiento);
		
		for (HistorialMedicoDTO historial : listaHistorial) {
			System.out.println();
		}
		
	}
	
	public void menuActualizarHistorialMedico() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el id del historial medico");
		Integer iD = sc.nextInt();
		System.out.println("Introduzca por favor el id del historial medico");
		Integer pacienteID = sc.nextInt();
		System.out.println("Introduzca por favor el medicoID del historial medico");
		Integer medicoID = sc.nextInt();
		System.out.println("Introduzca por favor la fecha para el historial medico");
		String fecha = sc.nextLine();
		
		System.out.println("Introduzca por favor el diagnostico para el historial medico");
		String diagnostico = sc.nextLine();
		
		System.out.println("Introduzca por favor el tratamiento para el historial medico");
		String tratamiento = sc.nextLine();
		
		
		HistorialMedicoController controladorHistorial = new HistorialMedicoController();
		int resultado = controladorHistorial.insertarHistorialPaciente(iD, pacienteID, medicoID, fecha, diagnostico, tratamiento);
		

		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
			
		}
	
	public void menuInsertarHistorialMedico() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el id del historial medico");
		Integer iD = sc.nextInt();
		System.out.println("Introduzca por favor el id del historial medico");
		Integer pacienteID = sc.nextInt();
		System.out.println("Introduzca por favor el medicoID del historial medico");
		Integer medicoID = sc.nextInt();
		System.out.println("Introduzca por favor la fecha para el historial medico");
		String fecha = sc.nextLine();
		
		System.out.println("Introduzca por favor el diagnostico para el historial medico");
		String diagnostico = sc.nextLine();
		
		System.out.println("Introduzca por favor el tratamiento para el historial medico");
		String tratamiento = sc.nextLine();
		
		HistorialMedicoController controladorHistorial = new HistorialMedicoController();
		int resultado = controladorHistorial.insertarHistorialPaciente(iD, pacienteID, medicoID, fecha, diagnostico, tratamiento);
		

		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}
}

