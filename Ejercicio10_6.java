import java.util.*;

public class Ejercicio10_6 {

    static Random rand = new Random();

    // Generar número aleatorio en rango
    static double random(double min, double max) {
        return min + (max - min) * rand.nextDouble();
    }

    public static void main(String[] args) {

        final int TIEMPO_TOTAL = 420; // minutos (7 horas)

        Queue<Integer> cola = new LinkedList<>();

        double[] cajas = new double[4]; // tiempo en que quedan libres
        boolean caja4Activa = false;

        double tiempo = 0;
        double proximaLlegada = random(0.5, 1.5);

        int clientesAtendidos = 0;
        int maxCola = 0;
        double sumaCola = 0;
        int mediciones = 0;
        double maxEspera = 0;
        double tiempoCaja4 = 0;

        Map<Integer, Double> llegadaCliente = new HashMap<>();
        int idCliente = 1;

        while (tiempo < TIEMPO_TOTAL) {

            // Llegada de cliente
            if (tiempo >= proximaLlegada) {
                cola.add(idCliente);
                llegadaCliente.put(idCliente, tiempo);
                idCliente++;

                proximaLlegada += random(0.5, 1.5);
            }

            // Activar caja 4
            if (cola.size() > 20) {
                caja4Activa = true;
            }

            // Atender clientes en cajas
            for (int i = 0; i < 4; i++) {

                if (i == 3 && !caja4Activa) continue;

                if (cajas[i] <= tiempo && !cola.isEmpty()) {

                    int cliente = cola.poll();
                    double espera = tiempo - llegadaCliente.get(cliente);
                    maxEspera = Math.max(maxEspera, espera);

                    double servicio = 0;

                    switch (i) {
                        case 0: servicio = random(1.5, 2.5); break;
                        case 1: servicio = random(2, 5); break;
                        case 2: servicio = random(2, 4); break;
                        case 3: servicio = random(2, 4.5); break;
                    }

                    cajas[i] = tiempo + servicio;
                    clientesAtendidos++;
                }
            }

            // Cerrar caja 4 si ya no hay cola
            if (caja4Activa && cola.isEmpty()) {
                caja4Activa = false;
            }

            if (caja4Activa) {
                tiempoCaja4++;
            }

            maxCola = Math.max(maxCola, cola.size());
            sumaCola += cola.size();
            mediciones++;

            tiempo++;
        }

        double mediaCola = sumaCola / mediciones;

        // Resultados
        System.out.println("Clientes atendidos: " + clientesAtendidos);
        System.out.println("Tamaño medio de cola: " + mediaCola);
        System.out.println("Tamaño máximo de cola: " + maxCola);
        System.out.println("Tiempo máximo de espera: " + maxEspera);
        System.out.println("Tiempo caja 4 abierta: " + tiempoCaja4 + " minutos");
    }
}