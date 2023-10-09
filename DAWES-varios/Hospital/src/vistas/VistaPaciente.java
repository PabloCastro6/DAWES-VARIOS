package vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import controllers.AlergiasController;
import controllers.PacientesController;
import dtos.PacienteDTO;
import utils.MiScanner;

public class VistaPaciente {

	public void menuGeneralPaciente() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		int n = 0;

		do {
			System.out.println("Introduzca la operación que desee realizar: ");

			System.out.println("       MENÚ PRINCIPAL PARA LA CREACION DE PACIENTES");
			System.out.println("===========================================================");
			System.out.println("1. Buscar paciente");
			System.out.println("2. Insertar paciente");
			System.out.println("3. Actualizar paciente ");
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
				menuBuscarPaciente();
				continue;
			}

			if (n == 2) {
				menuInsertarPaciente();
				continue;
			}

			if (n == 3) {
				menuActualizarPaciente();
			continue;
	}

		} while (n != 6);

	}

	private void menuBuscarPaciente() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el id del paciente");
		String id = sc.nextLine();
		
		System.out.println("Introduzca por favor el nombre del paciente");
		String nombre = sc.nextLine();
		
		System.out.println("Introduzca por favor el apellido del paciente");
		String apellido = sc.nextLine();
		
		System.out.println("Introduzca por favor la fecha de nacimiento del paciente");
		String FechaDeNacimiento = sc.nextLine();
		
		System.out.println("Introduzca por favor el DNI");
		String DNI = sc.nextLine();
		
		System.out.println("Introduzca por favor la direccion del paciente");
		String direccion = sc.nextLine();
		
		System.out.println("Introduzca por favor la telefono del paciente");
		String telefono = sc.nextLine();
		
		System.out.println("Introduzca por favor el correo del paciente");
		String correo = sc.nextLine();
		
		System.out.println("Introduzca por favor la alergia del paciente");
		Integer alergia = sc.nextInt();
		
		System.out.println("Introduzca por favor la historia Medica del paciente");
		String HistoriaMedica = sc.nextLine();
		
		
		
		PacientesController controladorPaciente = new PacientesController();
		List <PacienteDTO> listaPaciente = controladorPaciente.buscarPaciente(id,  nombre,  apellido, FechaDeNacimiento,  DNI, direccion,  telefono,
				 correo,  alergia, HistoriaMedica);
		
		for (PacienteDTO paciente : listaPaciente) {
			System.out.println();
		}

	}
	
	public void menuInsertarPaciente() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el nombre del paciente");
		String nombre = sc.nextLine();
		System.out.println("Introduzca por favor el apellido del paciente");
		String apellido = sc.nextLine();
		System.out.println("Introduzca por favor el FechaDeNacimiento del paciente");
		String FechaDeNacimiento = sc.nextLine();
		System.out.println("Introduzca por favor el DNI del paciente");
		String DNI = sc.nextLine();
		System.out.println("Introduzca por favor el direccion del paciente");
		String direccion = sc.nextLine();
		System.out.println("Introduzca por favor el telefono del paciente");
		String telefono = sc.nextLine();
		System.out.println("Introduzca por favor el correo del paciente");
		String correo = sc.nextLine();
		System.out.println("Introduzca por favor el alergia del paciente");
		Integer alergia = sc.nextInt();
		System.out.println("Introduzca por favor la HistoriaMedica del paciente");
		String HistoriaMedica = sc.nextLine();
		
		
		PacientesController controladorPaciente = new PacientesController();
		int resultado = controladorPaciente.insertarPaciente( nombre,apellido,FechaDeNacimiento,  DNI,  direccion,  telefono,
				 correo,  alergia,  HistoriaMedica);
		
		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}
	
	
	
	public void menuActualizarPaciente() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el id del paciente a actualizar: ");
		String  id = sc.nextLine();
		
		System.out.println("Introduzca por favor el nombre del paciente a actualizar: ");
		String  nombre = sc.nextLine();
		
		System.out.println("Introduzca por favor el apellido del paciente a actualizar: ");
		String apellido = sc.nextLine();	 	
		
		System.out.println("Introduzca por favor la fecha de nacimiento del paciente a actualizar: ");
		String FechaDeNacimiento = sc.nextLine();	
		
		System.out.println("Introduzca por favor el DNI del paciente a actualizar: ");
		String DNI = sc.nextLine();	
		
		System.out.println("Introduzca por favor la direccion del paciente a actualizar: ");
		String direccion = sc.nextLine();	
		
		System.out.println("Introduzca por favor el telefono del paciente a actualizar: ");
		String telefono = sc.nextLine();	
		
		System.out.println("Introduzca por favor el correo del paciente a actualizar: ");
		String correo = sc.nextLine();	
		
		System.out.println("Introduzca por favor la alergia del paciente a actualizar: ");
		Integer alergia = Integer.parseInt(sc.nextLine());	
		
		System.out.println("Introduzca por favor la historia medica del paciente a actualizar: ");
		String HistoriaMedica = sc.nextLine();	
		
		
		
		PacientesController controladorPaciente = new PacientesController();
		int resultado = controladorPaciente.actualizarPaciente(id, nombre,  apellido, FechaDeNacimiento,  DNI,  direccion,  telefono,
				 correo,  alergia,  HistoriaMedica);
		
		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}

	}
}

