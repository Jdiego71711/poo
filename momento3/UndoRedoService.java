package momento3;

import java.util.Stack;

public class UndoRedoService {

    private Stack<String> pilaDeshacer;
    private Stack<String> pilaRehacer;

    public UndoRedoService() {

        pilaDeshacer = new Stack<>();
        pilaRehacer = new Stack<>();
    }

    public void guardarOperacion(String operacion) {

        pilaDeshacer.push(operacion);
    }

    public void deshacer() {

        if (pilaDeshacer.isEmpty()) {

            throw new RuntimeException(
                    "No hay operaciones para deshacer"
            );
        }

        String operacion = pilaDeshacer.pop();

        pilaRehacer.push(operacion);

        System.out.println(
                "Operacion deshecha: " + operacion
        );
    }

    public void rehacer() {

        if (pilaRehacer.isEmpty()) {

            throw new RuntimeException(
                    "No hay operaciones para rehacer"
            );
        }

        String operacion = pilaRehacer.pop();

        pilaDeshacer.push(operacion);

        System.out.println(
                "Operacion rehecha: " + operacion
        );
    }
}