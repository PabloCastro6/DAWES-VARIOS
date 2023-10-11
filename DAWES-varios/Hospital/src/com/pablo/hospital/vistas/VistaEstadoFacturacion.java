package com.pablo.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.pablo.hospital.controllers.EstadoFacturacionController;
import com.pablo.hospital.dtos.EstadoFacturacionDTO;
import com.pablo.hospital.utils.MiScanner;




public class VistaEstadoFacturacion {

public void menuEstadoFacturacion() throws ClassNotFoundException, SQLException {
		
		Scanner sc = MiScanner.getInstance();
		int n=0;
		do{
			System.out.println("Introduzca la operación que desee realizar: ");
			
		    System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE LA TABLA ESTADO FACTURACION ");
		    System.out.println("===========================================================");
		    System.out.println("1. Buscar alergia");
		    System.out.println("2. Insertar alergia");
		    System.out.println("3. Actualizar alergia ");
		    System.out.println("4. Volver al menú principal");
		    System.out.println("===============================================");
		    
		    n = Integer.parseInt(sc.nextLine());
	    
            if (n == 6){
                
                return;
            }
	    	
            if (n>4||n<1){
                System.out.print("Elección inválida, inténtalo otra vez...");
                continue;
            }
            if ( n == 1) {
            	menuBuscaEstadoFacturacion();
            	continue;
            }
            
            if ( n == 2) {
            	menuInsertaEstadoFacturacion();
            	continue;
            }
            
            if ( n == 3) {
            	menuActualizarEstadoFacturacion();
            	continue;
            }
	    	
	    } while(n!=6);
	
}


public void menuBuscaEstadoFacturacion() throws ClassNotFoundException, SQLException {
	Scanner sc = MiScanner.getInstance();
	
	System.out.println("Introduzca por favor el id del estado de facturacion: ");
	String id = sc.nextLine();

	System.out.println("Introduzca por favor el estado de facturacion: ");
	String estado = sc.nextLine();
	
	EstadoFacturacionController controlarEstadoFacturacion = new EstadoFacturacionController();
	List <EstadoFacturacionDTO> listaEstadoFacturacion = controlarEstadoFacturacion.buscarEstadoFacturacion(id, estado);
	
	for (EstadoFacturacionDTO estado1 : listaEstadoFacturacion) {
		System.out.println(estado1.getID() + " " + estado1.getEstado());

	}
	
}

public void menuInsertaEstadoFacturacion() throws ClassNotFoundException, SQLException {
	Scanner sc  = MiScanner.getInstance();
	
	System.out.println("Introduza por favor el id del paciente");
	String id = sc.nextLine();
	
	System.out.println("Introduzca por favor el estado de facturacion");
	String estado = sc.nextLine();
	
	EstadoFacturacionController controladorFacturacion = new EstadoFacturacionController();
	int resultado = controladorFacturacion.insertarEstadoFacturacion(id, estado);
	if(resultado == 1 ) {
		System.out.println("Se ha introducido el registro con éxito");
	}else {
		System.out.println("Se ha producido un error al introducir el registro");
	}
	
}

private void menuActualizarEstadoFacturacion() throws ClassNotFoundException, SQLException {
	Scanner sc = MiScanner.getInstance();
	
	System.out.println("Introduzca por favor el id de Estado de facturacion");
	String iD = sc.nextLine();
	
	System.out.println("Introduzca por favor el estado de facturacion");
	String estado = sc.nextLine();
	
	
	EstadoFacturacionController controladorFacturacion = new EstadoFacturacionController();
	int resultado = controladorFacturacion.insertarEstadoFacturacion(iD, estado);
	if(resultado == 1 ) {
		System.out.println("Se ha introducido el registro con éxito");
	}else {
		System.out.println("Se ha producido un error al introducir el registro");
	}
	
}
}


