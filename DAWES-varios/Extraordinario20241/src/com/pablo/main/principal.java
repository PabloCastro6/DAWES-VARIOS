package com.pablo.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.pablo.dto.ClienteDTO;
import com.pablo.model.ClientesModelo;


public class principal {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		ClientesModelo modelo = new ClientesModelo();

		Scanner s = new Scanner(System.in);

		int opcionMenu;

		do {
			System.out.println("Gestion de clientes");
			System.out.println("1. Agregar Cliente");
			System.out.println("2. Leer Cliente");
			System.out.println("3. Actualizar Cliente");
			System.out.println("4. Salir");

			opcionMenu = Integer.parseInt(s.nextLine());

			switch (opcionMenu) {
			case 1:

				System.out.println("Digame el id del cliente");
				int idCrear = Integer.parseInt(s.nextLine());
				System.out.println("Digame el nombre del cliente");
				String nombreCrear = s.nextLine();
				System.out.println("Digame la direccion del cliente");
				String direccionCrear = s.nextLine();
				System.out.println("Digame el telefono del cliente");
				String telefonoCrear = s.nextLine();
				System.out.println("Cliente AGREGADO");

				ClienteDTO clienteDTO = new ClienteDTO(idCrear, nombreCrear, direccionCrear, telefonoCrear);

				modelo.crearCliente(clienteDTO);

				break;

			case 2:

				System.out.println("Ingrese el id del cliente");
				int idLeer = Integer.parseInt(s.nextLine());
				

				modelo.leerCliente(idLeer);
				System.out.println("Cliente leido");
				break;

			case 3:

				System.out.println("Digame el id del cliente");
				int idUpdate = Integer.parseInt(s.nextLine());
				System.out.println("Digame el nombre del cliente");
				String nombreUpdate = s.nextLine();
				System.out.println("Digame la direccion del cliente");
				String direccionUpdate = s.nextLine();
				System.out.println("Digame el telefono del cliente");
				String telefonoUpdate = s.nextLine();
				System.out.println("Cliente ACTUALIZADO");

				ClienteDTO clienteDTtoActualizar = new ClienteDTO(idUpdate, nombreUpdate, direccionUpdate, telefonoUpdate);

				modelo.actualizarCliente(clienteDTtoActualizar);

				break;
			case 4:
				System.out.println("Saliendo...");
				break;
				
			default:
				System.out.println("Opcion invalida");
				break;

			}
		} while (opcionMenu != 4);

	}
}
