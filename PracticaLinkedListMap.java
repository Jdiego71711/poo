import java.util.*;

public class PracticaLinkedListMap {

    public static void main(String[] args) {  
        // SECCIÓN 1: LINKEDLIST
        System.out.println("=== HISTORIAL DE NAVEGACIÓN ===");

        LinkedList<String> historial = new LinkedList<>();

        // Agregar URLs
        historial.add("google.com");
        historial.add("github.com");
        historial.add("stackoverflow.com");

        // Página actual
        System.out.println("Página actual: " + historial.getLast());

        // Función "Atrás"
        historial.removeLast();
        System.out.println("Después de 'Atrás': " + historial.getLast());

        // Mostrar historial
        System.out.println("Historial restante:");
        for (String url : historial) {
            System.out.println(url);
        }

        // SECCIÓN 2: HASHMAP
        
        System.out.println("\n=== DIRECTORIO DE PRODUCTOS ===");

        HashMap<Integer, String> productos = new HashMap<>();

        // Registrar productos
        productos.put(101, "Laptop");
        productos.put(102, "Mouse");
        productos.put(103, "Teclado");

        // Verificar existencia
        System.out.println("¿Existe código 102? " + productos.containsKey(102));

        // Insertar clave repetida
        productos.put(101, "Tablet");
        System.out.println("Producto con código 101: " + productos.get(101));

        // Recorrer mapa
        for (Integer codigo : productos.keySet()) {
            System.out.println("Código: " + codigo + " -> Producto: " + productos.get(codigo));
        }


       
        // SECCIÓN 3: INTEGRACIÓN
        
        System.out.println("\n=== SISTEMA DE PEDIDOS ===");

        Map<String, LinkedList<String>> pedidos = new HashMap<>();

        // Cliente Ana
        LinkedList<String> listaAna = new LinkedList<>();
        listaAna.add("Camisa");
        listaAna.add("Pantalón");
        pedidos.put("Ana", listaAna);

        // Cliente Luis
        LinkedList<String> listaLuis = new LinkedList<>();
        listaLuis.add("Zapatos");
        pedidos.put("Luis", listaLuis);

        // Cantidad de productos de Ana
        System.out.println("Productos de Ana: " + pedidos.get("Ana").size());

        // Agregar producto a Luis sin sobrescribir
        pedidos.get("Luis").add("Gorra");

        // Mostrar pedidos
        for (String cliente : pedidos.keySet()) {
            System.out.println(cliente + " compró: " + pedidos.get(cliente));
        }
    }
}