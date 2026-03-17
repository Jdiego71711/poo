import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random rand = new Random();

        // PASO 1: arreglo con 12 valores aleatorios entre 50 y 150
        int[] energiaContenedores = new int[12];

        System.out.println("Arreglo original:");
        for (int i = 0; i < energiaContenedores.length; i++) {
            energiaContenedores[i] = rand.nextInt(101) + 50;
            System.out.print(energiaContenedores[i] + " ");
        }

        // Filtrar múltiplos de 10
        int[] filtrados = new int[12];
        int contador = 0;

        for (int i = 0; i < energiaContenedores.length; i++) {
            if (energiaContenedores[i] % 10 == 0) {
                filtrados[contador] = energiaContenedores[i];
                contador++;
            }
        }

        // PASO 2: matriz 3x3
        int[][] mapaCarga = new int[3][3];

        int index = 0;

        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 3; col++) {

                if (index < contador) {
                    mapaCarga[fila][col] = filtrados[index];
                    index++;
                } else {
                    mapaCarga[fila][col] = -1;
                }

            }
        }

        System.out.println("\n\nMapa de carga:");
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(mapaCarga[fila][col] + "\t");
            }
            System.out.println();
        }

        // PASO 3: arreglo de objetos
        Suministro[] manifiesto = new Suministro[9];

        int pos = 0;

        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 3; col++) {

                int valor = mapaCarga[fila][col];

                if (valor != -1) {

                    String prioridad;

                    if (valor > 100) {
                        prioridad = "ALTA";
                    } else {
                        prioridad = "ESTÁNDAR";
                    }

                    String id = "C-" + fila + "-" + col;

                    manifiesto[pos] = new Suministro(id, valor, prioridad);

                } else {
                    manifiesto[pos] = null;
                }

                pos++;
            }
        }

        // Mostrar manifiesto
        System.out.println("\nManifiesto de vuelo:");

        for (int i = 0; i < manifiesto.length; i++) {
            System.out.println(manifiesto[i]);
        }

    }
}