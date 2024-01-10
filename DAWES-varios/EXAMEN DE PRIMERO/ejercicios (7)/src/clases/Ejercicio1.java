import java.util.ArrayList;
import ejercicio1.Partido;

public class Ejercicio1 {
    public static void main(String[] args) {
        ArrayList<Partido> partidos = new ArrayList<>();
        partidos.add(new Partido(2, 3));
        partidos.add(new Partido(2, 2));
        partidos.add(new Partido(0, 3));

        ArrayList<String> quiniela = new ArrayList<>();
        quiniela.add("X");
        quiniela.add("1");
        quiniela.add("2");

        int aciertos = 0;

        for (int i = 0; i < partidos.size(); i++) {
            Partido partido = partidos.get(i);
            String valorQuiniela = quiniela.get(i);
            switch (valorQuiniela) {
                case "1":
                    if (partido.golesLocal > partido.golesVisitante) {
                        aciertos++;
                    }
                    break;
                case "X":
                    if (partido.golesLocal == partido.golesVisitante) {
                        aciertos++;
                    }
                    break;
                case "2":
                    if (partido.golesLocal < partido.golesVisitante) {
                        aciertos++;
                    }
                    break;
                default:
                    System.out.println("Valor incorrecto: " + valorQuiniela);
                    break;
            }
        }

        System.out.println("Número de aciertos: " + aciertos + "/" + partidos.size());
    }
}
