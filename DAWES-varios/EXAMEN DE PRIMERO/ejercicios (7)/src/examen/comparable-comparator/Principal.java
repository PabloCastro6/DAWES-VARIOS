import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import fechas.AnnoComparator;
import fechas.DiaComparator;
import fechas.Fecha;
import fechas.MesComparator;

public class Principal {
    public static void main(String[] args) {
        List<Fecha> fechas = Arrays.asList(
            new Fecha(2023, 8, 15),
            new Fecha(2024, 5, 15),
            new Fecha(2022, 5, 16)
        );

        System.out.println("Fechas ordenadas por defecto");
        Collections.sort(fechas);
        imprimeFechas(fechas);

        System.out.println("\nFechas ordenadas por día");
        Comparator<Fecha> comparator = new DiaComparator();
        Collections.sort(fechas, comparator);
        imprimeFechas(fechas);

        System.out.println("\nFechas ordenadas por mes");
        comparator = new MesComparator();
        Collections.sort(fechas, comparator);
        imprimeFechas(fechas);

        System.out.println("\nFechas ordenadas por año");
        comparator = new AnnoComparator();
        Collections.sort(fechas, comparator);
        imprimeFechas(fechas);
    }

    public static void imprimeFechas(List<Fecha> fechas) {
        for (Fecha fecha : fechas) {
            System.out.println(fecha);
        }
    }
}
