package momento3;

import java.util.Arrays;

public class Dijkstra {

    private int[][] grafo;

    public Dijkstra(int vertices) {

        grafo = new int[vertices][vertices];
    }

    public void agregarConexion(
            int origen,
            int destino,
            int distancia) {

        grafo[origen][destino] = distancia;

        grafo[destino][origen] = distancia;
    }

    public void dijkstra(int origen) {

        int n = grafo.length;

        int[] distancias = new int[n];

        boolean[] visitados = new boolean[n];

        Arrays.fill(
                distancias,
                Integer.MAX_VALUE
        );

        distancias[origen] = 0;

        for (int i = 0; i < n - 1; i++) {

            int u = distanciaMinima(
                    distancias,
                    visitados
            );

            visitados[u] = true;

            for (int v = 0; v < n; v++) {

                if (!visitados[v]
                        && grafo[u][v] != 0
                        && distancias[u] != Integer.MAX_VALUE
                        && distancias[u] + grafo[u][v]
                        < distancias[v]) {

                    distancias[v] =
                            distancias[u]
                            + grafo[u][v];
                }
            }
        }

        for (int i = 0; i < n; i++) {

            System.out.println(
                    "Distancia a "
                    + i +
                    ": " +
                    distancias[i]
            );
        }
    }

    private int distanciaMinima(
            int[] distancias,
            boolean[] visitados) {

        int min = Integer.MAX_VALUE;

        int indice = -1;

        for (int i = 0; i < distancias.length; i++) {

            if (!visitados[i]
                    && distancias[i] <= min) {

                min = distancias[i];

                indice = i;
            }
        }

        return indice;
    }
}