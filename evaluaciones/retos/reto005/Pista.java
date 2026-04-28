public class Pista {
    public static final int LONGITUD = 40;

    public void mostrar(Caballo caballo1, Caballo caballo2) {
        imprimirLinea();

        imprimirCaballo(caballo1);
        imprimirCaballo(caballo2);

        imprimirLinea();
        System.out.println();
    }

    private void imprimirCaballo(Caballo caballo) {
        for (int i = 0; i < caballo.getPosicion(); i++) {
            System.out.print(" ");
        }
        System.out.println(";-;'");
    }

    private void imprimirLinea() {
        for (int i = 0; i < LONGITUD + 5; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}