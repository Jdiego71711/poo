import java.util.*;

public class Ejercicio10_3 {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        final int CARRITOS = 25;
        final int CAJAS = 3;

        // Cola de carritos disponibles
        Queue<Integer> carritos = new LinkedList<>();
        for (int i = 1; i <= CARRITOS; i++) {
            carritos.add(i);
        }

        // 3 cajas (colas)
        Queue<Integer>[] cajas = new Queue[CAJAS];
        for (int i = 0; i < CAJAS; i++) {
            cajas[i] = new LinkedList<>();
        }

        Scanner sc = new Scanner(System.in);
        int clienteId = 1;

        System.out.println("Simulación supermercado");
        System.out.println("1 = llega cliente, 2 = pagar en caja, 0 = salir");

        while (true) {
            int opcion = sc.nextInt();

            if (opcion == 0) break;

            switch (opcion) {

                case 1: // Llega cliente
                    if (carritos.isEmpty()) {
                        System.out.println("No hay carritos, cliente espera...");
                    } else {
                        int carrito = carritos.poll();
                        System.out.println("Cliente " + clienteId + " toma carrito " + carrito);

                        // Elegir la caja con menos gente
                        int mejorCaja = 0;
                        for (int i = 1; i < CAJAS; i++) {
                            if (cajas[i].size() < cajas[mejorCaja].size()) {
                                mejorCaja = i;
                            }
                        }

                        cajas[mejorCaja].add(clienteId);
                        System.out.println("Cliente " + clienteId + " va a caja " + (mejorCaja + 1));

                        clienteId++;
                    }
                    break;

                case 2: // Atender en caja
                    System.out.println("¿Qué caja (1-3)?");
                    int caja = sc.nextInt() - 1;

                    if (caja < 0 || caja >= CAJAS) {
                        System.out.println("Caja inválida");
                        break;
                    }

                    if (cajas[caja].isEmpty()) {
                        System.out.println("Caja vacía");
                    } else {
                        int cliente = cajas[caja].poll();
                        carritos.add(cliente); // libera carrito
                        System.out.println("Cliente " + cliente + " ha pagado y deja carrito disponible");
                    }
                    break;
            }
        }

        // Estado final
        System.out.println("\nEstado final:");
        for (int i = 0; i < CAJAS; i++) {
            System.out.println("Caja " + (i + 1) + ": " + cajas[i]);
        }
        System.out.println("Carritos disponibles: " + carritos.size());

        sc.close();
    }
}