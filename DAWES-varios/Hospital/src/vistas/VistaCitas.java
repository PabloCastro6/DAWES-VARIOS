package vistas;

import java.sql.SQLException;
import java.util.Scanner;

import utils.MiScanner;

public class VistaCitas {
	public void menuGeneralCita() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		int n = 0;

		do {
			System.out.println("Introduzca la operación que desee realizar: ");

			System.out.println("       MENÚ PRINCIPAL PARA LA CREACION DE PACIENTES");
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

//			if (n == 3) {
//				menuActualizarPaciente();
//				continue;
//			}

		} while (n != 6);

	}
}
