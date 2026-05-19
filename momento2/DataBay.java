package momento2;

import java.util.*;

public class DataBay {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            Contenedor[] manifiesto = new Contenedor[5];
            double pesoTotal = 0;

            System.out.println("=== REGISTRO DE MANIFIESTO ===");

            for (int i = 0; i < manifiesto.length; i++) {

                System.out.println("\nContenedor " + (i + 1));

                System.out.print("ID: ");
                String id = sc.next();

                System.out.print("Peso: ");
                double peso = sc.nextDouble();

                System.out.print("Prioridad: ");
                int prioridad = sc.nextInt();

                manifiesto[i] = new Contenedor(id, peso, prioridad);
                pesoTotal += peso;
            }

            System.out.println("\nPeso total de carga: " + pesoTotal);

            Contenedor[][] patio = new Contenedor[3][3];

            System.out.println("\n=== UBICACIÓN EN PATIO ===");

            for (Contenedor c : manifiesto) {

                boolean ubicado = false;

                for (int i = 0; i < patio.length && !ubicado; i++) {
                    for (int j = 0; j < patio[i].length; j++) {

                        if (patio[i][j] == null) {
                            patio[i][j] = c;
                            System.out.println(c.getId() + " ubicado en [" + i + "," + j + "]");
                            ubicado = true;
                            break;
                        }
                    }
                }

                if (!ubicado) {
                    System.out.println("⚠ Puerto Saturado");
                }
            }
            Queue<Contenedor> inspeccion = new LinkedList<>();

            for (Contenedor c : manifiesto) {
                if (c.getPrioridad() >= 8) {
                    inspeccion.add(c);
                }
            }

            System.out.println("\n=== INSPECCIÓN (FIFO) ===");

            while (!inspeccion.isEmpty()) {
                System.out.println("Revisando: " + inspeccion.poll());
            }
            Stack<Contenedor> buque = new Stack<>();

            System.out.println("\n=== CARGA EN BUQUE ===");

            for (Contenedor c : manifiesto) {
                apilarConRestriccion(buque, c);
            }

            System.out.println("\nEstado final del buque:");

            for (Contenedor c : buque) {
                System.out.println(c);
            }
            retirarContenedorDanado(buque, "C2");
        }
    }
    public static void apilarConRestriccion(Stack<Contenedor> buque, Contenedor nuevo) {

        if (buque.isEmpty()) {
            buque.push(nuevo);
        } else {

            Contenedor top = buque.peek();

            if (nuevo.getPeso() <= top.getPeso()) {
                buque.push(nuevo);
            } else {
                System.out.println("❌ No se puede apilar " + nuevo.getId() +
                        " (peso mayor que el tope)");
            }
        }
    }
    public static void retirarContenedorDanado(Stack<Contenedor> buque, String idDanado) {

        Stack<Contenedor> auxiliar = new Stack<>();

        boolean encontrado = false;

        while (!buque.isEmpty()) {

            Contenedor c = buque.pop();

            if (c.getId().equals(idDanado)) {
                System.out.println("\n⚠ Contenedor dañado retirado: " + c);
                encontrado = true;
                break;
            } else {
                auxiliar.push(c);
            }
        }

        while (!auxiliar.isEmpty()) {
            buque.push(auxiliar.pop());
        }

        if (!encontrado) {
            System.out.println("\nNo se encontró el contenedor dañado: " + idDanado);
        }
    }
}