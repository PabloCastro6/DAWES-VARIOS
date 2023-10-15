package com.pablo.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.pablo.hospital.controllers.RecetasMedicasController;
import com.pablo.hospital.dtos.RecetasMedicasDTO;
import com.pablo.hospital.utils.MiScanner;

public class VistasRecetasMedica {
	public void menuGeneralRecetasMedicas() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		int n = 0;

		do {
			System.out.println("Introduzca la operación que desee realizar: ");

			System.out.println("       MENÚ PRINCIPAL PARA LA CREACION DE RECETAS MEDICAS");
			System.out.println("===========================================================");
			System.out.println("1. Buscar receta medica");
			System.out.println("2. Insertar receta medica");
			System.out.println("3. Actualizar receta medica ");
			System.out.println("4. Volver al menú principal");
			System.out.println("===============================================");

			n = Integer.parseInt(sc.nextLine());

			if (n > 4 || n < 1) {
				System.out.print("Elección inválida, inténtalo otra vez...");
				continue;
			}
			if (n == 1) {
				menuBuscarRecetaMedica();
				continue;
			}

			if (n == 2) {
				menuInsertarRecetaMedica();
				continue;
			}

			if (n == 3) {
				menuActualizarRecetasMedica();
				continue;
			}

			if (n == 4) {
				return;
			}

		} while (n != 4);

	}
		

	private void menuBuscarRecetaMedica() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el id de las recetas medicas");
		String iD = sc.nextLine();

		System.out.println("Introduzca por favor el nombre  de las recetas medicas");
		String pacienteID = sc.nextLine();

		System.out.println("Introduzca por favor la descripcion  de las recetas medicas");
		String medicoID = sc.nextLine();

		System.out.println("Introduzca por favor el activo  de las recetas medicas");
		String medicamentoID = sc.nextLine();

		System.out.println("Introduzca por favor la fecha de las recetas medicas");
		String fecha = sc.nextLine();

		System.out.println("Introduzca por favor el la cantidad prescrita de las recetas medicas");
		String cantidadPrescrita = sc.nextLine();

		RecetasMedicasController controladorRecetasMedicas = new RecetasMedicasController();
		List<RecetasMedicasDTO> listaRecetasMedicas = controladorRecetasMedicas.buscarRecetaMedica(iD, pacienteID,
				medicoID, medicamentoID, fecha, cantidadPrescrita);

		for (RecetasMedicasDTO recetas : listaRecetasMedicas) {
			System.out.println(recetas);
		}

	}

	public void menuInsertarRecetaMedica() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor la fecha de las recetas medicas");
		String fecha = sc.nextLine();

		System.out.println("Introduzca por favor la cantidad prescrita de las recetas medicas");
		Integer cantidadPrescrita = sc.nextInt();

		RecetasMedicasController controladorRecetasMedicas = new RecetasMedicasController();
		int resultado = controladorRecetasMedicas.insertarRecetasMedicas(fecha, cantidadPrescrita);

		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}

	public void menuActualizarRecetasMedica() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el id  de las recetas medicas ");
		String iD = sc.nextLine();
		System.out.println("Introduzca por favor el nombre  de las recetas medicas");
		Integer pacienteID = sc.nextInt();

		System.out.println("Introduzca por favor la descripcion  de las recetas medicas");
		Integer medicoID = sc.nextInt();

		System.out.println("Introduzca por favor el ID del medicamento  de las recetas medicas");
		Integer medicamentoID = sc.nextInt();

		System.out.println("Introduzca por favor la fecha de las recetas medicas");
		String fecha = sc.nextLine();

		System.out.println("Introduzca por favor la cantidad prescrita de las recetas medicas");
		Integer cantidadPrescrita = sc.nextInt();

		RecetasMedicasController controladorRecetasMedicas = new RecetasMedicasController();
		int resultado = controladorRecetasMedicas.actualizarRecetasMedicas(iD, pacienteID, medicoID, medicamentoID,
				fecha, cantidadPrescrita);

		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}

}
