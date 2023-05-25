
package components;

import java.util.*;

import tile.Tile;

public class Bookshelf {
	private int rows = 5;
	private int columns = 4;
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

	public int countEmptyspace() {
		int colSel = getColumns();
		int emptySpaces = 0;

		for (int i = 0; i < schemaMatrice.length; i++) {
			if (schemaMatrice[i][colSel].getType() == null) {
				emptySpaces++;
			}
		}
		return emptySpaces;
	}

	public int nTile() {
		int TileDaInserire;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("quante carte vuoi inserire? (compreso tra 1 e 3)");
			TileDaInserire = sc.nextInt();

			if (TileDaInserire < 1 || TileDaInserire > 3) {
				System.out.println("per le regole del gioco, si possono raccogliere solo Tile da 1 a 3");
				sc.close();
			}
		} while (TileDaInserire < 1 || TileDaInserire > 3);

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
    	  int contatore=0;
    	  boolean [][] visited= new boolean [rows][columns];
    		    for (int riga = 0; riga < rows; riga++) {
    		        for (int colonna = 0; colonna < columns - 1; colonna++) {
    		            Tile tesseraCorrente = schemaMatrice[riga][colonna];
    		            Tile tesseraSuccessiva = schemaMatrice[riga][colonna + 1];
    		            if ((!visited [riga][colonna])&& (!visited [riga][colonna+1])&&(tesseraCorrente.getType() != null && tesseraSuccessiva.getType() != null)) {
    		                if (tesseraCorrente.getType().equals(tesseraSuccessiva.getType())) {
    		                	contatore++;
    		                	visited [riga][colonna]= true;
    		                	visited [riga][colonna+1]= true;
    		                }
    		            }
    		        }
    		    }

    		    // Controlla le tessere adiacenti verticalmente
    		    for (int riga = 0; riga < rows - 1; riga++) {
    		        for (int colonna = 0; colonna < columns; colonna++) {
    		        	Tile tilePrevious = schemaMatrice [riga][colonna - 1 ];
    		            Tile tesseraCorrente = schemaMatrice[riga][colonna];
    		            Tile tesseraSuccessiva = schemaMatrice[riga + 1][colonna];
    		            if ((!visited [riga][colonna])&& (!visited [riga+1][colonna])&&(tesseraCorrente.getType() != null && tesseraSuccessiva.getType() != null && tilePrevious.getType() != null)) {
    		                if (tesseraCorrente.getType().equals(tesseraSuccessiva.getType())) {
    		                	contatore++;
    		                	visited [riga][colonna]= true;
    		                	visited [riga+1][colonna]= true;
    		                }
    		            }
    		        }
    		    }

    		    return contatore; // Non sono state trovate tessere adiacenti dello stesso tipo
    	  
      }
}

