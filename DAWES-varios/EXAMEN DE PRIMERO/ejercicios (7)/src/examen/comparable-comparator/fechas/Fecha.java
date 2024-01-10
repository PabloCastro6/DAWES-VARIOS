package fechas;

public class Fecha implements Comparable<Fecha> {
    public int dia;
    public int mes;
    public int anno;

    public Fecha(int anno, int mes, int dia) {
        this.anno = anno;
        this.mes = mes;
        this.dia = dia;
    }

    @Override
    public int compareTo(Fecha fecha) {
        if (fecha.anno != this.anno) {
            return this.anno - fecha.anno;
        }

        if (fecha.mes != this.mes) {
            return this.mes - fecha.mes;
        }

        if (fecha.dia != this.dia) {
            return this.dia - fecha.dia;
        }

        return 0;
    }

    @Override
    public String toString() {
        return this.dia + "/" + this.mes + "/" + this.anno; 
    }
    
}
