package my_shelfy;

public class Game_Master {

	public static Game_Master g = new Game_Master();
	int cols = 9;
	int rows = 9;

	private int[][] accessible_tiles = { { 5, 5, 5, 3, 4, 5, 5, 5, 5 }, { 5, 5, 5, 2, 2, 4, 5, 5, 5 },
			{ 5, 5, 3, 2, 2, 2, 3, 5, 5 }, { 5, 4, 2, 2, 2, 2, 2, 2, 3 }, { 4, 2, 2, 2, 2, 2, 2, 2, 4 },
			{ 3, 2, 2, 2, 2, 2, 2, 4, 5 }, { 5, 5, 3, 2, 2, 2, 3, 5, 5 }, { 5, 5, 5, 4, 2, 2, 5, 5, 5 },
			{ 5, 5, 5, 5, 4, 3, 5, 5, 5 } };
	int n_players = 0;

	// chiedere come riempire piu facilmente il tavolo da gioco senza contare
	// casella per casella
	Game_Master() {
	}

	public
	// check if given tile at x y is accesible based on number of players
	boolean is_tile_accessible(int _x, int _y)

	{
		if (accessible_tiles[_x][_y] <= n_players) {
			return true;
		}

		return false;
	}

	void set_players(int _in) {
		n_players = _in;
	}

};
