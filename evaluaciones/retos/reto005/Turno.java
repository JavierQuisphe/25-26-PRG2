import java.util.Random;

public class Turno {
    private Random random;

    public Turno() {
        random = new Random();
    }

    public int obtenerAvance() {
        return random.nextInt(3); 
    }

    public int seleccionarCaballoInicial() {
        return random.nextInt(2) + 1; 
    }
}