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
	}
}