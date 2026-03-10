import java.util.Scanner;

public class ejec {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            Puerto puerto = new Puerto();

            int opcion;

            do {

                System.out.println("\n===== MENU PRINCIPAL =====");
                System.out.println("1. Registrar buque");
                System.out.println("2. Registrar contenedor");
                System.out.println("3. Mostrar peso total");
                System.out.println("4. Listar origen de contenedores");
                System.out.println("5. Salir");

                System.out.print("Seleccione una opcion: ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {

                    case 1:
                        puerto.registrarBuque();
                        break;

                    case 2:
                        puerto.registrarContenedor();
                        break;

                    case 3:
                        puerto.pesoTotal();
                        break;

                    case 4:
                        puerto.listarOrigen();
                        break;

                    case 5:
                        System.out.println("Aplicacion finalizada.");
                        break;

                    default:
                        System.out.println("Opcion invalida.");
                }

            } while (opcion != 5);
        }

    }

}