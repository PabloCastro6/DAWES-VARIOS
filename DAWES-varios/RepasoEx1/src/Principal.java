import java.io.IOException;

public class Principal {

	public static void main (String[] args) throws IOException {
		Funcionamiento funcionamiento = new Funcionamiento();
		
		// funcionamiento.flujoPrincipal();
		
		funcionamiento.copiarArchivo("C:\\Users\\Usuario\\Desktop\\Repo DAWES\\DAWES-VARIOS\\DAWES-varios\\RepasoEx1\\Resultado.txt", "C:\\Users\\Usuario\\Desktop\\Repo DAWES\\DAWES-VARIOS\\DAWES-varios\\RepasoEx1\\Resultado2.txt");
	}
}
