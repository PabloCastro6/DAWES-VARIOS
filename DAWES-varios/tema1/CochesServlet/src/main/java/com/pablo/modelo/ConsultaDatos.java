package com.pablo.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


//	@Component ("")
	public class ConsultaDatos {

		public BufferedReader consultaEdad(String nombre)  throws IOException {

			File f = new File("C:\\Users\\alumnofp\\Desktop\\Git DAWES\\DAWES-VARIOS\\DAWES-VARIOS\\DAWES-varios\\tema1\\TipoCoches.txt");
			BufferedReader lector = new BufferedReader(new FileReader(f));;
			return lector;
		}
	}
			return null;
		}

	}

