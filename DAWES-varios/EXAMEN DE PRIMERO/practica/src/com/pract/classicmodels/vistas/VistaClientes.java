package com.pract.classicmodels.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.pract.classicmodels.controllers.ClientesController;
import com.pract.classicmodels.dtos.ClienteDTO;
import com.pract.classicmodels.utils.MiScanner;

public class VistaClientes {
	
	public void menuGeneralCliente() throws ClassNotFoundException, SQLException {
	
			Scanner sc = MiScanner.getInstance();
			int n=0;
			do{
				System.out.println("Introduzca la operación que desee realizar: ");
				
			    System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE CLIENTES");
			    System.out.println("===============================================");
			    System.out.println("1. Buscar cliente por id");
			    System.out.println("2. Insertar cliente ");
			    System.out.println("3. Actualizar cliente ");
			    System.out.println("4. Borrar cliente");
			    System.out.println("5. Volver al menú principal");
			    System.out.println("===============================================");
			    
			    n = Integer.parseInt(sc.nextLine());
		    
	            if (n == 5){
	                
	                return;
	            }
		    	
	            if (n>6||n<1){
	                System.out.print("Elección invalida, inténtalo otra vez...");
	                continue;
	            }
	            if ( n == 1) {
					menuRecuperaNombre();

	            	continue;
	            }  else if ( n == 2) {
					menuInsertaCliente();
					continue;
				}else if ( n == 3) {
					menuActualizaCliente();
					continue;
				}else if ( n == 4) {
					menuBorraCliente();
					continue;
				}
		    	
		    } while(n!=5);

	}

	
	public void menuRecuperaNombre() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el ID del cliente: ");
		
		Integer emp = Integer.valueOf(sc.nextLine());
		
		ClientesController controladorClientes = new ClientesController();
		List <ClienteDTO> listaClientes = controladorClientes.recuperaDatos(emp);
		
		for (ClienteDTO cliente : listaClientes) {
			System.out.println(cliente.getNombre() + " " + cliente.getTelefono());

		}
		
	}

	
	public void menuInsertaCliente() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el nombre del cliente: ");
		String nombreCliente = sc.nextLine();		
		System.out.println("Introduzca por favor el apellido del cliente: ");
		String apellido = sc.nextLine();
		System.out.println("Introduzca por favor el tel�fono del cliente: ");
		String telefono = sc.nextLine();		
		System.out.println("Introduzca por favor la direcci�n del cliente: ");
		String direccion1 = sc.nextLine();		

		ClientesController controladorClientes = new ClientesController();
		int resultado = controladorClientes.insertarCliente(
											nombreCliente, 
											direccion1, apellido,
											telefono
											);
		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con �xito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
		
	}
	
	public void menuActualizaCliente() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el n�mero del cliente a actualizar: ");
		int  numeroCliente = Integer.parseInt(sc.nextLine());
		System.out.println("Introduzca por favor el nombre del cliente: ");
		String nombreCliente = sc.nextLine();
		System.out.println("Introduzca por favor el apellido del cliente: ");
		String apellido = sc.nextLine();
		System.out.println("Introduzca por favor el tel�fono del cliente: ");
		String telefono = sc.nextLine();
		System.out.println("Introduzca por favor la direcci�n del cliente: ");
		String direccion1 = sc.nextLine();

		ClientesController controladorClientes = new ClientesController();
		int resultado = controladorClientes.actualizarCliente(
				nombreCliente,
				direccion1, apellido,
				telefono,numeroCliente);
		if (resultado == 1) {
			System.out.println("Se ha actualizado el cliente con el n�mero: " + numeroCliente +" con �xito");
		} else {
			System.out.println("Se ha producido un error al actualizar el cliente con el n�mero: "+ numeroCliente);
		}
		
	}
	
	public void menuBorraCliente() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el n�mero del cliente a borrar: ");
		int  numeroCliente = Integer.parseInt(sc.nextLine());	
		
		ClientesController controladorClientes = new ClientesController();
		int resultado = controladorClientes.borrarCliente(numeroCliente);
		
		if (resultado == 1) {
			System.out.println("Se ha borrado el cliente con el número: " + numeroCliente +" con éxito");
		} else {
			System.out.println("Se ha producido un error al borrar el cliente con el número: "+ numeroCliente);
		}
	}

}
