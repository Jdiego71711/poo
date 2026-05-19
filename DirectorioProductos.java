import java.util.HashMap;

public class DirectorioProductos {

    public static void main(String[] args) {

        HashMap<Integer, String> productos = new HashMap<>();

        // Registrar productos
        productos.put(101, "Laptop");
        productos.put(102, "Mouse");
        productos.put(103, "Teclado");

        // Verificar existencia
        System.out.println("¿Existe 102? " + productos.containsKey(102));

        // Sobrescribir clave 101
        productos.put(101, "Tablet");

        System.out.println("Producto 101: " + productos.get(101));

        // Recorrer mapa
        System.out.println("\nInventario:");
        for (Integer codigo : productos.keySet()) {
            System.out.println("Código: " + codigo + " -> Producto: " + productos.get(codigo));
        }
    }
}