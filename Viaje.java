public class Viaje {
    // 1) Atributos (Datos base del viaje)
    private double d1, d2, d3;
    private double t1, t2, t3;
    private double l1, l2, l3;
    private double precioLitro;
    private double masaCargaKg;
    private double largo, ancho, alto;
    private double p1, p2, p3;
    private double deprecPorKm;
    private double volCamionM3;
    private double fCO2;
    private double galPorLitro;
    private double v_min, v_max;

    // Constructor que inicializa todos los datos
    public Viaje(double d1, double d2, double d3, double t1, double t2, double t3,
                 double l1, double l2, double l3, double precioLitro, double masaCargaKg,
                 double largo, double ancho, double alto, double p1, double p2, double p3,
                 double deprecPorKm, double volCamionM3, double fCO2, double galPorLitro,
                 double v_min, double v_max) {
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
        this.precioLitro = precioLitro;
        this.masaCargaKg = masaCargaKg;
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.deprecPorKm = deprecPorKm;
        this.volCamionM3 = volCamionM3;
        this.fCO2 = fCO2;
        this.galPorLitro = galPorLitro;
        this.v_min = v_min;
        this.v_max = v_max;
    }

    // Métodos para "Velocidades y rendimiento"
    public double calcularDistanciaTotal() { return d1 + d2 + d3; }
    public double calcularTiempoTotal() { return t1 + t2 + t3; }
    public double calcularVelocidadPromedio() { return calcularDistanciaTotal() / calcularTiempoTotal(); }
    public double calcularLitrosTotales() { return l1 + l2 + l3; }
    public double calcularRendimientoTotal() { return calcularDistanciaTotal() / calcularLitrosTotales(); }

    // Métodos para "Costos directos"
    public double calcularCostoCombustible() { return calcularLitrosTotales() * precioLitro; }
    public double calcularCostoDepreciacion() { return calcularDistanciaTotal() * deprecPorKm; }
    public double calcularCostoPeajes() { return p1 + p2 + p3; }
    public double calcularCostoDirectoTotal() { return calcularCostoCombustible() + calcularCostoDepreciacion() + calcularCostoPeajes(); }
    public double calcularCostoPorKm() { return calcularCostoDirectoTotal() / calcularDistanciaTotal(); }

    // 4) Volumen, densidad y ocupación
    public double calcularVolumen() { return largo * ancho * alto; }
    public double calcularDensidad() { return masaCargaKg / calcularVolumen(); }
    public double calcularOcupacion() { return calcularVolumen() / volCamionM3; }

    // 5) Emisiones de CO2
    public double calcularEmisionesCO2() { return (l1 + l2 + l3) * fCO2; }

    // 6) Conversiones y normalización
    public double calcularGalonesTotales() { return calcularLitrosTotales() * galPorLitro; }
    public double normalizarVelocidad() {
        double vProm = calcularVelocidadPromedio();
        return (vProm - v_min) / (v_max - v_min);
    }
    
    // 7) Promedios y dispersión
    public double calcularVelocidadMedia() { return (d1/t1 + d2/t2 + d3/t3) / 3; }

    // 8) Interpolación lineal (mantenimiento)
    // El costo de mantenimiento está fuera del alcance de las variables provistas en el documento, pero la fórmula es:
    // costoMant = cm_a + (cm_b - cm_a) * (Vprom - V_a) / (V_b - V_a)
    // Para resolverlo, necesitas 4 variables más: cm_a, cm_b, V_a, V_b

    // 10) Índice de eficiencia (score)
    public double calcularScore() {
        double w1 = 0.5, w2 = 0.25, w3 = 0.25; // Pesos (w)
        double rendimientoTotal = calcularRendimientoTotal();
        double costoPorKm = calcularCostoPorKm();
        double emisionesCO2 = calcularEmisionesCO2();
        double litrosTotales = calcularLitrosTotales();
        
        return w1 * rendimientoTotal + w2 * (1 / costoPorKm) + w3 * (1 / (emisionesCO2 / litrosTotales));
    }
}
