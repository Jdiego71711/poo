public class Boton {
    private String tipo; // "Ascensor" o "Piso"
    private boolean presionado;

    public Boton(String tipo) {
        this.tipo = tipo;
        this.presionado = false;
    }

    public void presionar() {
        presionado = true;
        System.out.println("🔘 Botón de " + tipo + " presionado.");
    }

    public void resetear() {
        presionado = false;
    }
}
