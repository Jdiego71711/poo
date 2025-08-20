public class Main {
    public static void main(String[] args) {
        // Datos del Caso A del documento
        double d1 = 42.0, d2 = 58.5, d3 = 37.2;
        double t1 = 0.9, t2 = 1.4, t3 = 0.8;
        double l1 = 5.1, l2 = 6.9, l3 = 3.1;
        double precioLitro = 1.35;
        double masaCargaKg = 1200.0;
        double largo = 4.2, ancho = 2.0, alto = 2.0;
        double p1 = 2.5, p2 = 4.0, p3 = 2.0;
        double deprecPorKm = 0.08;
        double volCamionM3 = 10.0;
        double fCO2 = 2.64;
        double galPorLitro = 0.264172;
        double v_min = 40.0, v_max = 80.0;
        
        // Crear el objeto Viaje con los datos del Caso A
        Viaje miViaje = new Viaje(d1, d2, d3, t1, t2, t3, l1, l2, l3, precioLitro, masaCargaKg,
                                 largo, ancho, alto, p1, p2, p3, deprecPorKm, volCamionM3,
                                 fCO2, galPorLitro, v_min, v_max);

        // Mostrar los resultados de todos los ejercicios
        System.out.println("--- Resultados del Taller (Caso A) ---");
        
        // 1) y 2)
        System.out.println("Velocidad promedio: " + miViaje.calcularVelocidadPromedio() + " km/h");
        System.out.println("Rendimiento total: " + miViaje.calcularRendimientoTotal() + " km/L");
        
        // 3)
        System.out.println("Costo total directo: $" + miViaje.calcularCostoDirectoTotal());
        System.out.println("Costo por km: $" + miViaje.calcularCostoPorKm());
        
        // 4)
        System.out.println("Volumen: " + miViaje.calcularVolumen() + " m3");
        System.out.println("Densidad: " + miViaje.calcularDensidad() + " kg/m3");
        System.out.println("Ocupación: " + miViaje.calcularOcupacion());
        
        // 5)
        System.out.println("Emisiones de CO2: " + miViaje.calcularEmisionesCO2() + " kg CO2");
        
        // 6)
        System.out.println("Galones totales: " + miViaje.calcularGalonesTotales());
        System.out.println("Velocidad normalizada: " + miViaje.normalizarVelocidad());
        
        // 7)
        System.out.println("Velocidad media: " + miViaje.calcularVelocidadMedia() + " km/h");
        
        // 10)
        System.out.println("Índice de eficiencia (Score): " + miViaje.calcularScore());
    }
}