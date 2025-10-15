public class principal {
    public static void main(String[] args) {
        CuentaBancaria bancario = new CuentaBancaria("esteban", "234861", 1800);
        bancario.depositar(70088);
        bancario.retiro(34400);
        System.out.println(bancario.toString());

        CuentaBancaria cuenta2 = new CuentaBancaria("valencia", "193423", 19990);
        cuenta2.depositar(-900);
        cuenta2.retiro(42200);
        System.out.println(cuenta2.toString());

        System.out.println("-------------------------------------");

        Producto p0 = new Producto("manzanas", "verduras", 342, 990);
        System.out.println(p0.calcularSubT());
        System.out.println(p0.Apliclardescuento());
        System.out.println(p0.toString());

        System.out.println("despues de agregar mas cantidad");
        p0.agregarCantidad(28);
        System.out.println(p0.toString());
        

    }
}