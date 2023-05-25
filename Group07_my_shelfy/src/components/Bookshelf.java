
package components;

import java.util.*;

import tile.Tile;

public class Bookshelf {
	private int rows = 6;
	private int columns = 5;
	private int LimiteCarte = 3;
	private int[] conteggioCarte;
	private Tile[][] schemaMatrice = new Tile[rows][columns];

	public Bookshelf() // Bookshelf constructor, initializing private rows and columns
	{
		for (int i = 0; i < rows; ++i)
			for (int j = 0; j < columns; ++j)
				schemaMatrice[i][j] = new Tile();
	}

	public void StampaMatrice() {
		for (int riga = 0; riga < rows; riga++) {
			for (int colonna = 0; colonna < columns; colonna++) {
				System.out.print(schemaMatrice[riga][colonna].toString());
			}
			System.out.println();
		}
		System.out.println();
	}

	public void inizializzaMatrice() {
		for (int riga = 0; riga < rows; riga++) {
			for (int colonna = 0; colonna < columns; colonna++) {
				schemaMatrice[riga][colonna] = new Tile();
			}
		}
	}

	public int getColumns() {
		int colSel;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("In che colonna vuoi inserire le carte?");
			colSel = sc.nextInt();// per colSel s'intende la colonna selezionata dal giocatore

			if (colSel < 0 || colSel > 4) {
				System.out.println("Colonna inesistente, seleziona una colonna giusta");
				sc.close();
			}
		} while (colSel < 0 || colSel > 4);

		return colSel;
	}

	public int countEmptyspace(int colSel) {

		int emptySpaces = 0;

		for (int i = 0; i < schemaMatrice.length; i++) {
			if (schemaMatrice[i][colSel].getType() == null) {
				emptySpaces++;
			}
		}
		return emptySpaces;
	}

	public int nTile(int colSel) {
		int TileDaInserire = 0;
		do {

			do {
				TileDaInserire=this.scegliSpazi();

			} while (TileDaInserire < 1 || TileDaInserire > 3);
			if (countEmptyspace(colSel) > TileDaInserire) {
				Scanner sc= new Scanner(System.in);
				int scelta=0;
					System.out.println("Numero di spazi non disponibili ");
					System.out.println("Decidi se cambiare colonna premendo 1 o quanti spazi da inserire premendo 2  ");
					scelta=sc.nextInt();
					if(scelta>1){
						TileDaInserire=this.scegliSpazi();
					}
					else{
						colSel=this.getColumns();
					}
			}
			
		} while (countEmptyspace(colSel) < TileDaInserire);
		return TileDaInserire;
	}
		public int scegliSpazi() {
			int TileDaInserire;
			Scanner sc = new Scanner(System.in);
			System.out.println("quante carte vuoi inserire? (compreso tra 1 e 3)");
			TileDaInserire = sc.nextInt();

			if (TileDaInserire < 1 || TileDaInserire > 3) {
				System.out.println("per le regole del gioco, si possono raccogliere solo Tile da 1 a 3");
				sc.close();
			}
			return TileDaInserire;
		}
	public boolean emptySpace() {
		boolean emptySpaces = true;

		for (int i = 0; i < schemaMatrice.length; i++) {
			for (int j = 0; i < schemaMatrice[0].length; j++) {

				if (schemaMatrice[i][j].getType() == null) {
					emptySpaces = true;
				} else {
					return false;
				}
			}
		}
		return emptySpaces;
	}

	public int TileAdjacent() {
		// Controlla le tessere adiacenti orizzontalmente
		int contatore = 0;
		boolean[][] visited = new boolean[rows][columns];
		for (int riga = 0; riga < rows; riga++) {
			for (int colonna = 0; colonna < columns - 1; colonna++) {
				Tile tesseraCorrente = schemaMatrice[riga][colonna];
				Tile tesseraSuccessiva = schemaMatrice[riga][colonna + 1];
				if ((!visited[riga][colonna]) && (!visited[riga][colonna + 1])
						&& (tesseraCorrente.getType() != null && tesseraSuccessiva.getType() != null)) {
					if (tesseraCorrente.getType().equals(tesseraSuccessiva.getType())) {
						contatore++;
						visited[riga][colonna] = true;
						visited[riga][colonna + 1] = true;
					}
				}
			}
		}

		// Controlla le tessere adiacenti verticalmente
		for (int riga = 0; riga < rows - 1; riga++) {
			for (int colonna = 0; colonna < columns; colonna++) {
				Tile tilePrevious = schemaMatrice[riga][colonna - 1];
				Tile tesseraCorrente = schemaMatrice[riga][colonna];
				Tile tesseraSuccessiva = schemaMatrice[riga + 1][colonna];
				if ((!visited[riga][colonna]) && (!visited[riga + 1][colonna]) && (tesseraCorrente.getType() != null
						&& tesseraSuccessiva.getType() != null && tilePrevious.getType() != null)) {
					if (tesseraCorrente.getType().equals(tesseraSuccessiva.getType())) {
						contatore++;
						visited[riga][colonna] = true;
						visited[riga + 1][colonna] = true;
					}
				}
			}
		}

		return contatore; // Non sono state trovate tessere adiacenti dello stesso tipo

	}

	public void inserisciTile(int colSel,Tile t) {
		Scanner sc = new Scanner(System.in);
		int riga;
			this.StampaMatrice();
			System.out.println("Scegli in che riga inserire la tessera ");
			riga = sc.nextInt();
			schemaMatrice[riga-1][colSel] = t;
			sc.close();

	}

}
