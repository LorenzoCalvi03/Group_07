package my_shelfie;

import java.util.Scanner;

import components.Board;
import components.Bookshelf;
import tile.Tile;

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
		if (this.shelf.emptySpace()) {
			this.finito = false;
		}

		else {
			this.finito = true;
		}

		return this.finito;
	}

	public void pescaCarte() {
		int ncarte=this.shelf.nTile();
		int x=0,y=0;
		Scanner sc= new Scanner(System.in);
	for(int i=0;i<ncarte;i++){
		System.out.println("dammi l'ordinata della x della carta da pescare");
		x=sc.nextInt();
		System.out.println("dammi l'ordinata della y della carta da pescare");
		y=sc.nextInt();
		Tile t=new Tile(Board.b.pescaTile(x,y));
	
		
	}
	}
}
