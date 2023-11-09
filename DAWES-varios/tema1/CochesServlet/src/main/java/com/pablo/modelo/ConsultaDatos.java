package com.pablo.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ConsultaDatos {

    public String consultaEdad(String nombre) throws IOException {

        File file = new File("C:\\Users\\alumnofp\\Desktop\\Git DAWES\\DAWES-VARIOS\\DAWES-VARIOS\\DAWES-varios\\tema1\\TipoCoches.txt");
        BufferedReader lector = new BufferedReader(new FileReader(file));
        String linea;

        while ((linea = lector.readLine()) != null) {
            if (linea.contains(nombre)) {
                return linea;
            }
        }

        return null;
    }
}

		
	
