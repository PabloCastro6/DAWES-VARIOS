package com.pract.classicmodels.vistas;

import java.sql.SQLException;
import java.util.Scanner;

import com.pract.classicmodels.utils.MiScanner;

public class MenuPrincipal {
	
	
	public void menuPrincipal() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n=0;
		do {
	    System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE LA TIENDA CLASSIC MODELS");
	    System.out.println("===============================================");
	    System.out.println("1. Gestión de clientes");
	    System.out.println("2. Salir");
	    System.out.println("===============================================");
	    
	  
	    n = Integer.parseInt(sc.nextLine());
	   
	    	
            if (n>2||n<1){
                System.out.print("Elección invalida, inténtalo otra vez...");
                continue;
            } else if ( n == 1) {
				VistaClientes vc = new VistaClientes();
				vc.menuGeneralCliente();
				continue;
			}
	    } while(n!=2);
	}

}
