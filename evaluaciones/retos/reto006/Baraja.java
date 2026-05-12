import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {

    private final List<Carta> cartas;

    public Baraja() {
        cartas = new ArrayList<>();
        inicializar();
        barajar();
    }

    private void inicializar() {
        cartas.clear();
        for (String palo : Carta.PALOS) {
            for (String valor : Carta.VALORES) {
                cartas.add(new Carta(valor, palo));
            }
        }
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public Carta sacarCarta() {
        if (cartas.isEmpty()) {
            inicializar();
            barajar();
        }
        return cartas.remove(cartas.size() - 1);
    }

    public int cartasRestantes() {
        return cartas.size();
    }
}