
import java.util.Scanner;

public class Puerto {

    private Buque[] buques = new Buque[10];
    private Contenedor[][] contenedores = new Contenedor[10][10];

    Scanner sc = new Scanner(System.in);

    public void registrarBuque() {

        for (int i = 0; i < buques.length; i++) {

            if (buques[i] == null) {

                System.out.print("Ingrese nombre del buque: ");
                String nombre = sc.nextLine();

                buques[i] = new Buque(nombre);

                System.out.println("Buque registrado en posición " + i);
                return;
            }

        }

        System.out.println("No hay espacio para más buques.");
    }

    public void registrarContenedor() {

        mostrarMatriz();

        System.out.print("Ingrese columna (0-9): ");
        int col = sc.nextInt();
        sc.nextLine();

        if (col < 0 || col > 9) {
            System.out.println("Columna inválida");
            return;
        }

        for (int fila = 9; fila >= 0; fila--) {

            if (contenedores[fila][col] == null) {

                System.out.print("Peso del contenedor: ");
                int peso = sc.nextInt();
                sc.nextLine();

                System.out.print("Origen del contenedor: ");
                String origen = sc.nextLine();

                contenedores[fila][col] = new Contenedor(peso, origen);

                System.out.println("Contenedor ubicado en [" + fila + "][" + col + "]");
                return;

            }

        }

        System.out.println("Columna llena.");
    }

    public void mostrarMatriz() {

        System.out.println("\n--- AREA DE CONTENEDORES ---");

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                if (contenedores[i][j] == null)
                    System.out.print("[ ] ");
                else
                    System.out.print("[X] ");

            }

            System.out.println();
        }

    }

    public void pesoTotal() {

        int total = 0;

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                if (contenedores[i][j] != null) {
                    total += contenedores[i][j].getPeso();
                }

            }

        }

        System.out.println("Peso total: " + total);
    }

    public void listarOrigen() {

        System.out.println("\n--- ORIGEN DE CONTENEDORES ---");

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                if (contenedores[i][j] != null) {

                    System.out.println(
                            "Contenedor [" + i + "][" + j + "] Origen: "
                                    + contenedores[i][j].getOrigen());

                }

            }

        }

    }

}