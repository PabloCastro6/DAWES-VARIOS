import java.util.ArrayList;

public class Ejercicio5 {
    public static void main(String[] args) {
        ArrayList<Integer> golesLocales = new ArrayList<>();
        golesLocales.add(2);
        golesLocales.add(2);
        golesLocales.add(0);

        ArrayList<Integer> golesVisitantes = new ArrayList<>();
        golesVisitantes.add(3);
        golesVisitantes.add(2);
        golesVisitantes.add(3);

        ArrayList<String> quiniela = new ArrayList<>();
        quiniela.add("X");
        quiniela.add("1");
        quiniela.add("2");

        int aciertos = 0;

        for (int i = 0; i < golesLocales.size(); i++) {
            int golesLocal = golesLocales.get(i);
            int golesVisitante = golesVisitantes.get(i);
            String valorQuiniela = quiniela.get(i);
            switch (valorQuiniela) {
                case "1":
                    if (golesLocal > golesVisitante) {
                        aciertos++;
                    }
                    break;
                case "X":
                    if (golesLocal == golesVisitante) {
                        aciertos++;
                    }
                    break;
                case "2":
                    if (golesLocal < golesVisitante) {
                        aciertos++;
                    }
                    break;
                default:
                    System.out.printf("Valor incorrecto en la posición %d de la quiniela: %s\n", i, valorQuiniela);
                    break;
            }
        }

        System.out.println("Número de aciertos: " + aciertos + "/" + golesLocales.size());
    }
}
