
package components;

import my_shelfie.GameMaster;
import my_shelfie.Sacchetto;
import tile.Tile;

/**
 * Classe che rappresenta la board di gioco. La board è composta da una matrice
 * di Tile denominata playGround. Viene utilizzato il sacchetto s per il
 * pescaggio delle tessere. Il costruttore Board inizializza la matrice
 * playGround con oggetti Tile vuoti. La dimensione della matrice è basata sul
 * numero di colonne e righe del GameMaster.
 */
public class Board {
	Sacchetto s = new Sacchetto();
	public static Tile[][] playGround = new Tile[GameMaster.g.getCols()][GameMaster.g.getRows()];
	public static Board b = new Board();

	public Board() {// Board constructor, initializing private members
		for (int i = 0; i < GameMaster.g.getCols(); ++i)
			for (int j = 0; j < GameMaster.g.getRows(); ++j)
				playGround[i][j] = new Tile();
	}

	/**
	 * Riempie la board di gioco con tessere estratte dal sacchetto. La funzione
	 * itererà attraverso la matrice playGround e, per ogni elemento, verificherà se
	 * la posizione (i, j) è accessibile nel GameMaster e se la tessera
	 * corrispondente è vuota (cioè non ha un tipo assegnato). Se entrambe le
	 * condizioni sono verificate, verrà estratta una tessera dal sacchetto e
	 * assegnata alla posizione (i, j) nella matrice playGround. Questa funzione
	 * consente di riempire la board di gioco con tessere vuote disponibili nel
	 * sacchetto, per consentire ai giocatori di posizionare le loro tessere durante
	 * il gioco.
	 */
	// reused to refill when empty (control with isEmpty )
	public void fill() {
		for (int i = 0; i < GameMaster.g.getCols(); ++i)
			for (int j = 0; j < GameMaster.g.getRows(); ++j) {
				if (GameMaster.g.isTileAccessible(i, j) && playGround[i][j].getType() == null) {
					playGround[i][j] = Sacchetto.pescaTessera();
				}
			}
	}

	
	

/**
 * Restituisce la tessera nella posizione specificata sulla board di gioco.
 * x La coordinata x della posizione della tessera.
 * y La coordinata y della posizione della tessera.
*/
	public Tile getTile(int _x, int _y) {
		return playGround[_x][_y];
	}

	
	
	/**Pesca una tessera dalla posizione specificata sulla board di gioco.
	 * La tessera viene rimossa dalla board impostando il suo tipo a null.
	 * x La coordinata x della posizione della tessera.
	 * y La coordinata y della posizione della tessera.
	 * restituisce La tessera pescata dalla posizione specificata sulla board di gioco.
	*/
	public static Tile pescaTile(int x, int y) {
		Tile t = new Tile(playGround[x][y]);
		playGround[x][y].setType(null);
		return t;
	}

	

	
	/**Verifica se è possibile pescare una tessera dalla posizione specificata sulla board di gioco.
	 * La funzione restituisce true se la tessera nella posizione specificata è vuota (non ha un tipo assegnato) e
	 * se la posizione è ai bordi della board (riga 0, riga 8, colonna 0, colonna 8), altrimenti restituisce false.
	 * Inoltre, se la tessera nella posizione specificata non è vuota, la funzione verifica se esistono spazi
	 * vuoti adiacenti (nella riga precedente o successiva, o nella colonna precedente o successiva) e restituisce
	 * true se almeno uno di questi spazi è vuoto, altrimenti restituisce false.
	 * x La coordinata x della posizione della tessera.
	 * y La coordinata y della posizione della tessera.
	 * true se è possibile pescare una tessera dalla posizione specificata sulla board di gioco, false altrimenti.
	*/
	public boolean puoPescare(int x, int y) {
		if (this.playGround[x][y].getType() == null) {
			return false;
		}
		if (x == 0 || x == 8 || y == 0 || y == 8) {
			return true;
		}
		if (this.playGround[x][y] != null) {
			if (((x > 0 && this.playGround[x - 1][y].getType() == null)
					|| (x < GameMaster.g.getRows() && this.playGround[x + 1][y].getType() == null))
					|| ((y > 0 && this.playGround[x][y - 1].getType() == null)
							|| (y < GameMaster.g.getCols() && this.playGround[x][y + 1].getType() == null))) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	
	
	
	

/**Verifica se la plancia di gioco è vuota e richiede di essere riempita.
 * La funzione controlla se ci sono tessere con altre tessere adiacenti sulla plancia di gioco.
 * Se non ci sono tessere adiacenti in nessuna direzione per tutte le tessere presenti sulla plancia,
 * la funzione restituisce true, altrimenti restituisce false.
*/
	public boolean isEmpty() {// controlla se la plancia è da riempire
		int counter = 0; // conta qunate tessere con altre tessere adiacenti ci sono
		for (int i = 0; i < GameMaster.g.getRows(); i++) {
			for (int j = 0; j < GameMaster.g.getCols(); j++) {
				if (this.playGround[i][j].getType() != null) {
					if (((i > 0 && this.playGround[i - 1][j].getType() != null)
							|| (i < GameMaster.g.getRows() - 1 && this.playGround[i + 1][j].getType() != null))
							|| ((j > 0 && this.playGround[i][j - 1].getType() != null)
									|| (j < GameMaster.g.getCols() - 1
											&& this.playGround[i][j + 1].getType() != null))) {
						counter++;
					}
				}

			}
		}
		if (counter == 0) {
			return true;
		} else {
			return false;
		}
	}

	
	
	

/**Inserisce una tessera nella plancia di gioco alla colonna specificata.
 * t La tessera da inserire.
 *x La colonna in cui inserire la tessera.
*/
	public void inserisciTile(Tile t, int x) {

	}

	
	
	
	/**
	 * Stampa la plancia di gioco.
	 * Ogni cella della plancia corrisponde a una tessera.
	 * Se una cella è vuota, viene stampato uno spazio vuoto.
	*/
	public void printBoard() {
		for (int i = 0; i < 9; ++i) {
			System.out.print("\t " + i);
		}
		System.out.println(" ");
		for (int i = 0; i < 9; ++i) {
			System.out.print(i + "\t ");
			for (int j = 0; j < 9; ++j) {
				if (this.getTile(i, j) != null) {
					System.out.print(this.getTile(i, j).toString() + "\t");
				} else {
					System.out.print("");
				}
			}
			System.out.println("\n");
		}
	}
}
