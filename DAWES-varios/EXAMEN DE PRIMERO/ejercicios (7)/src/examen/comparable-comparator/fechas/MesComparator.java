package fechas;

import java.util.Comparator;

public class MesComparator implements Comparator<Fecha> {

    @Override
    public int compare(Fecha f1, Fecha f2) {
        return Integer.compare(f1.mes, f2.mes);
    }
    
}
