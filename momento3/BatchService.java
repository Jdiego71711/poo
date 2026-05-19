package momento3;

import java.util.LinkedList;
import java.util.Queue;

public class BatchService {

    private Queue<SolicitudInscripcion> cola;

    public BatchService() {

        cola = new LinkedList<>();
    }

    public void agregarSolicitud(
            SolicitudInscripcion solicitud) {

        cola.add(solicitud);
    }

    public void procesar() {

        while (!cola.isEmpty()) {

            SolicitudInscripcion solicitud =
                    cola.poll();

            System.out.println(
                    solicitud.getIdEstudiante()
                    + " -> " +
                    solicitud.getCodigoMateria()
            );
        }
    }
}