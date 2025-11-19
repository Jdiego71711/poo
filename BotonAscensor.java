public class BotonAscensor extends Boton {

    private int destino;

    public BotonAscensor(int destino) {
        this.destino = destino;
    }

    @Override
    public void presionar() {
        super.presionar();
        System.out.println("🎯 Botón interior del ascensor presionado: ir al piso " + destino);
    }

    public int getDestino() {
        return destino;
    }
}
