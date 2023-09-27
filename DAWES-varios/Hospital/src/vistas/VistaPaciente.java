package vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

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
				menuInsertaPaciente();
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
		System.out.println("Introduzca por favo el id del cliente");
		String id = sc.nextLine();
		
		System.out.println("Introduzca por favor el nombre del cliente");
		String nombrePaciente = sc.nextLine();
		
		PacientesController controladorPaciente = new PacientesController();
		List <PacienteDTO> listaPaciente = controladorPaciente.buscarPaciente(id,nombrePaciente);
		
		for (PacienteDTO paciente : listaPaciente) {
			System.out.println();
		}

	}
	
	public void menuInsertarPaciente() {
		Scanner sc = MiScanner.getInstance();
	}
	
	public void menuActualizarAlergio() {
		
	}
}

