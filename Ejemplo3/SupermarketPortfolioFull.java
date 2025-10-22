import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SupermarketPortfolioFull {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Datos básicos predefinidos
        String developer = "SuperDev";
        String description = "Portafolio digital para soluciones tecnológicas de supermercados.";

        // Listas precargadas
        List<String> projects = new ArrayList<>(List.of(
                "Sistema de Ventas: aplicación para gestionar ventas y reportes",
                "Inventario en Tiempo Real: actualiza el stock automáticamente",
                "App Móvil para Clientes: pedidos y ofertas personalizadas",
                "POS con Lector de Código: punto de venta rápido y eficiente"
        ));

        List<String> categories = new ArrayList<>(List.of(
                "Frutas y Verduras", "Lácteos", "Carnes y Pescados", "Bebidas", "Limpieza y Hogar"
        ));

        List<String> technologies = new ArrayList<>(List.of(
                "Java", "Spring Boot", "SQLite", "HTML/CSS", "JavaScript"
        ));

        boolean running = true;

        // Menú principal
        while (running) {
            System.out.println("\n==============================");
            System.out.println("🛒 PORTAFOLIO DE SUPERMERCADO DIGITAL");
            System.out.println("1. Ver portafolio completo");
            System.out.println("2. Agregar proyecto");
            System.out.println("3. Agregar categoría de producto");
            System.out.println("4. Agregar tecnología utilizada");
            System.out.println("5. Editar nombre o descripción del portafolio");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int option;
            try {
                option = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Ingrese un número válido.");
                continue;
            }

            switch (option) {
                case 1:
                    mostrarPortafolio(developer, description, projects, categories, technologies);
                    break;

                case 2:
                    System.out.print("Ingrese el nombre o descripción del nuevo proyecto: ");
                    String project = input.nextLine();
                    projects.add(project);
                    System.out.println("✅ Proyecto agregado correctamente.");
                    break;

                case 3:
                    System.out.print("Ingrese una nueva categoría de producto: ");
                    String category = input.nextLine();
                    categories.add(category);
                    System.out.println("✅ Categoría agregada correctamente.");
                    break;

                case 4:
                    System.out.print("Ingrese una nueva tecnología utilizada: ");
                    String tech = input.nextLine();
                    technologies.add(tech);
                    System.out.println("✅ Tecnología agregada correctamente.");
                    break;

                case 5:
                    System.out.print("Nuevo nombre del desarrollador o empresa: ");
                    developer = input.nextLine();
                    System.out.print("Nueva descripción: ");
                    description = input.nextLine();
                    System.out.println("✅ Datos del portafolio actualizados.");
                    break;

                case 6:
                    running = false;
                    System.out.println("👋 Saliendo del programa... ¡Gracias!");
                    break;

                default:
                    System.out.println("⚠️ Opción no válida. Intente nuevamente.");
            }
        }

        input.close();
    }

    // Método para mostrar el portafolio completo
    private static void mostrarPortafolio(String developer, String description,
                                          List<String> projects, List<String> categories,
                                          List<String> technologies) {

        System.out.println("\n======================================");
        System.out.println("   " + developer);
        System.out.println(description);
        System.out.println("======================================\n");

        System.out.println("📦 PROYECTOS DESTACADOS:");
        if (projects.isEmpty()) {
            System.out.println(" (No hay proyectos registrados)");
        } else {
            for (int i = 0; i < projects.size(); i++) {
                System.out.println((i + 1) + ". " + projects.get(i));
            }
        }

        System.out.println("\n🛒 CATEGORÍAS DE PRODUCTOS:");
        if (categories.isEmpty()) {
            System.out.println(" (No hay categorías registradas)");
        } else {
            for (String category : categories) {
                System.out.println("- " + category);
            }
        }

        System.out.println("\n🛠 TECNOLOGÍAS UTILIZADAS:");
        if (technologies.isEmpty()) {
            System.out.println(" (No hay tecnologías registradas)");
        } else {
            for (String tech : technologies) {
                System.out.println("- " + tech);
            }
        }

        System.out.println("\n📞 CONTACTO:");
        System.out.println("Email: contacto@" + developer.toLowerCase().replace(" ", "") + ".com");
        System.out.println("======================================\n");
    }
}
