public class CuentaBancaria {

    private String titular;
    private String numerocuenta;
    private double saldo = 0.0;

    public CuentaBancaria(){
        this.titular = "No hay titular";
        this.numerocuenta = "000000";
        this.saldo = 0.0;
    }

    public CuentaBancaria(String titular, String numerocuenta, double saldo){
        this.titular = (titular != null && ! titular.isEmpty()) ? titular : "desconocido";
        this.numerocuenta = (numerocuenta != null && numerocuenta.length() >= 6) ? numerocuenta: "000000";
        this.saldo = saldo >= 0 ? saldo : 0.0;
    }

    public void depositar(double monto){
        if (monto > 0 ){
            saldo += monto;
            System.out.println("Se le ha realizado el deposito: $" + monto);
        } else {
            System.out.println("NO se ha realizado el deposito");
        }
    }

    public void retiro(double monto) {
        if (monto > 0 && monto <= saldo){
            saldo -= monto;
            System.out.println("Se ha realizado el retiro: $" + monto);
        } else {
            System.out.println("No se ha realizado el retiro");
        }
    }

    public String toString(){
        return "Titular: " + titular + " - Numero de cuenta: " + numerocuenta + " - Saldo Final " + saldo;
    }
}