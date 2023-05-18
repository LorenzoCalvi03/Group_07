package my_shelfy;

import java.util.*;

public class Board {
	private Tile[][] playGround = new Tile[Game_Master.g.cols][Game_Master.g.rows];
	private Sacchetto s= new Sacchetto();

	public Board() {// Board constructor, initializing private members
		for (int i = 0; i < Game_Master.g.cols; ++i)
			for (int j = 0; j < Game_Master.g.rows; ++j)
				playGround[i][j] = new Tile();
	}

	// reused to refill when empty (control with isEmpty )
	void fill() {
		for (int i = 0; i < Game_Master.g.cols; ++i)
			for (int j = 0; j < Game_Master.g.rows; ++j) {
				if (Game_Master.g.is_tile_accessible(i, j)) {
					playGround[i][j] = Sacchetto.pescaTessera();
				}
			}
	}

	Tile getTile(int _x, int _y) {
		return playGround[_x][_y];
	}

	public boolean isEmpty() {// controlla se la plancia è da riempire
		int counter = 0; // conta qunate tessere con altre tessere adiacenti ci sono
		for (int i = 0; i < Game_Master.g.rows; i++) {
			for (int j = 0; j < Game_Master.g.cols; j++) {
				if (this.playGround[i][j] != null) {
					if ((i > 0 && this.playGround[i - 1][j] != null)
							|| (i < Game_Master.g.rows - 1 && this.playGround[i + 1][j] != null)
							|| (j > 0 && this.playGround[i][j - 1] != null)
							|| (j < Game_Master.g.cols - 1 && this.playGround[i][j + 1] != null)) {
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
}
