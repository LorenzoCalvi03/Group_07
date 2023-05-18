package components;

import java.util.*;

import my_shelfie.GameMaster;
import my_shelfie.Sacchetto;
import tile.Tile;

public class Board {
	private Tile[][] playGround = new Tile[GameMaster.g.getCols()][GameMaster.g.getRows()];
	private Sacchetto s= new Sacchetto();

	public Board() {// Board constructor, initializing private members
		for (int i = 0; i < GameMaster.g.getCols(); ++i)
			for (int j = 0; j < GameMaster.g.getRows(); ++j)
				playGround[i][j] = new Tile();
	}

	// reused to refill when empty (control with isEmpty )
	public void fill() {
		for (int i = 0; i < GameMaster.g.getCols(); ++i)
			for (int j = 0; j < GameMaster.g.getRows(); ++j) {
				if (GameMaster.g.isTileAccessible(i, j)) {
					playGround[i][j] = Sacchetto.pescaTessera();
				}
			}
	}

	public Tile getTile(int _x, int _y) {
		return playGround[_x][_y];
	}

	public boolean isEmpty() {// controlla se la plancia è da riempire
		int counter = 0; // conta qunate tessere con altre tessere adiacenti ci sono
		for (int i = 0; i < GameMaster.g.getRows(); i++) {
			for (int j = 0; j < GameMaster.g.getCols(); j++) {
				if (this.playGround[i][j] != null) {
					if ((i > 0 && this.playGround[i - 1][j] != null)
							|| (i < GameMaster.g.getRows() - 1 && this.playGround[i + 1][j] != null)
							|| (j > 0 && this.playGround[i][j - 1] != null)
							|| (j < GameMaster.g.getCols() - 1 && this.playGround[i][j + 1] != null)) {
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
