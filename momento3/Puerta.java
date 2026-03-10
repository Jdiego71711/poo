public class Puerta {
    private boolean abierta;

    public Puerta() {
        this.abierta = false;
    }

    public void abrir() {
        if (!abierta) {
            abierta = true;
            System.out.println("🚪 Puerta abierta.");
        }
    }

    public void cerrar() {
        if (abierta) {
            abierta = false;
            System.out.println("🚪 Puerta cerrada.");
        }
    }

    public boolean estaAbierta() {
        return abierta;
    }

    public void iniciar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iniciar'");
    }
}
