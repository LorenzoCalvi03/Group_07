package tile;

import java.util.*;

public class TileObject {
	/**
	 * La classe TileObject rappresenta le carte Obiettivo personale del gioco. Ogni oggetto
	 * tessera ha una matrice di stringhe che definisce il suo layout. Fornisce
	 * metodi per generare un ordine casuale degli oggetti tessera e per stampare il
	 * layout della tessera.
	 */
	private static String[][] matrix = new String[6][5];

	/**
	 * Costruttore della classe TileObject. Inizializza la matrice dell'oggetto
	 * tessera in base al numero specificato.
	 * 
	 * @param n Il numero dell'oggetto tessera.
	 */
	public TileObject(int n) {
		switch (n) {
		case 1:
			matrix = Personal1;
			break;
		case 2:
			matrix = Personal2;
			break;
		case 3:
			matrix = Personal3;
			break;
		case 4:
			matrix = Personal4;
			break;
		case 5:
			matrix = Personal5;
			break;
		case 6:
			matrix = Personal6;
			break;
		case 7:
			matrix = Personal7;
			break;
		case 8:
			matrix = Personal8;
			break;
		case 9:
			matrix = Personal9;
			break;
		case 10:
			matrix = Personal10;
			break;
		case 11:
			matrix = Personal11;
			break;
		case 12:
			matrix = Personal12;
			break;
		}

	}

	private String[][] Personal1 = { { "pink", "-", "blue", "-", "-" }, { "-", "-", "-", "-", "green" },
			{ "-", "-", "-", "white", "-" }, { "-", "orange", "-", "-", "-" }, { "-", "-", "-", "-", "-" },
			{ "-", "-", "azure", "-", "-" } };
	private String[][] Personal2 = { { "-", " - ", " - ", " - ", " - " }, { " - ", "pink", " - ", " - ", " - " },
			{ "green", " - ", "orange", " - ", " - " }, { " - ", " - ", " - ", " - ", "white" },
			{ " - ", " - ", " - ", "azure", " - " }, { " - ", " - ", " - ", " - ", "blue" } };
	private String[][] Personal3 = { { " - ", " - ", " - ", " - ", " - " }, { "blue", " - ", " - ", "orange", " - " },
			{ " - ", " - ", "pink", " - ", " - " }, { " - ", "green", " - ", " - ", "blue" },
			{ " - ", " - ", " - ", " - ", " - " }, { "white", " - ", " - ", " - ", " - " } };
	private String[][] Personal4 = { { " - ", " - ", " - ", " - ", "orange" }, { " - ", " - ", " - ", " - ", " - " },
			{ "azure", " - ", " blue ", " - ", " - " }, { " - ", " - ", " - ", "pink", " - " },
			{ " - ", "white", "green", " - ", " - " }, { " - ", " - ", " - ", " - ", " - " } };
	private String[][] Personal5 = { { " - ", " - ", " - ", " - ", " - " }, { " - ", "azure", " - ", " - ", " - " },
			{ " - ", " - ", " - ", " - ", " - " }, { " - ", "blue", "white", " - ", " - " },
			{ " - ", " - ", " - ", " - ", "pink" }, { "orange", " - ", " - ", "green", " - ", } };

	private String[][] Personal6 = { { " - ", " - ", "azure", " - ", "green" }, { " - ", " - ", " - ", " - ", " - " },
			{ " - ", " - ", " - ", "white", " - " }, { " - ", " - ", " - ", " - ", " - " },
			{ " - ", "orange", " - ", "blue", " - " }, { "pink", " - ", " - ", " - ", " - " } };

	private String[][] Personal7 = { { "green", " - ", " - ", " - ", " - " }, { " - ", " - ", " - ", "blue", " - " },
			{ " - ", "pink", " - ", " - ", " - " }, { "azure", " - ", " - ", " - ", " - " },
			{ " - ", " - ", " - ", " - ", "orange" }, { " - ", " - ", "white", " - ", " - " } };

	private String[][] Personal8 = { { " - ", " - ", " - ", " - ", "blue" }, { " - ", "green", " - ", " - ", " - " },
			{ " - ", " - ", "azure", " - ", " - " }, { "pink", " - ", " - ", " - ", " - " },
			{ " - ", " - ", " - ", "white", " - " }, { " - ", " - ", " - ", "orange", " - " } };

	private String[][] Personal9 = { { " - ", " - ", " - ", " - ", "orange" }, { " - ", " - ", " - ", " - ", " - " },
			{ " - ", " - ", " - ", "green", " - " }, { " - ", " - ", " - ", " - ", "white" },
			{ " - ", "azure", " - ", " - ", "pink" }, { "blue", " - ", " - ", " - ", " - " } };

	private String[][] Personal10 = { { " - ", " - ", " - ", " - ", "azure" }, { " - ", "orange", " - ", " - ", " - " },
			{ "white", " - ", " - ", " - ", " - " }, { " - ", " - ", " - ", "green", " - " },
			{ " - ", "blue", " - ", " - ", " - " }, { " - ", " - ", " - ", "pink", " - " } };

	private String[][] Personal11 = { { " - ", " - ", "pink", " - ", " - " }, { " - ", "white", " -", " - ", " - " },
			{ "orange", " - ", " - ", " - ", " - " }, { " - ", " - ", "blue", " - ", " - " },
			{ " - ", " - ", " - ", " - ", "green" }, { " - ", " - ", " - ", "azure", " - " } };

	private String[][] Personal12 = { { " - ", " - ", "white", " - ", " - " }, { " - ", "pink", " - ", " - ", " - " },
			{ " - ", " - ", "blue", " - ", " - " }, { " - ", " - ", " - ", "azure", " - " },
			{ " - ", " - ", " - ", " - ", "orange" }, { "green", " - ", " - ", " - ", " - " } };

	/**
	 * Genera un ordine casuale degli oggetti tessera.
	 * 
	 * @return Una lista di interi rappresentante l'ordine casuale degli oggetti
	 *         tessera.
	 */
	public static List<Integer> generateRandomTileObjectOrder() {
		List<Integer> tileObjectNumbers = new ArrayList<Integer>();
		for (int i = 1; i <= 12; i++) {
			tileObjectNumbers.add(i);
		}
		Collections.shuffle(tileObjectNumbers);
		return tileObjectNumbers;
	}// generatore casuale della tessera Obiettivo Personale

	/**
	 * Stampa il layout della tessera.
	 */
	public void printTileObject() {
		for (int i = 0; i < matrix[i].length; i++) {
			System.out.print("\t " + i);
		}
		System.out.println(" ");
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(i + "\t ");
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " \t");
			}
			System.out.println("");
		}
	}

	/**
	 * Restituisce il tipo di tessera nella posizione specificata.
	 * 
	 * @param x La coordinata x della tessera.
	 * @param y La coordinata y della tessera.
	 * @return Il tipo di tessera nella posizione specificata.
	 */
	public String getType(int x, int y) {
		return this.matrix[x][y];
	}

}
