
package my_shelfie;

import java.util.*;
import components.Board;
import components.Bookshelf;
import tile.Tile;
import tile.TileObject;
import common_goal_cards.CommonGoal;
import common_goal_cards.TypeCG;

/**
 * La classe Player rappresenta un giocatore nel gioco Shelfie. Ogni giocatore
 * ha un nome utente univoco, un punteggio, una Bookshelf personale, una carta
 * obiettivo personale (TileObject) e altre proprietà associate.
 */
public class Player {
	private String Username;
	private int points;
	public static int COUNTER;
	private Bookshelf shelf;
	private int turno;
	private TileObject tileObject;
	private boolean finito;
	private static Set<String> usedUsernames = new HashSet<String>();

	/**
	 * Costruttore della classe Player che inizializza un giocatore con un nome
	 * utente. Verifica che il nome utente non sia già stato utilizzato da un altro
	 * giocatore. Crea una nuova Bookshelf vuota per il giocatore e assegna una
	 * carta obiettivo personale casuale.
	 *
	 * @param Username Il nome utente del giocatore.
	 */
	public Player(String Username) {
		while (usedUsernames.contains(Username)) {
			System.out.println("Il nome utente è già stato utilizzato. Inserire un nuovo nome utente:");
			Username = new Scanner(System.in).nextLine();
		}
		this.Username = Username;
		usedUsernames.add(Username);
		this.shelf = new Bookshelf();
		System.out.println("Questa è la tua Bookshelf:  ");
		shelf.StampaMatrice();
		this.assignRandomTileObject();
	}

	/**
	 * Metodo per ottenere il nome utente del giocatore.
	 *
	 * @return Il nome utente del giocatore.
	 */
	public String getUsername() { // metodo costruito per ritornare lo Username nel Main
		return this.Username;
	}

	/**
	 * Costruttore di default della classe Player. Inizializza un giocatore senza
	 * nome utente e senza punti.
	 */
	public Player() {
		if (COUNTER < 4) {
			COUNTER++;
		}
		this.points = 0;
	}

	/**
	 * Imposta il punteggio del giocatore.
	 *
	 * @param point Il punteggio da assegnare al giocatore.
	 */
	public void setPoint(int point) {
		this.points = point;
	}

	/**
	 * Restituisce il punteggio attuale del giocatore.
	 *
	 * @return Il punteggio del giocatore.
	 */
	public int getPoint() {
		return this.points;
	}

	/**
	 * Metodo per gestire il turno del giocatore. Si prosegue con il turno finché la
	 * fine della partita non è raggiunta.
	 */
	public void turno() {

		while (this.finePartita() != true) {

		}
	}

	/**
	 * Controlla se la partita è finita per il giocatore.
	 *
	 * @return true se la partita è finita,altrimenti false.
	 */
	public boolean finePartita() {
		if (this.shelf.emptySpace() == false) {
			this.finito = true;
		}

		else {
			this.finito = false;
		}

		return this.finito;
	}

	/**
	 * Metodo per pescare carte e inserirle nella Bookshelf del giocatore. Permette
	 * al giocatore di selezionare una riga o una colonna per pescare le carte.
	 * Verifica che le coordinate selezionate siano valide e che la carta sia
	 * pescabile.
	 */

	public void pescaCarte() {

		this.shelf.StampaMatrice();
		int colSel = shelf.getColumns();
		int ncarte = this.shelf.nTile(colSel);
		int s = 0;
		int x = 0, y = 0, colonna = 0;
		;
		Scanner sc = new Scanner(System.in);
		System.out.println("Se vuoi pescare da una riga scegli 1,  se vuoi pescare da una colonna scegli 2");
		s = sc.nextInt();
		while (s < 1 || s > 2) {
			System.out.println("Il valore inserito non è corretto, riprova con 1 o 2");
			s = sc.nextInt();
		}

		if (s == 1) {
			Board.b.printBoard();
			System.out.println("digita il numero della riga della carta da pescare");
			x = sc.nextInt();
			for (int i = 0; i < ncarte; i++) {
				Board.b.printBoard();
				System.out.println("digita il numero della colonna della carta da pescare");
				y = sc.nextInt();
				while (!Board.b.puoPescare(x, y)) {
					System.out.println("La carta in posizione (" + x + ", " + y + ") non è pescabile.");
					System.out.println("Inserisci un'altra coppia di coordinate:");
					System.out.println("digita il numero della riga della carta da pescare");
					x = sc.nextInt();
					System.out.println("digita il numero della colonna della carta da pescare");
					y = sc.nextInt();
				}
				Tile t = new Tile(Board.b.pescaTile(x, y));
				shelf.inserisciTile(colSel, t);
				shelf.StampaMatrice();
			}
		}
		if (s == 2) {
			System.out.println("digita il numero della colonna della carta da pescare");
			y = sc.nextInt();
			for (int i = 0; i < ncarte; i++) {
				Board.b.printBoard();
				System.out.println("digita il numero della riga della carta da pescare");
				x = sc.nextInt();
				while (!Board.b.puoPescare(x, y)) {
					System.out.println("La carta in posizione (" + x + ", " + y + ") non è pescabile.");
					System.out.println("Inserisci un'altra coppia di coordinate:");
					System.out.println("digita il numero della riga della carta da pescare");
					x = sc.nextInt();
					System.out.println("digita il numero della colonna della carta da pescare");
					y = sc.nextInt();
				}
				Tile c = new Tile(Board.b.pescaTile(x, y));
				shelf.inserisciTile(colSel, c);
				shelf.StampaMatrice();
			}
		}
	}

	/**
	 * Assegna in modo casuale un oggetto TileObject al giocatore. Genera un numero
	 * casuale per ottenere l'oggetto TileObject dalla lista di oggetti disponibili.
	 */
	private void assignRandomTileObject() {
		int tileObjectNumber = assignRandomTileObjectNumber();
		this.tileObject = new TileObject(tileObjectNumber);
		System.out.println("Questa è la carta obiettivo personale di: " + this.Username);
		tileObject.printTileObject();
	}

	/**
	 * Genera un numero casuale per l'assegnazione dell'oggetto TileObject.
	 * 
	 * @return Il numero casuale assegnato all'oggetto TileObject.
	 */
	private int assignRandomTileObjectNumber() {
		List<Integer> tileObjectOrder = TileObject.generateRandomTileObjectOrder();
		return tileObjectOrder.get(COUNTER % 4);// viene utilizzato per ottenere l'elemento corrispondente all'indice
												// calcolato da counter % 4 dalla lista tileObjectOrder
	}

	@Override
	public String toString() {
		String p = this.Username;
		return p;

	}

	/**
	 * Calcola i punti relativi all'obiettivo personale del giocatore. Conta il
	 * numero di carte posizionate correttamente sulla Bookshelf e assegna i punti
	 * in base a tale numero.
	 */
	public void personalGoalPoints() {// conta e somma punti personal goal
		int counter = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 5; j++) {
				if (this.shelf.getTile(i, j).equals(this.tileObject.getType(i, j))) {
					counter++;
				}
			}
		}
		switch (counter) {
		case 1:
			this.points += 1;
			break;
		case 2:
			this.points += 2;
			break;
		case 3:
			this.points += 4;
			break;
		case 4:
			this.points += 6;
			break;
		case 5:
			this.points += 9;
			break;
		case 6:
			this.points += 12;
			break;
		default:
			points += 0;
			break;
		}
	}

	/**
	 * Calcola i punti totali del giocatore in base al numero di giocatori e alla
	 * sua posizione nella classifica. Aggiunge i punti ottenuti dalle carte comuni
	 * adiacenti, i punti relativi all'obiettivo personale e i punti delle carte
	 * comuni.
	 * 
	 * @param nplay indica il numero dei giocatori e in base a questi i vari
	 *              punteggi da assegnare
	 * @param pos   indica la posizione del giocatore nel completamento delle common
	 *              goal
	 */
	public void CalcoloPunteggio(int nplay, int pos) {
		int commonpoint = 0;
		switch (nplay) {
		case 2:
			if (pos == 1) {
				commonpoint = 8;
			} else {
				commonpoint = 4;
			}
			if (pos == 0) {
				commonpoint = 0;
			}
			break;
		case 3:
			if (pos == 1) {
				commonpoint = 8;
			} else {
				if (pos == 2) {
					commonpoint = 6;
				} else {
					if (pos == 3) {
						commonpoint = 4;
					} else {
						commonpoint = 0;
					}

				}
			}

			break;
		case 4:
			if (pos == 1) {
				commonpoint = 8;
			} else {
				if (pos == 2) {
					commonpoint = 6;
				} else {
					if (pos == 3) {
						commonpoint = 4;
					} else {
						commonpoint = 2;
					}
				}
			}
			if (pos == 0) {
				commonpoint = 0;
			}
			break;
		default:
			commonpoint = 0;
		}
		this.points += shelf.TileAdjacent();
		this.points += commonpoint;
		this.personalGoalPoints();

	}

	/**
	 * Restituisce la Bookshelf del giocatore.
	 * 
	 * @return La Bookshelf del giocatore.
	 */

	public Bookshelf getShelf() {
		return this.shelf;
	}
}
