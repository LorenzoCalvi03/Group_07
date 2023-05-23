package components;

import my_shelfie.GameMaster;
import my_shelfie.Sacchetto;
import tile.Tile;

public class Board {
	private Tile[][] playGround = new Tile[GameMaster.g.getCols()][GameMaster.g.getRows()];
	public Board() {// Board constructor, initializing private members
		for (int i = 0; i < GameMaster.g.getCols(); ++i)
			for (int j = 0; j < GameMaster.g.getRows(); ++j)
				playGround[i][j] = new Tile();
	}

	// reused to refill when empty (control with isEmpty )
	public void fill() {
		for (int i = 0; i < GameMaster.g.getCols(); ++i)
			for (int j = 0; j < GameMaster.g.getRows(); ++j) {
				if (GameMaster.g.isTileAccessible(i, j) && playGround[i][j].getType() == null) {
					playGround[i][j] = Sacchetto.pescaTessera();
				}
			}
	}

	public Tile getTile(int _x, int _y) {
		return playGround[_x][_y];
	}

	public boolean puoPescare(int x, int y) {
		if (this.playGround[x][y] != null) {
			if ((x > 0 && this.playGround[x - 1][y] != null)
					|| (x < GameMaster.g.getRows() - 1 && this.playGround[x + 1][y] != null)
					|| (y > 0 && this.playGround[x][y - 1] != null)
					|| (y < GameMaster.g.getCols() - 1 && this.playGround[x][y + 1] != null)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean isEmpty() {// controlla se la plancia è da riempire
		int counter = 0; // conta qunate tessere con altre tessere adiacenti ci sono
		for (int i = 0; i < GameMaster.g.getRows(); i++) {
			for (int j = 0; j < GameMaster.g.getCols(); j++) {
				if(puoPescare(i, j)) {
					counter++;
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
