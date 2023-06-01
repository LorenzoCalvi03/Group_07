
package components;

import java.util.*;

import tile.Tile;

public class Bookshelf {
	private int rows = 6;
	private int columns = 5;
	private int LimiteCarte = 3;
	private int[] conteggioCarte;
	private Tile[][] schemaMatrice = new Tile[rows][columns];

	
	
	
	/**
	 * Costruisce un nuovo oggetto Bookshelf.
	 * Inizializza la libreria creando e assegnando le Tile a ciascuna posizione nella matrice dello schema.
	 *Ogni Tile rappresenta una posizione potenziale di archiviazione per Bookshelf.
	 *Il numero di righe e colonne della libreria è determinato dalle variabili private della classe.
	 *La matrice dello schema è un array bidimensionale che rappresenta la disposizione della libreria
	*/
	public Bookshelf() // Bookshelf constructor, initializing private rows and columns
	{
		for (int i = 0; i < rows; ++i)
			for (int j = 0; j < columns; ++j)
				schemaMatrice[i][j] = new Tile();
	}

	
	
	
	/**Stampa la matrice dello schema della libreria.
	 * La funzione stamperà il contenuto di ciascuna posizione.
	 * Ogni elemento della matrice rappresenta una posizione di archiviazione, che può contenere una Tile o essere vuoto.
	 * La stampa viene effettuata in un formato tabellare, con le righe e le colonne numerate.
	 * Per ogni elemento della matrice, viene stampata la rappresentazione testuale dell'oggetto Tile corrispondente.
	 * Si noti che questa funzione assume che la matrice dello schema sia stata correttamente inizializzata
	 * e che il numero di righe e colonne sia stato impostato correttamente.
	*/
	public void StampaMatrice() {
		for (int i = 0; i < 5; ++i) {
			System.out.print("\t "+i);
		}
		System.out.println(" ");
		for (int riga = 0; riga < rows; riga++) {
			System.out.print(riga+"\t ");
			for (int colonna = 0; colonna < columns; colonna++) {
				System.out.print(schemaMatrice[riga][colonna].toString()+"\t");
			}
			System.out.println("");
		}
		System.out.println(" ");
	}
	
	
	
	/**
	 *Inizializza la matrice dello schema della libreria.
	 *La funzione itera attraverso la matrice dello schema e crea una nuova istanza di Tile
	 *e la assegna a ciascuna posizione della matrice.
	 *Questa funzione viene utilizzata per inizializzare la matrice dello schema della libreria
	 *con oggetti Tile vuoti o predefiniti.
	 *Si noti che questa funzione assume che il numero di righe e colonne della matrice sia stato impostato correttamente.
	*/
	public void inizializzaMatrice() {
		for (int riga = 0; riga < rows; riga++) {
			for (int colonna = 0; colonna < columns; colonna++) {
				schemaMatrice[riga][colonna] = new Tile();
			}
		}
	}

	
	
	/**
	 * La funzione richiede all'utente di inserire il numero di colonna desiderato
	 * utilizzando la classe Scanner per leggere l'input dalla console.
	 * Viene effettuato un controllo per assicurarsi che il valore inserito sia compreso tra 0 e 5.
	 * Se il valore inserito non è valido, viene richiesto all'utente di inserire un valore valido.
	 * Restituisce il numero di colonna selezionato dall'utente.
	*/
	public int getColumns() {
		int colSel;

			Scanner sc = new Scanner(System.in);
			System.out.println("In che colonna vuoi inserire le carte?");
			colSel = sc.nextInt();// per colSel s'intende la colonna selezionata dal giocatore

			while (colSel < 0 || colSel > 5) {
				System.out.println("per le regole del gioco, si possono inserire solo nelle colonne da 0 a 5, inserisci valore valido");
				colSel = sc.nextInt();
			}
		return colSel;
	}
	
	
	
	

/**
 * Conta lo spazio vuoto disponibile nella colonna specificata.
 * La funzione itera attraverso la colonna selezionata della matrice dello schema
 * e conta il numero di posizioni vuote.
 * Viene verificato il tipo di oggetto nella posizione della matrice.
 * Se l'oggetto è null, significa che la posizione è vuota e viene incrementato il conteggio degli spazi vuoti.
 * restituisce Il numero di spazi vuoti disponibili nella colonna selezionata.
*/

	public int countEmptyspace(int colSel) {

		int emptySpaces = 0;

		for (int i = 0; i < schemaMatrice.length; i++) {
			if (schemaMatrice[i][colSel].getType() == null) {
				emptySpaces++;
			}
		}
		return emptySpaces;
	}

	
	
	

/**
 * Determina il numero di Tile da inserire nella colonna specificata.
 * La funzione guida l'utente nella scelta del numero di Tile da inserire,
 * richiedendo l'input fino a quando viene fornito un valore valido compreso tra 1 e 3.
 * Successivamente, viene verificato se lo spazio disponibile nella colonna è sufficiente per il numero di Tile scelto.
 * Se lo spazio disponibile è inferiore al numero di mattonelle scelto, l'utente viene avvisato
 * e viene data la possibilità di cambiare colonna o di scegliere un diverso numero di Tile da inserire.
 * @param colSel Il numero di colonna selezionato.
 * @return Il numero di mattonelle da inserire nella colonna selezionata.
*/
	public int nTile(int colSel) {
		int TileDaInserire = 0;
		do {

			do {
				TileDaInserire=this.scegliSpazi();

			} while (TileDaInserire < 1 || TileDaInserire > 3);
			if (countEmptyspace(colSel) < TileDaInserire) {
				Scanner sc= new Scanner(System.in);
				int scelta=0;
					System.out.println("Numero di spazi non disponibili ");
					System.out.println("Decidi se cambiare colonna premendo 1 o quanti spazi da inserire premendo 2  ");
					scelta=sc.nextInt();
					if(scelta==1){
						TileDaInserire=this.scegliSpazi();
					}
					else{
						colSel=this.getColumns();
					}
			}
			
		} while (countEmptyspace(colSel) < TileDaInserire);
		return TileDaInserire;
	}
	
	
	

/**
 * La funzione richiede all'utente di inserire il numero desiderato di Tile da inserire,
 * utilizzando la classe Scanner per leggere l'input dalla console.
 * Viene effettuato un controllo per assicurarsi che il valore inserito sia compreso tra 1 e 3.
 * Se il valore inserito non è valido, viene richiesto all'utente di inserire un valore valido.
 * Ritorna Il numero di Tile da inserire scelto dall'utente.
*/
		public int scegliSpazi() {
			int TileDaInserire;
			Scanner sc = new Scanner(System.in);
			System.out.println("quante carte vuoi inserire? (compreso tra 1 e 3)");
		    TileDaInserire = sc.nextInt();
			while (TileDaInserire < 1 || TileDaInserire > 3) {
				System.out.println("per le regole del gioco, si possono raccogliere solo Tile da 1 a 3, inserisci valore valido");
				TileDaInserire = sc.nextInt();
			}
		
			return TileDaInserire;
		}
		
		
		
		
		/**
		 * La funzione scorre la matrice
		 * e conta il numero di celle vuote, ovvero quelle in cui il tipo di Tile è null.
		 * Se il conteggio delle celle vuote è uguale a 0, significa che non ci sono celle vuote nella libreria.
		 * In tal caso, la funzione restituisce false.
		 * Altrimenti, se ci sono almeno una o più celle vuote, la funzione restituisce true.
		*/
	public boolean emptySpace() {//ritorna se esistono celle vuote nella shelf
		int counter = 0;
		for (int i = 0; i < schemaMatrice.length; i++) {
			for (int j = 0; j < schemaMatrice[0].length; j++) {
				if (schemaMatrice[i][j].getType() == null) {
					 counter ++;
			}
		}
		}
		if(counter == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	
	

/**
 * La funzione controlla le tessere adiacenti orizzontalmente e verticalmente nella matrice dello schema.
 * Viene utilizzata una matrice booleana "visited" per tenere traccia delle posizioni già controllate.
 * Per le tessere adiacenti orizzontalmente, viene verificato se la tessera corrente e la tessera successiva
 * hanno lo stesso tipo non nullo e non sono state visitate. In caso affermativo, il contatore viene incrementato
 * e le posizioni vengono contrassegnate come visitate.
 * Per le tessere adiacenti verticalmente, viene verificato se la tessera corrente, la tessera successiva
 * e la tessera precedente hanno lo stesso tipo non nullo e non sono state visitate. In caso affermativo,
 * il contatore viene incrementato e le posizioni vengono contrassegnate come visitate.
 * restituisce Il numero di tessere adiacenti nella libreria.
*/
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
	
	
	
	
	

/*
 *La funzione richiede all'utente di selezionare la riga in cui inserire la tessera,
 *utilizzando la classe Scanner per leggere l'input dalla console.
 *Successivamente, la tessera viene inserita nella posizione corrispondente nella matrice dello schema.
 *Si noti che questa funzione non esegue controlli sulla validità della riga e colonna selezionate,
 *quindi è responsabilità dell'utilizzatore assicurarsi che siano valori validi.
 *colSel Il numero di colonna in cui inserire la tessera.
 *t La tessera da inserire.
*/
	public void inserisciTile(int colSel,Tile t) {
		Scanner sc = new Scanner(System.in);
		int riga;
			this.StampaMatrice();
			System.out.println("Scegli in che riga inserire la tessera (se vuota si deve partire da 5)");
		    riga = sc.nextInt();
			schemaMatrice[riga][colSel] = t;
			sc.nextLine();

	}
	
	
	
	
	

/**
 * La funzione restituisce la tessera nella posizione corrispondente alle coordinate (x, y)
 * nella matrice dello schema della libreria.
 * Si noti che questa funzione non esegue controlli sulla validità delle coordinate fornite,
 * quindi è responsabilità dell'utilizzatore assicurarsi che siano valori validi.
 *x La coordinata x della posizione della tessera.
 *y La coordinata y della posizione della tessera.
*/
	public Tile getTile(int x, int y) {
		return this.schemaMatrice[x][y];
	}
	
	
	
	

/**
 * La funzione restituisce una copia della Bookshelf
 * rappresentata come una matrice di stringhe.
 * Ogni elemento della matrice rappresenta la stringa ottenuta dalla chiamata al metodo toString()
 * dell'oggetto Tile corrispondente nella matrice dello schema.
*/
	public String[][] getSchemaMatrice() {
		 String[][] matrix= new String[rows][columns];
		 for (int i=0;i<this.rows;i++) {
			 for (int j=0; j<this.columns;j++)
			 {
				 matrix[i][j]=this.schemaMatrice[i][j].toString();
			 }
		 }
		 return matrix;
	 }

}
