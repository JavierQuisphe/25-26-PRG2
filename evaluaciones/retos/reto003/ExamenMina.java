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
		Random random = new Random();

		for (int i = 0; i < FILAS; i++) {
			for(int j = 0; j < COLUMNAS; j++) {
				tableroVisible[i][j] = '-';
				tablero[i][j] = false;
			} 
		}

		int minasColocadas = 0;
		while (minasColocadas < TOTAL_MINAS) {
			int fila = random.nextInt(FILAS);
			int columna = random.nextInt(COLUMNAS);
			if(!tablero[filas][columna]) {
				tablero[filas][columna] = true;
				minasColocadas++;
			}
		}

		while(explosiones < MAX_EXPLOSIONES && casillasReveladas < casillasLibres) {
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
}