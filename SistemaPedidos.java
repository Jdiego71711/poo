import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SistemaPedidos {

    public static void main(String[] args) {

        Map<String, LinkedList<String>> pedidos = new HashMap<>();

        // Cliente Ana
        LinkedList<String> ana = new LinkedList<>();
        ana.add("Camisa");
        ana.add("Pantalón");
        pedidos.put("Ana", ana);

        // Cliente Luis
        LinkedList<String> luis = new LinkedList<>();
        luis.add("Zapatos");
        pedidos.put("Luis", luis);

        // Cantidad de productos de Ana
        System.out.println("Ana tiene: " + pedidos.get("Ana").size() + " productos");

        // Agregar producto sin sobrescribir
        pedidos.get("Luis").add("Gorra");

        // Mostrar pedidos
        System.out.println("\nPedidos:");
        for (String cliente : pedidos.keySet()) {
            System.out.println(cliente + " -> " + pedidos.get(cliente));
        }
    }
}