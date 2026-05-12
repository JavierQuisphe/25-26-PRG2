public class Carta {

    public static final String[] PALOS = {"♥", "♦", "♣", "♠"};

    public static final String[] VALORES = {
        "2", "3", "4", "5", "6", "7", "8", "9", "10",
        "J", "Q", "K", "A"
    };

    private final String valor;
    private final String palo;

    public Carta(String valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public int getPuntaje() {
        return switch (valor) {
            case "A"            -> 11; 
            case "J", "Q", "K" -> 10;
            default             -> Integer.parseInt(valor);
        };
    }

    public boolean esAs() {
        return valor.equals("A");
    }

    public String getValor() {
        return valor;
    }

    public String getPalo() {
        return palo;
    }

    public String toString() {
        return "[" + valor + " " + palo + "]";
    }
}