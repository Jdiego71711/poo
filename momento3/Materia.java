package momento3;

import java.util.LinkedList;
import java.util.Queue;

public class Materia {

    private String codigo;
    private String nombre;

    private int cuposDisponibles;

    private LinkedList<String> prerequisitos;

    private Queue<Estudiante> colaEspera;

    public Materia() {

        prerequisitos = new LinkedList<>();
        colaEspera = new LinkedList<>();
    }

    public Materia(String codigo, String nombre,
                    int cuposMaximos, int creditos) {

        this.codigo = codigo;
        this.nombre = nombre;

        this.cuposDisponibles = cuposMaximos;

        prerequisitos = new LinkedList<>();
        colaEspera = new LinkedList<>();
    }

    public void agregarPrerequisito(String materia) {
        prerequisitos.add(materia);
    }

    public void agregarColaEspera(Estudiante estudiante) {
        colaEspera.add(estudiante);
    }

    public Estudiante siguienteEnEspera() {
        return colaEspera.poll();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    public void setCuposDisponibles(int cuposDisponibles) {
        this.cuposDisponibles = cuposDisponibles;
    }

    public Queue<Estudiante> getColaEspera() {
        return colaEspera;
    }

    public LinkedList<String> getPrerequisitos() {
        return prerequisitos;
    }
}