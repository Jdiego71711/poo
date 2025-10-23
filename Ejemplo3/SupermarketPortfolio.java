import java.util.ArrayList;
import java.util.List;

public class SupermarketPortfolio {

    public static void main(String[] args) {
        // Nombre del portafolio / supermercado
        String developer = "SuperDev";
        String description = "Portafolio digital para soluciones de supermercados";

        // Productos / proyectos
        List<String> projects = new ArrayList<>();
        projects.add("Sistema de Ventas: aplicación para gestionar ventas y facturación");
        projects.add("Inventario en Tiempo Real: actualiza stock automáticamente");
        projects.add("App Móvil para Clientes: pedidos y ofertas personalizadas");
        projects.add("POS con Lector de Código: punto de venta rápido y eficiente");

        // Categorías de productos
        List<String> categories = new ArrayList<>();
        categories.add("Frutas y Verduras");
        categories.add("Lácteos");
        categories.add("Carnes y Pescados");
        categories.add("Bebidas");
        categories.add("Limpieza y Hogar");

        // Tecnologías utilizadas
        List<String> technologies = new ArrayList<>();
        technologies.add("Java");
        technologies.add("SQLite");
        technologies.add("Spring Boot");
        technologies.add("HTML/CSS");
        technologies.add("JavaScript");

        // Mostrar portafolio
        System.out.println("======================================");
        System.out.println("   " + developer);
        System.out.println(description);
        System.out.println("======================================\n");

        System.out.println(" Proyectos destacados:");
        for (int i = 0; i < projects.size(); i++) {
            System.out.println((i+1) + ". " + projects.get(i));
        }

        System.out.println("\n Categorías de productos:");
        for (String category : categories) {
            System.out.println("- " + category);
        }

        System.out.println("\n Tecnologías utilizadas:");
        for (String tech : technologies) {
            System.out.println("- " + tech);
        }

        System.out.println("\n Contacto:");
        System.out.println("Email: superdev@example.com");
        System.out.println("======================================");
    }
}
