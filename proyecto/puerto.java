import java.util.Scanner;

public class puerto {

    private embarcacion[] listabuques;
    private contenedormaritimo[][] zonaalmacenamiento;
    private int totalbuques;
    private int totalcontenedores;
    private Scanner sc;

    public puerto() {
        listabuques = new embarcacion[10];
        zonaalmacenamiento = new contenedormaritimo[10][10];
        totalbuques = 0;
        totalcontenedores = 0;
        sc = new Scanner(System.in);
    }

    public void ejecutarprograma() {
        int opcion = 0;
        do {
            System.out.println("\n========================================");
            System.out.println("   SISTEMA DE ORGANIZACION DE CONTENEDORES");
            System.out.println("========================================");
            System.out.println(" 1. Registrar buque");
            System.out.println(" 2. Registrar contenedor");
            System.out.println(" 3. Mostrar peso total");
            System.out.println(" 4. Listar contenedores por origen");
            System.out.println(" 5. Salir");
            System.out.println("----------------------------------------");
            opcion = leerentero("Seleccione una opcion: ");
            switch (opcion) {
                case 1:
                    registrarbuque();
                    break;
                case 2:
                    registrarcontenedor();
                    break;
                case 3:
                    pesototal();
                    break;
                case 4:
                    listarpororigen();
                    break;
                case 5:
                    System.out.println("\nSistema finalizado. Hasta luego.");
                    break;
                default:
                    System.out.println("\nOpcion invalida. Intente de nuevo.");
            }
            if (opcion != 5) {
                System.out.println("\nPresione ENTER para continuar...");
                sc.nextLine();
            }
        } while (opcion != 5);
        sc.close();
    }

    private void registrarbuque() {
        System.out.println("\n--- REGISTRAR BUQUE ---");
        if (totalbuques >= 10) {
            System.out.println("AVISO: No hay espacio disponible. El muelle esta lleno (10/10).");
            return;
        }
        System.out.print("Codigo del buque: ");
        String codigo = sc.nextLine().trim();
        for (int i = 0; i < totalbuques; i++) {
            if (listabuques[i].getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println("AVISO: Ya existe un buque con ese codigo.");
                return;
            }
        }
        System.out.print("Nombre del buque: ");
        String nombre = sc.nextLine().trim();
        System.out.print("Pais de procedencia: ");
        String pais = sc.nextLine().trim();
        listabuques[totalbuques] = new embarcacion(codigo, nombre, pais);
        totalbuques++;
        System.out.println("OK: Buque registrado. Ocupados: " + totalbuques + "/10");
    }

    private void registrarcontenedor() {
        System.out.println("\n--- REGISTRAR CONTENEDOR ---");
        if (totalcontenedores >= 100) {
            System.out.println("AVISO: La zona de almacenamiento esta llena (100/100).");
            return;
        }
        if (totalbuques == 0) {
            System.out.println("AVISO: No hay buques registrados. Registre uno primero.");
            return;
        }
        mostrarpantalla();
        System.out.println("\nBuques registrados:");
        for (int i = 0; i < totalbuques; i++) {
            System.out.println("  " + listabuques[i].toString());
        }
        System.out.print("\nCodigo del contenedor: ");
        String codigo = sc.nextLine().trim();
        System.out.print("Origen del contenedor: ");
        String origen = sc.nextLine().trim();
        double peso = leerdouble("Peso en toneladas: ");
        int columna = leerentero("Columna donde apilarlo (0-9): ");
        if (columna < 0 || columna > 9) {
            System.out.println("AVISO: Columna invalida. Debe ser un valor entre 0 y 9.");
            return;
        }
        boolean hayespacio = false;
        for (int f = 0; f < 10; f++) {
            if (zonaalmacenamiento[f][columna] == null) {
                hayespacio = true;
                break;
            }
        }
        if (!hayespacio) {
            System.out.println("AVISO: La columna " + columna + " esta completamente llena. Elija otra.");
            return;
        }
        contenedormaritimo nuevo = new contenedormaritimo(codigo, peso, origen);
        boolean insertado = false;
        for (int f = 9; f >= 0; f--) {
            if (zonaalmacenamiento[f][columna] == null) {
                zonaalmacenamiento[f][columna] = nuevo;
                totalcontenedores++;
                insertado = true;
                System.out.println("OK: Contenedor apilado en fila " + f + ", columna " + columna + ".");
                break;
            }
        }
        if (!insertado) {
            System.out.println("AVISO: No fue posible apilar el contenedor.");
        } else {
            mostrarpantalla();
        }
    }

    private void mostrarpantalla() {
        System.out.println("\nZONA DE ALMACENAMIENTO:");
        System.out.print("     ");
        for (int c = 0; c < 10; c++) {
            System.out.print(" C" + c + " ");
        }
        System.out.println();
        System.out.print("     ");
        for (int c = 0; c < 10; c++) {
            System.out.print("----");
        }
        System.out.println();
        for (int f = 0; f < 10; f++) {
            System.out.print(" F" + f + " |");
            for (int c = 0; c < 10; c++) {
                if (zonaalmacenamiento[f][c] != null) {
                    System.out.print("[X] ");
                } else {
                    System.out.print("[ ] ");
                }
            }
            System.out.println();
        }
        System.out.println("     (F9 = piso)  Contenedores: " + totalcontenedores + "/100");
    }

    private void pesototal() {
        System.out.println("\n--- PESO TOTAL DE CONTENEDORES ---");
        double total = 0;
        int cantidad = 0;
        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 10; c++) {
                if (zonaalmacenamiento[f][c] != null) {
                    total += zonaalmacenamiento[f][c].getPeso();
                    cantidad++;
                }
            }
        }
        if (cantidad == 0) {
            System.out.println("No hay contenedores almacenados.");
        } else {
            System.out.println("Contenedores en zona: " + cantidad);
            System.out.printf("Peso total acumulado: %.2f toneladas%n", total);
        }
    }

    private void listarpororigen() {
        System.out.println("\n--- CONTENEDORES POR ORIGEN ---");
        if (totalcontenedores == 0) {
            System.out.println("No hay contenedores registrados.");
            return;
        }
        String[] origenes = new String[100];
        int[] cantidades = new int[100];
        int totalorigenes = 0;
        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 10; c++) {
                if (zonaalmacenamiento[f][c] != null) {
                    String org = zonaalmacenamiento[f][c].getOrigen();
                    boolean encontrado = false;
                    for (int k = 0; k < totalorigenes; k++) {
                        if (origenes[k].equalsIgnoreCase(org)) {
                            cantidades[k]++;
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        origenes[totalorigenes] = org;
                        cantidades[totalorigenes] = 1;
                        totalorigenes++;
                    }
                }
            }
        }
        for (int o = 0; o < totalorigenes; o++) {
            System.out.println("\nOrigen: " + origenes[o] + " (" + cantidades[o] + " contenedor/es)");
            System.out.println("  --------------------------------------------------");
            for (int f = 0; f < 10; f++) {
                for (int c = 0; c < 10; c++) {
                    if (zonaalmacenamiento[f][c] != null
                            && zonaalmacenamiento[f][c].getOrigen().equalsIgnoreCase(origenes[o])) {
                        System.out.println("  Pos[F" + f + "][C" + c + "] -> "
                                + zonaalmacenamiento[f][c].toString());
                    }
                }
            }
        }
    }

    private int leerentero(String mensaje) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensaje);
                valor = Integer.parseInt(sc.nextLine().trim());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Ingrese un numero entero.");
            }
        }
        return valor;
    }

    private double leerdouble(String mensaje) {
        double valor = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensaje);
                valor = Double.parseDouble(sc.nextLine().trim());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Ingrese un numero decimal.");
            }
        }
        return valor;
    }
}