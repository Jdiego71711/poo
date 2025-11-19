public class Boton {

    protected boolean presionado;

    public Boton() {
        this.presionado = false;
    }

    public void presionar() {
        presionado = true;
        System.out.println("🔘 Botón presionado.");
    }

    public void resetear() {
        presionado = false;
    }

    public boolean estaPresionado() {
        return presionado;
    }
}
