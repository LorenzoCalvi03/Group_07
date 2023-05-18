package my_shelfie;

import components.Bookshelf;

public class Player {
	private int points;
	public static int COUNTER;
	private Bookshelf shelf;
	// private Personalgoal personal;
	private int turno;

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

	/*
	 * public void turno() {
	 * 
	 * }
	 */
	public boolean finePartita() {
		boolean finito=false;
		if(this.shelf.countEmptyspace()>0) {
			finito=false;}
		
		else {
			finito=true;
		}
		
	 return finito;
}
}
