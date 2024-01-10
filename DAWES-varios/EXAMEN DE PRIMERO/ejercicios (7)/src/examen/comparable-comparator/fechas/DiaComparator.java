comopackage fechas;

import java.util.Comparator;

public class DiaComparator implements Comparator<Fecha> {

    @Override
    public int compare(Fecha f1, Fecha f2) {
        return f1.dia - f2.dia;
    }
    
}
