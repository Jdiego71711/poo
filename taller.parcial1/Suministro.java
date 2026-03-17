public class Suministro {

    String id;
    int nivelEnergia;
    String prioridad;

    // Constructor
    public Suministro(String id, int nivelEnergia, String prioridad) {
        this.id = id;
        this.nivelEnergia = nivelEnergia;
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Suministro{" +
                "id='" + id + '\'' +
                ", nivelEnergia=" + nivelEnergia +
                ", prioridad='" + prioridad + '\'' +
                '}';
    }
}