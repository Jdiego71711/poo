package momento3;

public class ReporteAcademico {

    public void mostrarReporte(Estudiante estudiante) {

        Double[][] notas = estudiante.getNotas();

        for (int i = 0; i < notas.length; i++) {

            System.out.println("Semestre " + (i + 1));

            for (int j = 0; j < notas[i].length; j++) {

                if (notas[i][j] != null) {

                    System.out.println(
                            "Materia " + j +
                            ": " + notas[i][j]
                    );
                }
            }
        }

        System.out.println(
                "Promedio acumulado: " +
                estudiante.promedioAcumulado()
        );
    }
}