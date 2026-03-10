import java.util.Scanner;

public class SistemaControl {
    private Ascensor ascensor;
    private Piso[] pisos;
    private Puerta puertaAscensor;

    public SistemaControl(int numPisos) {
        ascensor = new Ascensor();
        pisos = new Piso[numPisos];
        puertaAscensor = new Puerta();

        for (int i = 0; i < numPisos; i++) {
            pisos[i] = new Piso(i);
        }
    }

    public void iniciarSimulacion() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n========= SISTEMA DE CONTROL DE ASCENSOR =========");
            System.out.println("Piso actual del ascensor: " + ascensor.getPisoActual());
            System.out.println("1. Llamar ascensor desde un piso");
            System.out.println("2. Seleccionar piso destino dentro del ascensor");
            System.out.println("3. Salir del programa");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> llamarAscensor(sc);
                case 2 -> seleccionarDestino(sc);
                case 3 -> System.out.println("👋 Saliendo del sistema...");
                default -> System.out.println("❌ Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 3);

        sc.close();
    }

    private void llamarAscensor(Scanner sc) {
        System.out.print("Ingrese el número del piso desde donde llama el ascensor (0-" + (pisos.length - 1) + "): ");
        int pisoLlamada = sc.nextInt();

        if (pisoLlamada < 0 || pisoLlamada >= pisos.length) {
            System.out.println("⚠️ Piso inválido.");
            return;
        }

        System.out.println("🚨 Llamada recibida desde el piso " + pisoLlamada);
        ascensor.mover(pisoLlamada);
        puertaAscensor.abrir();
    }

    private void seleccionarDestino(Scanner sc) {
        if (!puertaAscensor.estaAbierta()) {
            System.out.println("🚪 Las puertas están cerradas. No se puede seleccionar un piso.");
            return;
        }

        System.out.print("Ingrese el piso de destino (0-" + (pisos.length - 1) + "): ");
        int destino = sc.nextInt();

        if (destino < 0 || destino >= pisos.length) {
            System.out.println("⚠️ Piso inválido.");
            return;
        }

        puertaAscensor.cerrar();
        ascensor.mover(destino);
        puertaAscensor.abrir();
    }

    public void iniciar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iniciar'");
    }
}
