package momento3;

public class Aula {

    private String nombre;

    private boolean[][] horarios;

    public Aula(String nombre) {

        this.nombre = nombre;

        this.horarios = new boolean[7][24];
    }

    public boolean consultarDisponibilidad(int dia, int hora) {

        return !horarios[dia][hora];
    }

    public void reservar(int dia, int hora, int duracion) {

        for (int i = hora; i < hora + duracion; i++) {

            if (horarios[dia][i]) {

                throw new RuntimeException(
                        "Horario ocupado"
                );
            }
        }

        for (int i = hora; i < hora + duracion; i++) {

            horarios[dia][i] = true;
        }
    }

    public void liberar(int dia, int hora, int duracion) {

        for (int i = hora; i < hora + duracion; i++) {

            horarios[dia][i] = false;
        }
    }

    public String getNombre() {
        return nombre;
    }
}