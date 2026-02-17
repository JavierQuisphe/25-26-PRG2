import java.util.Scanner;
import java.util.Random;

public class ExamenMina { 
	static final int FILAS = 5;
	static final int COLUMNAS = 5;
	static final int TOTAL_MINAS = 5;
	static final int MAX_EXPLOSIONES = 3;

	static boolean[][] tablero = new boolean[FILAS][COLUMNAS];
	static char[][] tableroVisible = new char[FILAS][COLUMNAS];

	static int explosiones = 0;
	static int casillasLibres = FILAS * COLUMNAS - TOTAL_MINAS;
	static int casillasReveladas = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		inicializarTablero();
        minasColocadas();

		while(explosiones < MAX_EXPLOSIONES && casillasReveladas < casillasLibres) {
			mostrarTablero();

			int x = leerCoordenada(scanner, "X", FILAS);
			

			int y = leerCoordenada(scanner, "Y", COLUMNAS);

			int fila = x - 1;
			int columna = y - 1;

			evaluarCasilla(fila, columna);
		}


		mostrarTableroFinal();
		mostrarResultado();
		scanner.close();
	}

	static void inicializarTablero() {
		for (int i = 0; i < FILAS; i++) {
			for(int j = 0; j < COLUMNAS; j++) {
				tableroVisible[i][j] = '-';
				tablero[i][j] = false;
			} 
		}
	}

	static void minasColocadas() {
		Random random = new Random();
		int minasColocadas = 0;

		while (minasColocadas < TOTAL_MINAS) {
			int fila = random.nextInt(FILAS);
			int columna = random.nextInt(COLUMNAS);
			if(!tablero[fila][columna]) {
				tablero[fila][columna] = true;
				minasColocadas++;
			}
		}
	}

	static void mostrarTablero() {
		System.out.println("================");
			System.out.print("  ");
			for (int j = 1; j <= COLUMNAS; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
			for (int i = 0; i < FILAS; i++) {
				System.out.print((i + 1) + " ");
				for (int j = 0; j < COLUMNAS; j++) {
					System.out.print(tableroVisible[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("================");
	}

	static int leerCoordenada(Scanner scanner, String nombre, int maximo) {
        int valor = 0;
        boolean valido = false;

        while (!valido) {
            System.out.println("Ingrese " + nombre);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                if (valor >= 1 && valor <= maximo) {
                    valido = true;
                } else {
                    System.out.println("Valor fuera de rango. Ingrese entre 1 y " + maximo + ".");
                }
            } else {
                System.out.println("Entrada inválida. Ingrese un número entero.");
                scanner.next(); 
            }
        }

        return valor;
    }

	static void evaluarCasilla(int fila, int columna) {
		if (tableroVisible[fila][columna] != '-') {
			System.out.println("----------------");
			System.out.println("Casilla ya revelada. Intente nuevamente.");
			return;
		}

		System.out.println("----------------");

		if (tablero[fila][columna]) {
			tableroVisible[fila][columna] = 'X';
			explosiones++;
			System.out.println("¡Mina! (Explosión " + explosiones + " de " + MAX_EXPLOSIONES + ")");
		} else {
			tableroVisible[fila][columna] = '.';
			casillasReveladas++;
			System.out.println("¡Libre!");
		}
	}

	static void mostrarTableroFinal() {
		System.out.println("================");
	System.out.print("  ");
	for (int j = 1; j <= COLUMNAS; j++) {
		System.out.print(j + " ");
	}
	System.out.println();
	for (int i = 0; i < FILAS; i++) {
		System.out.print((i + 1) + " ");
		for (int j = 0; j < COLUMNAS; j++) {
			System.out.print(tableroVisible[i][j] + " ");
		}
		System.out.println();
	}
	System.out.println("================");
	}

	static void mostrarResultado() {
		if (explosiones >= MAX_EXPLOSIONES) {
		System.out.println("¡Has perdido! Has alcanzado el límite de explosiones.");
	} else {
		System.out.println("¡Felicidades! Has ganado al revelar todas las casillas libres.");
	}

	System.out.println("Explosiones:" + explosiones + " | Casillas reveladas: " + casillasReveladas);
	}
}