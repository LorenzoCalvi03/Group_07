package my_shelfie;

import components.Bookshelf;

public class Player {
	private int points;
	public static int COUNTER;
	private Bookshelf shelf;
	// private Personalgoal personal;
	private int turno;
	private boolean finito=false;

	public Player() {
		if (COUNTER < 4) {
			COUNTER++;
		}
		this.points = 0;
	}

	public void setPoint(int point) {
		this.points = point;
	}

	public int getPoint() {
		return this.points;
	}

	/*
	 * public void incrementaPunti() { int point=this.points //
	 * point=personal.getpoint;; this.points=
	 * 
	 * }
	 */
	public void turno() {

		while (this.finePartita() != true) {

		}
	}

	public boolean finePartita() {
		if (this.shelf.countEmptyspace() > 0) {
			this.finito = false;
		}

		else {
			this.finito = true;
		}

		return finito;
	}

	public void pescaCarte(int cord[][]) {
		int ncolonna = 0;
		int nTile = 0;
		ncolonna = shelf.getColumns();
		nTile = shelf.nTile();
	}
}
