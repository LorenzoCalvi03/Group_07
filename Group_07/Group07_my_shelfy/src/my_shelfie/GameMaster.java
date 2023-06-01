package my_shelfie;

import common_goal_cards.CommonGoal;
import common_goal_cards.PilaCommonGoals;

/**
 * La classe GameMaster rappresenta il gestore della plancia del gioco. Contiene
 * informazioni sul numero di colonne e righe della plancia, la pila di
 * obiettivi comuni disponibili e il numero di giocatori. Fornisce anche metodi
 * per verificare l'accessibilità di una tessera e per impostare il numero di
 * giocatori.
 */
public class GameMaster {
	/**
	 * Istanza singleton del GameMaster.
	 */
	public static GameMaster g = new GameMaster();
	int cols = 9;
	int rows = 9;

	PilaCommonGoals p = new PilaCommonGoals();
	CommonGoal commongoal1 = new CommonGoal(PilaCommonGoals.pescaCarta());
	CommonGoal commongoal2 = new CommonGoal(PilaCommonGoals.pescaCarta());

	private int[][] accessible_tiles = { { 5, 5, 5, 3, 4, 5, 5, 5, 5 }, { 5, 5, 5, 2, 2, 4, 5, 5, 5 },
			{ 5, 5, 3, 2, 2, 2, 3, 5, 5 }, { 5, 4, 2, 2, 2, 2, 2, 2, 3 }, { 4, 2, 2, 2, 2, 2, 2, 2, 4 },
			{ 3, 2, 2, 2, 2, 2, 2, 4, 5 }, { 5, 5, 3, 2, 2, 2, 3, 5, 5 }, { 5, 5, 5, 4, 2, 2, 5, 5, 5 },
			{ 5, 5, 5, 5, 4, 3, 5, 5, 5 } };
	int nPlayers = 0;

	/**
	 * Costruttore privato della classe GameMaster.
	 */
	GameMaster() {
	}

	/**
	 * Verifica se la tessera nella posizione specificata è accessibile in base al
	 * numero di giocatori.
	 * 
	 * @param _x La coordinata x della tessera.
	 * @param _y La coordinata y della tessera.
	 * @return True se la tessera è accessibile, altrimenti false.
	 */
	public boolean isTileAccessible(int _x, int _y) {
		if (accessible_tiles[_x][_y] <= nPlayers) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Restituisce il numero di colonne del gioco.
	 * 
	 * @return Il numero di colonne.
	 */
	public int getCols() {
		return cols;
	}

	/**
	 * Imposta il numero di colonne del gioco.
	 * 
	 * @param cols Il numero di colonne da impostare.
	 */
	public void setCols(int cols) {
		this.cols = cols;
	}

	/**
	 * Restituisce il numero di righe del gioco.
	 * 
	 * @return Il numero di righe.
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * Imposta il numero di righe del gioco.
	 * 
	 * @param rows Il numero di righe da impostare.
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * Imposta il numero di giocatori.
	 * 
	 * @param _in Il numero di giocatori.
	 */
	public void set_players(int _in) {
		nPlayers = _in;
	}

}
