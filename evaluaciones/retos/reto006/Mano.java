import java.util.ArrayList;
import java.util.List;

public class Mano {

    private final List<Carta> cartas;

    public Mano() {
        cartas = new ArrayList<>();
    }

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }

    public void limpiar() {
        cartas.clear();
    }

    public int getPuntaje() {
        int total = 0;
        int cantidadAses = 0;

        for (Carta carta : cartas) {
            total += carta.getPuntaje();
            if (carta.esAs()) {
                cantidadAses++;
            }
        }

        while (total > 21 && cantidadAses > 0) {
            total -= 10; 
            cantidadAses--;
        }

        return total;
    }

    public boolean estaPasado() {
        return getPuntaje() > 21;
    }

    public boolean esVeintiuno() {
        return getPuntaje() == 21;
    }

    public int cantidadCartas() {
        return cartas.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Carta carta : cartas) {
            sb.append(carta.toString());
        }
        return sb.toString();
    }
}