import java.util.Scanner;
import java.util.Stack;

public class Ejercicio9_4 {

    public static void main(String[] args) {
        final int N = 5;

        // Crear las 5 pilas
        @SuppressWarnings("unchecked")
        Stack<Integer>[] pilas = new Stack[N];
        for (int i = 0; i < N; i++) {
            pilas[i] = new Stack<>();
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce pares (i, j). i=0 para terminar:");

        while (true) {
            int i = sc.nextInt();

            if (i == 0) {
                break;
            }

            int j = sc.nextInt();

            int indice = Math.abs(i) - 1; // convertir a índice 0-4

            if (indice < 0 || indice >= N) {
                System.out.println("Índice fuera de rango");
                continue;
            }

            if (i > 0) {
                // Insertar
                pilas[indice].push(j);
            } else {
                // Eliminar
                if (!pilas[indice].isEmpty()) {
                    pilas[indice].pop();
                } else {
                    System.out.println("Pila P" + (indice + 1) + " vacía");
                }
            }
        }

        // Mostrar contenido de las pilas
        System.out.println("\nContenido de las pilas:");
        for (int k = 0; k < N; k++) {
            System.out.println("P" + (k + 1) + ": " + pilas[k]);
        }

        sc.close();
    }
}