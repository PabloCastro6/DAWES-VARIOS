package com.pablo.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.pablo.hospital.controllers.DepartamentosController;
import com.pablo.hospital.controllers.PacientesController;
import com.pablo.hospital.dtos.DepartamentoDTO;
import com.pablo.hospital.dtos.PacienteDTO;
import com.pablo.hospital.utils.MiScanner;

public class VistaDepartamentos {
	public void menuGeneralDepartamentos() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		int n = 0;

		do {
			System.out.println("Introduzca la operación que desee realizar: ");

			System.out.println("       MENÚ PRINCIPAL PARA LA CREACION DE DEPARTAMENTOS");
			System.out.println("===========================================================");
			System.out.println("1. Buscar departamento");
			System.out.println("2. Insertar departamento");
			System.out.println("3. Actualizar departamento ");
			System.out.println("4. Borrar departamento");
			System.out.println("5. Volver al menú principal");
			System.out.println("===============================================");

			n = Integer.parseInt(sc.nextLine());

			if (n > 5 || n < 1) {
				System.out.print("Elección inválida, inténtalo otra vez...");
				continue;
			}
			if (n == 1) {
				menuBuscarDepartamento();
				continue;
			}

			if (n == 2) {
				menuInsertarDepartamento();
				continue;
			}

			if (n == 3) {
				menuActualizarDepartamento();
				continue;
			}
			if (n == 4) {
				menuBorrarDepartamento();
			}

		} while (n != 5);

	}

	private void menuBuscarDepartamento() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el id del departamento");
		String id = sc.nextLine();

		System.out.println("Introduzca por favor el nombre del departamento");
		String nombre = sc.nextLine();

		System.out.println("Introduzca por favor la descripcion del departamento");
		String descripcion = sc.nextLine();

		System.out.println("Introduzca por favor el activo del departamento");
		String activo = sc.nextLine();

		DepartamentosController controladorDepartamentos = new DepartamentosController();
		List<DepartamentoDTO> listaDepartamento = controladorDepartamentos.buscarDepartamento(id, nombre, descripcion,
				activo);

		for (DepartamentoDTO departamento : listaDepartamento) {
			System.out.println(departamento);
		}

	}

	public void menuInsertarDepartamento() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el nombre del departamento");
		String nombre = sc.nextLine();

		System.out.println("Introduzca por favor la descripcion del departamento");
		String descripcion = sc.nextLine();

		System.out.println("Introduzca por favor el activo del departamento");
		String activo = sc.nextLine();

		DepartamentosController controladorDepartamentos = new DepartamentosController();
		int resultado = controladorDepartamentos.insertarDepartamento(nombre, descripcion, activo);

		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}

	public void menuActualizarDepartamento() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el id del departamento");
		String id = sc.nextLine();

		System.out.println("Introduzca por favor el nombre del departamento");
		String nombre = sc.nextLine();

		System.out.println("Introduzca por favor la descripcion del departamento");
		String descripcion = sc.nextLine();

		System.out.println("Introduzca por favor el activo del departamento");
		String activo = sc.nextLine();

		DepartamentosController controladorDepartamentos = new DepartamentosController();
		int resultado = controladorDepartamentos.actualizarDepartamento(id,nombre, descripcion, activo);

		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}
	
	public void menuBorrarDepartamento() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el ID del departamento");
		String id = sc.nextLine();
		
		
		DepartamentosController controladorDepartamentos = new DepartamentosController();
		int resultado = controladorDepartamentos.borrarDepartamento (id);
		
		if (resultado == 1) {
			System.out.println("Se ha borrado el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
		
	}

}
