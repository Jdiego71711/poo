public class Producto {

    String codigo;
    String descripcion;
    int cantidad = 0;
    double precioUNI = 0;
    double descuento = 0.0;

    public Producto(){
        this.codigo = "123";
        this.descripcion = "refresco";
        this.cantidad = 0;
        this.precioUNI = 0.0;
        this.descuento = 0.0;
    }

    public Producto(String codigo, String descripcion, int cantidad, double precioUNI){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad > 0 ? cantidad : 0;
        this.precioUNI = precioUNI > 0 ? precioUNI : 0;
        this.descuento = (descuento >= 0 && descuento <= 50) ? descuento : 0.0;
    }

    public double calcularSubT(){
        return cantidad * precioUNI;
    }

    public double Apliclardescuento(){
        double descuento = calcularSubT() * 0.3;
        double subtotal = calcularSubT() - descuento;
        return subtotal;
    }

        public void agregarCantidad(int cantidadExtra) {
        if (cantidadExtra > 0) {
            this.cantidad += cantidadExtra;
        }
    }


    public String toString(){
        return "Producto - codigo: " + codigo + " - descripcion: " + descripcion + " - cantidad: " + cantidad + " - Precio unitario $" + precioUNI;
    }
}