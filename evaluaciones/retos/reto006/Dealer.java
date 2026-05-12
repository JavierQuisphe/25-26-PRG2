public class Dealer {

    private final Baraja baraja;

    public Dealer() {
        baraja = new Baraja();
    }

    public void repartirCarta(Mano mano) {
        Carta carta = baraja.sacarCarta();
        mano.agregarCarta(carta);
    }

    public void iniciarRonda(Mano mano) {
        mano.limpiar();
        repartirCarta(mano);
        repartirCarta(mano);
    }

    public int cartasEnBaraja() {
        return baraja.cartasRestantes();
    }
}