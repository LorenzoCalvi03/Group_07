package my_shelfie;

import common_goal_cards.CommonGoal;
import common_goal_cards.PilaCommonGoals;

public class GameMaster {

	public static GameMaster g = new GameMaster();
		int cols = 9;
		int rows = 9;
		
		PilaCommonGoals p = new PilaCommonGoals();
		CommonGoal commongoal1 = new CommonGoal(PilaCommonGoals.pescaCarta());
		CommonGoal commongoal2 = new CommonGoal(PilaCommonGoals.pescaCarta());
	
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
	

	public int getCols() {
		return cols;
	}


	public void setCols(int cols) {
		this.cols = cols;
	}


	public int getRows() {
		return rows;
	}


	public void setRows(int rows) {
		this.rows = rows;
	}


	void set_players(int _in) {
		nPlayers = _in;
	}
	

}
