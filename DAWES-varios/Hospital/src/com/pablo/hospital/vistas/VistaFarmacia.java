package com.pablo.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.pablo.hospital.controllers.FarmaciaController;
import com.pablo.hospital.dtos.FarmaciaDTO;
import com.pablo.hospital.utils.MiScanner;

public class VistaFarmacia {
	public void menuGeneralFarmacia() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		int n = 0;
		do {
			System.out.println("Introduzca la operación que desee realizar: ");

			System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE LA TABLA FARMACIA");
			System.out.println("===========================================================");
			System.out.println("1. Buscar farmacia");
			System.out.println("2. Insertar farmacia");
			System.out.println("3. Actualizar farmacia ");
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
				menuBuscaFarmacia();
				continue;
			}

			if (n == 2) {
				menuInsertarFarmacia();
				continue;
			}

			if (n == 3) {
				menuActualizarFarmacia();
				continue;
			}
			if (n == 4) {
				return;
			}

		} while (n != 4);

	}

	
	public void menuBuscaFarmacia() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el id de la Farmacia: ");
		String id = sc.nextLine();

		System.out.println("Introduzca por favor el nombre de la farmacia: ");
		String nombre = sc.nextLine();

		System.out.println("Introduzca por favor la descripcion de la farmacia: ");
		String descripcion = sc.nextLine();

		System.out.println("Introduzca por favor la cantidad disponible de la farmacia: ");
		Integer cantidadDisponible = sc.nextInt();

		System.out.println("Introduzca por favor el precio de la farmacia: ");
		Float precio = sc.nextFloat();

		FarmaciaController controladorFarmacia = new FarmaciaController();
		List<FarmaciaDTO> listaFarmacia = controladorFarmacia.buscarFarmacia(id, nombre, descripcion,
				cantidadDisponible, precio);

		for (FarmaciaDTO farmacia : listaFarmacia) {
			System.out.println(farmacia);

		}
	}

	public void menuInsertarFarmacia() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el nombre de la farmacia: ");
		String nombre = sc.nextLine();

		System.out.println("Introduzca por favor la descripcion de la farmacia: ");
		String descripcion = sc.nextLine();

		System.out.println("Introduzca por favor la cantidad disponible de la farmacia: ");
		Integer cantidadDisponible = sc.nextInt();

		System.out.println("Introduzca por favor el precio de la farmacia: ");
		Float precio = sc.nextFloat();

		FarmaciaController controladorFarmacia = new FarmaciaController();
		int resultado = controladorFarmacia.insertarFarmacia(nombre, descripcion, cantidadDisponible, precio);
		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}

	}

	public void menuActualizarFarmacia() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el nombre de la farmacia a actualizar: ");
		String nombre = sc.nextLine();

		System.out.println("Introduzca por favor la descripcion de la farmacia a actualizar: ");
		String descripcion = sc.nextLine();

		System.out.println("Introduzca por favor la cantidad disponible de la farmacia a actualizar: ");
		Integer cantidadDisponible = sc.nextInt();

		System.out.println("Introduzca por favor el precio de la farmacia a actualizar: ");
		Float precio = sc.nextFloat();

		FarmaciaController controladorFarmacia = new FarmaciaController();
		int resultado = controladorFarmacia.insertarFarmacia(nombre, descripcion, cantidadDisponible, precio);
		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}

	}
}
