import java.util.Scanner;

public class Blackjack {

    private static final String SEPARADOR = "--------------------";

    private final Dealer dealer;
    private final Mano mano;
    private final Scanner scanner;

    public Blackjack() {
        dealer  = new Dealer();
        mano    = new Mano();
        scanner = new Scanner(System.in);
    }

    public void jugar() {
        dealer.iniciarRonda(mano);
        mostrarEstado();

        boolean jugando = true;

        while (jugando) {
            mostrarMenu();
            int opcion = leerOpcion();

            switch (opcion) {
                case 1 -> { 
                    dealer.repartirCarta(mano);
                    mostrarEstado();

                    if (mano.estaPasado() || mano.esVeintiuno()) {
                        mostrarMenu();
                        int siguiente = leerOpcion();
                        if (siguiente == 2) {
                            dealer.iniciarRonda(mano);
                            mostrarEstado();
                        } else if (siguiente == 3) {
                            jugando = false;
                        }
                    }
                }
                case 2 -> { 
                    dealer.iniciarRonda(mano);
                    mostrarEstado();
                }
                case 3 -> jugando = false; 
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

        System.out.println("¡Hasta la próxima!");
        scanner.close();
    }

    private void mostrarEstado() {
        int puntaje = mano.getPuntaje();
        String estado = obtenerEstado(puntaje);

        System.out.println(SEPARADOR);
        System.out.println("Mano: " + mano.aTexto() + " - Puntaje: " + puntaje + " ==> " + estado);
        System.out.println(SEPARADOR);
    }

    private void mostrarMenu() {
        System.out.println("1. Pedir");
        System.out.println("2. Empezar de nuevo");
        System.out.println("3. Salir");
        System.out.println(SEPARADOR);
    }

    private String obtenerEstado(int puntaje) {
        if (puntaje > 21) {
            return "Perdió";
        } else if (puntaje == 21) {
            return "Ganó";
        } else {
            return "Sigue jugando";
        }
    }

    private int leerOpcion() {
        while (true) {
            System.out.print("");
            String linea = scanner.nextLine().trim();
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número (1, 2 o 3).");
            }
        }
    }

    public static void main(String[] args) {
        Blackjack juego = new Blackjack();
        juego.jugar();
    }
}