public class Ascensor {
    private int pisoActual;
    private boolean enMovimiento;

    public Ascensor() {
        this.pisoActual = 0; // Inicia en el piso 0
        this.enMovimiento = false;
    }

    public void mover(int destino) {
        if (destino == pisoActual) {
            System.out.println("El ascensor ya está en el piso " + pisoActual);
            return;
        }

        enMovimiento = true;
        if (destino > pisoActual) {
            System.out.println("Ascensor subiendo...");
        } else {
            System.out.println("Ascensor bajando...");
        }

        try {
            Thread.sleep(1500); // Simula el movimiento
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pisoActual = destino;
        enMovimiento = false;
        System.out.println("Ascensor llegó al piso " + pisoActual);
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public boolean isEnMovimiento() {
        return enMovimiento;
    }
}
