package momento3;

import java.util.HashMap;
import java.util.Map;

public class EstudianteService {

    private Map<String, Estudiante> estudiantes;

    public EstudianteService() {
        estudiantes = new HashMap<>();
    }

    public void registrarEstudiante(Estudiante estudiante) {

        estudiantes.put(
                estudiante.getId(),
                estudiante
        );
    }

    public Estudiante buscarPorId(String id) {

        return estudiantes.get(id);
    }

    public void eliminarEstudiante(String id) {

        estudiantes.remove(id);
    }

    public void listarEstudiantes() {

        for (Estudiante estudiante : estudiantes.values()) {

            estudiante.mostrarInformacion();
        }
    }
}