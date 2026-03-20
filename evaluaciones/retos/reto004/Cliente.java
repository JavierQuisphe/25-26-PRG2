public class Cliente {

    public static void main(String[] args) {

        Fraccion f1 = new Fraccion(3, 4);
        Fraccion f2 = new Fraccion(1, 2);
        Fraccion f3 = new Fraccion(f1);
        Fraccion f4 = new Fraccion(5);
        Fraccion f5 = new Fraccion();

        seccion("Constructores");
        System.out.print("f1 = new Fraccion(3, 4) -> "); f1.mostrar();
        System.out.print("f2 = new Fraccion(1, 2) -> "); f2.mostrar();
        System.out.print("f3 = new Fraccion(f1)   -> "); f3.mostrar();
        System.out.print("f4 = new Fraccion(5)    -> "); f4.mostrar();
        System.out.print("f5 = new Fraccion()     -> "); f5.mostrar();

        seccion("Clonar");
        Fraccion clon = f1.clonar();
        System.out.print("clon de f1 -> "); clon.mostrar();

        seccion("Aritmetica");
        Fraccion op = new Fraccion(f1);
        System.out.print("f1 + f2 = "); op.sumar(f2);        op.mostrar();

        op = new Fraccion(f1);
        System.out.print("f1 - f2 = "); op.restar(f2);       op.mostrar();

        op = new Fraccion(f1);
        System.out.print("f1 * f2 = "); op.multiplicar(f2);  op.mostrar();

        op = new Fraccion(f1);
        System.out.print("f1 / f2 = "); op.dividir(f2);      op.mostrar();

        seccion("Potenciar");
        op = new Fraccion(f1);
        System.out.print("f1 ^ 2 = "); op.potenciar(2); op.mostrar();

        op = new Fraccion(f1);
        System.out.print("f1 ^ 0 = "); op.potenciar(0); op.mostrar();

        seccion("Invertir y oponer");
        op = new Fraccion(f1);
        op.invertir();
        System.out.print("invertir(f1) = "); op.mostrar();

        op = new Fraccion(f1);
        op.oponer();
        System.out.print("oponer(f1)   = "); op.mostrar();

        seccion("Simplificar");
        Fraccion fs = new Fraccion(6, 9);
        System.out.print("antes  -> "); fs.mostrar();
        fs.simplificar();
        System.out.print("despues -> "); fs.mostrar();

        seccion("Comparacion");
        System.out.println("f1 > f2  -> " + f1.esMayor(f2));
        System.out.println("f1 < f2  -> " + f1.esMenor(f2));
        System.out.println("f1 == f1 -> " + f1.equals(f1));
        System.out.println("f1 == f3 -> " + f1.equals(f3));
    }

    private static void seccion(String titulo) {
        System.out.println("\n-- " + titulo + " " + "-".repeat(40 - titulo.length()));
    }
}