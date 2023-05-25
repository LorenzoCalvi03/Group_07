package my_shelfie;

import java.util.*;
import components.Board;
import components.Bookshelf;
import tile.Tile;
import tile.TileObject;

public class Player {
	private String Username;
	private int points;
	public static int COUNTER;
	private Bookshelf shelf;
	// private Personalgoal personal;
	private int turno;
	private TileObject tileObject;
	private boolean finito=false;
	private static Set<String> usedUsernames = new HashSet<String>();
	
	public Player(String Username) {
		while(usedUsernames.contains(Username)) {
			System.out.println("Il nome utente è già stato utilizzato. Inserire un nuovo nome utente:");
			Username = new Scanner(System.in).nextLine();
        }
		this.Username=Username;
		usedUsernames.add(Username);
		this.shelf= new Bookshelf();
		shelf.StampaMatrice();
		this.assignRandomTileObject();
		
		
	}

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
		int colSel=shelf.getColumns();
		int ncarte=this.shelf.nTile(colSel);
		int x=0,y=0,colonna=0;;
		Scanner sc= new Scanner(System.in);
	for(int i=0;i<ncarte;i++){
		System.out.println("dammi l'ordinata della x della carta da pescare");
		x=sc.nextInt();
		System.out.println("dammi l'ordinata della y della carta da pescare");
		y=sc.nextInt();
		Tile t=new Tile(Board.b.pescaTile(x,y));
		  
		
		}
		
	}
	  private void assignRandomTileObject() {
	        int tileObjectNumber = assignRandomTileObjectNumber();
	        this.tileObject = new TileObject(tileObjectNumber);
	        System.out.println("Questa è la carta obiettivo personale di: "+ this.Username);
	        tileObject.printTileObject();
	    }

	    private int assignRandomTileObjectNumber() {
	        List<Integer> tileObjectOrder = TileObject.generateRandomTileObjectOrder();
	        return tileObjectOrder.get(COUNTER % 4);
	    }
	
	
	
	@Override
	public String toString() {
		String p= this.Username;
		return p;
		
	}
	}

