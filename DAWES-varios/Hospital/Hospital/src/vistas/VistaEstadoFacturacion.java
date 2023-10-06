import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

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
	
	for (EstadoFacturacionDTO estado : listaEstadoFacturacion) {
		System.out.println(estado.getId() + " " + estado.getestado());

	}
	
}





}
}
