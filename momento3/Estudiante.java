package momento3;

import java.util.LinkedList;

public class Estudiante extends Persona {

    private int semestre;

    private Double[][] notas = new Double[10][20];

    private LinkedList<String> historialMaterias;

    public Estudiante() {
        historialMaterias = new LinkedList<>();
    }

    public Estudiante(String nombre, String id, String email, int semestre) {
        super(nombre, id, email);
        this.semestre = semestre;
        this.historialMaterias = new LinkedList<>();
    }

    @Override
    public void mostrarInformacion() {

        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
        System.out.println("Semestre: " + semestre);
    }

    public void registrarNota(int semestre, int materia, double nota) {
        notas[semestre][materia] = nota;
    }

    public double promedioAcumulado() {

        double suma = 0;
        int contador = 0;

        for (int i = 0; i < notas.length; i++) {

            for (int j = 0; j < notas[i].length; j++) {

                if (notas[i][j] != null) {
                    suma += notas[i][j];
                    contador++;
                }
            }
        }

        return contador == 0 ? 0 : suma / contador;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Double[][] getNotas() {
        return notas;
    }

    public LinkedList<String> getHistorialMaterias() {
        return historialMaterias;
    }
}