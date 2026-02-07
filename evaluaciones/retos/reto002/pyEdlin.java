import java.util.Scanner;

public class pyEdlin {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] t = new String[10]; 
        int a = 0; 

        for (int i = 0; i < 10; i++) {
            t[i] = "";
        }

        t[0] = "Bienvenidos al editor EDLIN";
        t[1] = "Utilice el menu inferior para editar el texto";
        t[2] = "------";
        t[3] = "[L] permite definir la linea activa";
        t[4] = "[E] permite editar la linea activa";
        t[5] = "[B] borra el contenido de la linea activa";
        t[6] = "[S] sale del programa";

        String cmd = "";
        while (cmd.equalsIgnoreCase("S") == false) {

            System.out.println("--------------------------------------------------");
            for (int i = 0; i < 10; i++) {
                if (i == a) {
                    System.out.println(i + ":*| " + t[i]);
                } else {
                    System.out.println(i + ": | " + t[i]);
                }
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Comandos: [L]inea activa | [E]ditar | [B]orrar | [S]alir");

            System.out.print("Ingrese comando: ");
            cmd = scanner.nextLine(); 

            if (cmd.equals("L") || cmd.equals("l")) {
                System.out.print("Numero de linea (0-9): ");
                String x = scanner.nextLine();
                int n = Integer.parseInt(x);
                if (n >= 0 && n < 10) {
                    a = n;
                } else {
                    System.out.println("Linea invalida");
                }

            } else if (cmd.equals("E") || cmd.equals("e")) {
                System.out.print("Nuevo texto para linea " + a + ": ");
                String nuevo = scanner.nextLine();
                t[a] = nuevo; 

            } else if (cmd.equals("B") || cmd.equals("b")) {
                t[a] = ""; 

            } else if (cmd.equals("S") || cmd.equals("s")) {
                System.out.println("Saliendo...");

            } else {
                System.out.println("Comando no reconocido");
            }
        }

        scanner.close();
    }
}
