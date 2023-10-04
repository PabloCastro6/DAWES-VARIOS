package vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import controllers.AlergiasController;
import controllers.FarmaciaController;
import dtos.AlergiaDTO;
import dtos.FarmaciaDTO;
import utils.MiScanner;

public class VistaFarmacia {
public void menuGeneralFarmacia() throws ClassNotFoundException, SQLException {
		
		Scanner sc = MiScanner.getInstance();
		int n=0;
		do{
			System.out.println("Introduzca la operación que desee realizar: ");
			
		    System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE LA TABLA FARMACIA");
		    System.out.println("===========================================================");
		    System.out.println("1. Buscar farmacia");
		    System.out.println("2. Insertar farmacia");
		    System.out.println("3. Actualizar farmacia ");
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
            	menuBuscaFarmacia();
            	continue;
            }
            
            if ( n == 2) {
            	menuInsertaFarmacia();
            	continue;
            }
            
////            if ( n == 3) {
//            	menuActualizarFarmacia();
//            	continue;
//            }
	    	
	    } while(n!=6);
	
}

public void menuBuscaFarmacia() throws ClassNotFoundException, SQLException {
	Scanner sc = MiScanner.getInstance();
	System.out.println("Introduzca por favor el id de la Farmacia: ");
	String id = sc.nextLine();

	System.out.println("Introduzca por favor el medicamento de la farmacia: ");
	String medicamento = sc.nextLine();
	
	System.out.println("Introduzca por favor el nombre de la farmacia: ");
	String nombre = sc.nextLine();
	
	System.out.println("Introduzca por favor la descripcion de la farmacia: ");
	String descripcion = sc.nextLine();
	
	System.out.println("Introduzca por favor la cantidad disponible de la farmacia: ");
	String cantidadDisponible = sc.nextLine();
	
	System.out.println("Introduzca por favor el precio de la farmacia: ");
	String precio = sc.nextLine();
	
	FarmaciaController controladorFarmacia = new FarmaciaController();
	List <FarmaciaDTO> listaFarmacia = controladorFarmacia.buscarFarmacia(medicamento,  nombre,  descripcion,  cantidadDisponible, precio);
	
	for (FarmaciaDTO farmacia : listaFarmacia) {
		System.out.println(farmacia.getMedicamento() + " " + farmacia.getDescripcion());
		System.out.println(farmacia.getNombre() + " " + farmacia.getDescripcion());
		System.out.println(farmacia.getDescripcion() + " " + farmacia.getDescripcion());
		System.out.println(farmacia.getCantidadDisponible() + " " + farmacia.getDescripcion());
		System.out.println(farmacia.getPrecio() + " " + farmacia.getDescripcion());
		

	}
}
	
	public void menuInsertaFarmacia() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		

		System.out.println("Introduzca por favor el medicamento de la alergia: ");
		String medicamento = sc.nextLine();		
		
		System.out.println("Introduzca por favor el nombre de la alergia: ");
		String nombre = sc.nextLine();		
		
		System.out.println("Introduzca por favor la descripcion de la alergia: ");
		String descripcion = sc.nextLine();		
		
		
		System.out.println("Introduzca por favor la cantidad disponible de la alergia: ");
		String cantidadDisponible = sc.nextLine();		
		
		System.out.println("Introduzca por favor el precio de la alergia: ");
		String precio = sc.nextLine();
		


		
		FarmaciaController controladorFarmacia = new FarmaciaController();
		int resultado = controladorFarmacia.insertarFarmacia(medicamento,  nombre,  descripcion,  cantidadDisponible, precio);
		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}

	}

	
}

