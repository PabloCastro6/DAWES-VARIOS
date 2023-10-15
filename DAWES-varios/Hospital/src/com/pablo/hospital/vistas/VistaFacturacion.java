package com.pablo.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.pablo.hospital.controllers.DepartamentosController;
import com.pablo.hospital.controllers.FacturacionController;
import com.pablo.hospital.dtos.DepartamentoDTO;
import com.pablo.hospital.dtos.FacturacionDTO;
import com.pablo.hospital.utils.MiScanner;

public class VistaFacturacion {

	public void menuGeneralFacturacion() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		int n = 0;

		do {
			System.out.println("Introduzca la operación que desee realizar: ");

			System.out.println("       MENÚ PRINCIPAL PARA LA CREACION DE FACTURACION");
			System.out.println("===========================================================");
			System.out.println("1. Buscar facturacion");
			System.out.println("2. Insertar facturacion");
			System.out.println("3. Actualizar facturacion ");
			System.out.println("4. Volver al menú principal");
			System.out.println("===============================================");

			n = Integer.parseInt(sc.nextLine());

			if (n > 5 || n < 1) {
				System.out.print("Elección inválida, inténtalo otra vez...");
				continue;
			}
			if (n == 1) {
				menuBuscarFacturacion();
				continue;
			}

			if (n == 2) {
				menuInsertarFacturacion();
				continue;
			}

			if (n == 3) {
				menuActualizarFacturacion();
				continue;
			}
			if (n == 4) {
				return;
			}

		} while (n != 4);

	}


	private void menuBuscarFacturacion() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el id de la facturacion");
		String id = sc.nextLine();

		System.out.println("Introduzca por favor el nombre de la facturacion");
		Integer pacienteID = sc.nextInt();

		System.out.println("Introduzca por favor la descripcion de la facturacion");
		String fecha = sc.nextLine();

		System.out.println("Introduzca por favor el monto de la facturacion");
		Float monto = sc.nextFloat();

		System.out.println("Introduzca por favor el estadoID de la facturacion");
		Integer estadoID = sc.nextInt();

		FacturacionController controladorFacturacion = new FacturacionController();
		List<FacturacionDTO> listaFacturacion = controladorFacturacion.buscarfacturacion(id, pacienteID, fecha, monto,
				estadoID);

		for (FacturacionDTO facturacion : listaFacturacion) {
			System.out.println(facturacion);
		}

	}

	public void menuInsertarFacturacion() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor la descripcion de la facturacion");
		String fecha = sc.nextLine();

		System.out.println("Introduzca por favor el monto de la facturacion");
		Float monto = sc.nextFloat();

		FacturacionController controladorFacturacion = new FacturacionController();
		int resultado = controladorFacturacion.insertarFacturacion(fecha, monto);

		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}

	public void menuActualizarFacturacion() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el id de la facturacion");
		String id = sc.nextLine();


		System.out.println("Introduzca por favor el nombre de la facturacion");
		Integer pacienteID = sc.nextInt();

		System.out.println("Introduzca por favor la descripcion de la facturacion");
		String fecha = sc.nextLine();

		System.out.println("Introduzca por favor el monto de la facturacion");
		Float monto = sc.nextFloat();

		System.out.println("Introduzca por favor el estadoID de la facturacion");
		Integer estadoID = sc.nextInt();

		FacturacionController controladorFacturacion = new FacturacionController();
		int resultado = controladorFacturacion.actualizarFacturacion(id, pacienteID, fecha, monto, estadoID);

		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}

}
