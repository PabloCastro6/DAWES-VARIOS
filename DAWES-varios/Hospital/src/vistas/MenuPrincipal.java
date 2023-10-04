package vistas;

import java.sql.SQLException;
import java.util.Scanner;

import utils.MiScanner;

public class MenuPrincipal {
	public void menuPrincipal() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n=0;
		do {
	    System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE HOSPITAL");
	    System.out.println("===============================================");

        System.out.println("1- Gestión de  Pacientes");
        System.out.println("2- Gestión de Médicos");
        System.out.println("3- Gestión de Citas");
        System.out.println("4- Gestión de Departamentos");
        System.out.println("5- Gestión de Historial Médico");
        System.out.println("6- Gestión de Facturación");
        System.out.println("7- Gestión de Farmacia");
        System.out.println("8- Gestión de Recetas Médicas");
        System.out.println("9- Gestión de Habitaciones");
        System.out.println("10- Gestión de Admisiones");
        System.out.println("11- Gestión de Alergias");
        System.out.println("12- Gestión de Estado de Citas");
        System.out.println("13- Gestión de Estado de Facturación");
        System.out.println("14- Salir");
	    
	  
	    n = Integer.parseInt(sc.nextLine());
	   
	    	
            if (n>14||n<1){
                System.out.print("Elección invalida, inténtalo otra vez...");
                continue;
            }
            if ( n == 2) {
            	System.out.println("ahora ejecutaría la gestión de Médicos");
            	continue;
            }
            if (n == 3) {
            	System.out.println("Ahora ejecutaría la gestión citas");
            	VistaCitas vc = new VistaCitas();
            	vc.menuGeneralCita();
            	continue;
            }
            
            if ( n == 11) {
            	VistaAlergias vc = new VistaAlergias();
            	vc.menuGeneralAlergias();
            	continue;
            }

	    } while(n!=14);
	}

}


