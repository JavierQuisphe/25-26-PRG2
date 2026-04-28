public class Carrera {
    private Caballo caballo1;
    private Caballo caballo2;
    private Pista pista;
    private Turno turno;

    public Carrera() {
        caballo1 = new Caballo("Caballo 1");
        caballo2 = new Caballo("Caballo 2");
        pista = new Pista();
        turno = new Turno();
    }

    public void jugar() {
        int caballoActual = turno.seleccionarCaballoInicial();

        System.out.println("Inicia el caballo " + caballoActual);
        pista.mostrar(caballo1, caballo2);

        while (!hayGanador()) {
            if (caballoActual == 1) {
                moverCaballo(caballo1);
                caballoActual = 2;
            } else {
                moverCaballo(caballo2);
                caballoActual = 1;
            }

            pista.mostrar(caballo1, caballo2);
        }

        mostrarResultado();
    }

    private void moverCaballo(Caballo caballo) {
        int avance = turno.obtenerAvance();
        caballo.avanzar(avance);

        System.out.println(caballo.getNombre() + " avanza " + avance + " casilla(s)");
    }

    private boolean hayGanador() {
        return caballo1.getPosicion() >= Pista.LONGITUD ||
               caballo2.getPosicion() >= Pista.LONGITUD;
    }

    private void mostrarResultado() {
        boolean ganoCaballo1 = caballo1.getPosicion() >= Pista.LONGITUD;
        boolean ganoCaballo2 = caballo2.getPosicion() >= Pista.LONGITUD;

        if (ganoCaballo1 && ganoCaballo2) {
            System.out.println("Hubo empate");
        } else if (ganoCaballo1) {
            System.out.println("Ganó el caballo 1");
        } else {
            System.out.println("Ganó el caballo 2");
        }
    }
}