package my_shelfy;

public class GameMaster {

	public static GameMaster g = new GameMaster();
		int cols = 9;
		int rows = 9;
	
	private int[][] accessible_tiles = {{5, 5, 5, 3, 4, 5, 5, 5, 5}, 
									{5, 5, 5, 2, 2, 4, 5, 5, 5},  
									{5, 5, 3, 2, 2, 2, 3, 5, 5}, 
									{5, 4, 2, 2, 2, 2, 2, 2, 3}, 
									{4, 2, 2, 2, 2, 2, 2, 2, 4}, 
									{3, 2, 2, 2, 2, 2, 2, 4, 5}, 
									{5, 5, 3, 2, 2, 2, 3, 5, 5}, 
									{5, 5, 5, 4, 2, 2, 5, 5, 5}, 
									{5, 5, 5, 5, 4, 3, 5, 5, 5}};
		int nPlayers = 0;
	
	GameMaster() {
	}

	
	// check if given tile at x y is accesible based on number of players
	public boolean isTileAccessible(int _x, int _y)
	{
			if(accessible_tiles[_x][_y] <= nPlayers) 
			{
				return true;
			}	
			else {
			return false;
			}
		}
	

	void set_players(int _in) {
		nPlayers = _in;
	}

}
