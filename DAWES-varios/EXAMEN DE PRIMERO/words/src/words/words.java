package words;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

class words{ 


	   public static void main(String args[]) throws IOException{  
			
				System.out.println("Introduzca por favor la palabra : ");
				
				Scanner  sc= new Scanner(System.in);
		
				String palabra = sc.nextLine();			

				System.out.println("Introduzca por favor el path del fichero : ");
				String fichero = sc.nextLine();			
		
				File file = new File(fichero);
				int count=0;
					

				try(Scanner sc1 = new Scanner(new FileInputStream(file))){
					while(sc1.hasNext()){
						if (palabra.equalsIgnoreCase(sc1.next()))
							count++;
					}
					System.out.println("Ocurrencias: " + count);
				}
				
			
FileWriter miWriter = null;
try {
	miWriter = new FileWriter ("C:\\Users\\daw2118\\Desktop\\hola.txt", true);
	miWriter.write("ha aparecido " + count + " veces.");
miWriter.close();
System.out.println("Se ha escrito en el fichero");

}catch (IOException e) {
	System.out.println("Ha ocurrido un error de entrada y salida");
	e.printStackTrace();
}finally {
	if (miWriter != null) {
		miWriter.close();
	}
}
	   }


}

