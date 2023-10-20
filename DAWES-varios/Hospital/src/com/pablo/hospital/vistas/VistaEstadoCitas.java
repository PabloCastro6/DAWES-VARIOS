package com.pablo.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.pablo.hospital.controllers.EstadoCitasController;
import com.pablo.hospital.dtos.AlergiaDTO;
import com.pablo.hospital.dtos.EstadoCitasDTO;
import com.pablo.hospital.utils.MiScanner;

public class VistaEstadoCitas {
	public void menuGeneralAlergias() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		int n = 0;
		do {
			System.out.println("Introduzca la operación que desee realizar: ");

			System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DEL ESTADO DE CITA");
			System.out.println("===========================================================");
			System.out.println("1. Buscar estado cita");
			System.out.println("2. Insertar estado cita");
			System.out.println("3. Actualizar estado de la cita ");
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
				menuBuscarEstadoCita();
				continue;
			}

			if (n == 2) {
				menuInsertarEstadoCita();
				continue;
			}

			if (n == 3) {
				menuActualizarEstadoCita();
				continue;
			}
			if (n == 4) {
				return;
			}

		} while (n != 4);

	}


	public void menuBuscarEstadoCita() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el id del estado de la cita: ");
		String id = sc.nextLine();

		System.out.println("Introduzca por favor el estado de la cita: ");
		String estado = sc.nextLine();

		EstadoCitasController controladorEstadoCita = new EstadoCitasController();
		List<EstadoCitasDTO> listaEstadoCita = controladorEstadoCita.buscarEstadoCitas(id, estado);

		for (EstadoCitasDTO estadoCita : listaEstadoCita) {
			System.out.println(estadoCita.getID() + " " + estadoCita.getEstado());

		}
	}

	public void menuInsertarEstadoCita() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		

		System.out.println("Introduzca por favor el estado de la cita");
		String estado = sc.nextLine();

		EstadoCitasController controladorEstadoCitas = new EstadoCitasController();
		int resultado = controladorEstadoCitas.insertarEstadoCitas(estado);
		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}

	public void menuActualizarEstadoCita() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el ID de estado cita a actualizar: ");
		String id = sc.nextLine();

		System.out.println("Introduzca por favor el nuevo estado de citas: ");
		String estado = sc.nextLine();

		EstadoCitasController controladorEstadoCitas = new EstadoCitasController();
		int resultado = controladorEstadoCitas.actualizarEstadoCitas(id, estado);
		if (resultado == 1) {
			System.out.println("Se ha actualizado el estado de la cita con el id: " + id + " con éxito");
		} else {
			System.out.println("Se ha producido un error al actualizar el alergia con el número: " + id);
		}

	}
}
