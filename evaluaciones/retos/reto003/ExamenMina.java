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

			int x = 0;
			boolean xValido = false;
			while (!xValido) {
				System.out.print("Ingrese X");
				if (scanner.hasNextInt()) {
					x = scanner.nextInt();
					if (x >=1 && x <= FILAS) {
						xValido = true;
					} else {
						System.out.println("Valor fuera de rango. Ingrese un número entre 1 y " + FILAS + ".");
					}
				} else {
					System.out.println("Entrada no válida. Ingrese un número entero.");
					scanner.next();
				}
			}

			int y = 0;
			boolean yValido = false;
			while (!yValido) {
				System.out.print("Ingrese Y");
				if (Scanner.hasNextInt()) {
					y = scanner.nextInt();
					if (y >= 1 && y <= COLUMNAS) {
						yValido = true;
					} else {
						System.out.println("Valor fuera de rango. Ingrese un número entre 1 y " + COLUMNAS + ".");
					}
				} else {
					System.out.println("Entrada no válida. Ingrese un número entero.");
					scanner.next();
				}
		}

		int fila = x - 1;
		int columna = y - 1;

		if (tableroVisible[fila][columna] != '-') {
			System.out.println("----------------");
			System.out.println("Casilla ya revelada. Intente nuevamente.");
			continue;
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

	if (explosiones >= MAX_EXPLOSIONES) {
		System.out.println("¡Has perdido! Has alcanzado el límite de explosiones.");
	} else {
		System.out.println("¡Felicidades! Has ganado al revelar todas las casillas libres.");
	}

	System.out.println("Explosiones:" + explosiones + " | Casillas reveladas: " + casillasReveladas);
	Scanner.close();
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
}