package com.pablo.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.pablo.hospital.controllers.MedicosController;
import com.pablo.hospital.dtos.MedicoDTO;
import com.pablo.hospital.dtos.PacienteDTO;
import com.pablo.hospital.utils.MiScanner;



public class VistaMedico {
	
	public void menuGeneralMedico() throws ClassNotFoundException, SQLException {
		
		Scanner sc = MiScanner.getInstance();
		int n = 0;

		do {
			System.out.println("Introduzca la operación que desee realizar: ");

			System.out.println("       MENÚ PRINCIPAL PARA LA CREACION DE MEDICOS");
			System.out.println("===========================================================");
			System.out.println("1. Buscar medico");
			System.out.println("2. Insertar medico");
			System.out.println("3. Actualizar medico ");
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
				menuBuscarMedico();
				continue;
			}

			if (n == 2) {
				menuInsertarMedico();
				continue;
			}

			if (n == 3) {
				menuActualizarMedico();
			continue;
	}

		} while (n != 6);

	}
	
	private void menuBuscarMedico() throws ClassNotFoundException, SQLException {
		
	
	Scanner sc = MiScanner.getInstance();
	System.out.println("Introduzca por favor el id del medico");
	Integer iD = sc.nextInt();
	
	System.out.println("Introduzca por favor el nombre del medico");
	String nombre = sc.nextLine();
	
	System.out.println("Introduzca por favor el apellido del medico");
	String apellido = sc.nextLine();
	
	System.out.println("Introduzca por favor la fecha de nacimiento del medico");
	String especialidad = sc.nextLine();
	
	System.out.println("Introduzca por favor el DNI del medico");
	String licenciaMedica = sc.nextLine();
	
	System.out.println("Introduzca por favor la direccion del medico");
	String telefono = sc.nextLine();
	
	System.out.println("Introduzca por favor la telefono del medico");
	String correoElectronico = sc.nextLine();
	
	
	
	
	MedicosController controladorMedico = new MedicosController();
	List <MedicoDTO> listaMedico = controladorMedico.buscarMedico( iD,  nombre,  apellido,  especialidad,  licenciaMedica,
			 telefono,  correoElectronico);
	
	for (MedicoDTO medico : listaMedico) {
		System.out.println();
	}

}
	public void menuInsertarMedico() throws ClassNotFoundException, SQLException {
		
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el id del medico");
		Integer iD = sc.nextInt();
		
		System.out.println("Introduzca por favor el nombre del medico");
		String nombre = sc.nextLine();
		
		System.out.println("Introduzca por favor el apellido del medico");
		String apellido = sc.nextLine();
		
		System.out.println("Introduzca por favor la fecha de nacimiento del medico");
		String especialidad = sc.nextLine();
		
		System.out.println("Introduzca por favor el DNI del medico");
		String licenciaMedica = sc.nextLine();
		
		System.out.println("Introduzca por favor la direccion del medico");
		String telefono = sc.nextLine();
		
		System.out.println("Introduzca por favor la telefono del medico");
		String correoElectronico = sc.nextLine();
		
		
		MedicosController controladorMedico = new MedicosController();
		int resultado = controladorMedico.insertarMedico( iD,  nombre,  apellido,  especialidad,  licenciaMedica,
				 telefono,  correoElectronico);
		
		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}
	
	public void menuActualizarMedico() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el id del medico a actualizar: ");
		Integer  iD = sc.nextInt();
		
		System.out.println("Introduzca por favor el nombre del medico a actualizar: ");
		String  nombre = sc.nextLine();
		
		System.out.println("Introduzca por favor el apellido del medico a actualizar: ");
		String apellido = sc.nextLine();	 	
		
		System.out.println("Introduzca por favor la fecha de nacimiento del medico a actualizar: ");
		String especialidad = sc.nextLine();	
		
		System.out.println("Introduzca por favor el DNI del medico a actualizar: ");
		String licenciaMedica = sc.nextLine();	
		
		System.out.println("Introduzca por favor la direccion del medico a actualizar: ");
		String telefono = sc.nextLine();	
		
		System.out.println("Introduzca por favor el telefono del medico a actualizar: ");
		String correoElectronico = sc.nextLine();	
			
		
		
		
		MedicosController controladorMedico = new MedicosController();
		int resultado = controladorMedico.actualizarMedico(iD,  nombre,  apellido,  especialidad,  licenciaMedica,
				 telefono,  correoElectronico);
		
		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}

	}

}
