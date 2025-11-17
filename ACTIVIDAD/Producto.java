public abstract class Producto {
    private int numero;

    public Producto(int numero) {
        this.numero = numero;
    }

    // Getters y Setters
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
}