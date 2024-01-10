import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Principal {
    public static void main(String[] args) {
        try {
            Map<String, Integer> palabras = leerPalabras("palabras.txt"); // Un mapa (clave, valor). Clave = palabra, valor = contador
            FileReader fileReader = new FileReader("ElQuijote.txt", Charset.forName("utf8"));
            BufferedReader br = new BufferedReader(fileReader);
            String linea;
            // Recorre todas las líneas del fichero ElQuijote.text
            while ((linea = br.readLine()) != null) {
                // Recorre cada una de las palabras del archivo palabras.txt
                for (Entry<String, Integer> entry : palabras.entrySet()) {
                    // Alternativa: linea.contains(entry.getKey()) -> Comprueba si la línea del texto contiene la palabra.
                    // Puede dar falsos positivos. P.ej: "donar".contains("don") devuelve true.

                    // Separa la línea por palabras (espacios en blanco). No va a separar los signos de puntuación como puntos, comas... por lo que 
                    for (String palabra : linea.split(" ")) {
                        // palabra.equalsIgnoreCase -> Compara palabras sin tener en cuenta mayúsculas y minúsculas

                        // Compara la palabra de la línea con cada una de las palabras de palabras.txt
                        if (palabra.equals(entry.getKey())) {
                            // Si la palabra coincide, se aumenta su contador
                            entry.setValue(entry.getValue() + 1);
                        }
                    }
                }
            }
            br.close();
            for (Entry<String, Integer> entry : palabras.entrySet()) {
                System.out.println(entry);
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }

    public static Map<String, Integer> leerPalabras(String archivo) throws IOException {
        Map<String, Integer> palabras = new HashMap<String, Integer>();
        FileReader fileReader = new FileReader(archivo, Charset.forName("utf8"));
        BufferedReader br = new BufferedReader(fileReader);
        String linea;
        while ((linea = br.readLine()) != null) {
            palabras.put(linea, 0);
        }
        br.close();
        return palabras;
    }
}
