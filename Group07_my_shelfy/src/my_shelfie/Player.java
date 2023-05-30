package my_shelfie;

import java.util.*;
import components.Board;
import components.Bookshelf;
import tile.Tile;
import tile.TileObject;
import common_goal_cards.CommonGoal;
import common_goal_cards.TypeCG;

public class Player {
	private String Username;
	private int points;
	public static int COUNTER;
	private Bookshelf shelf;
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
		System.out.println("Questa è la tua Bookshelf:  ");
		shelf.StampaMatrice();
		this.assignRandomTileObject();
		}
	public String getUsername() { //metodo costruito per ritornare lo Username nel Main
	    return this.Username;
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
		this.shelf.StampaMatrice();
		int colSel=shelf.getColumns();
		int ncarte=this.shelf.nTile(colSel);
		int s=0;
		int x=0,y=0,colonna=0;;
		Scanner sc= new Scanner(System.in);
		System.out.println("Se vuoi pescare da una riga scegli 1,  se vuoi pescare da una colonna scegli 2");
		s=sc.nextInt();
		if(s==1) {
	    Board.b.printBoard();
		System.out.println("digita il numero della riga della carta da pescare");
	    x=sc.nextInt();
		for(int i=0;i<ncarte;i++){
		Board.b.printBoard();
		System.out.println("digita il numero della colonna della carta da pescare");
		y=sc.nextInt();
		while(!Board.b.puoPescare(x,y)) {
		System.out.println("La carta in posizione (" + x + ", " + y + ") non è pescabile.");
		System.out.println("Inserisci un'altra coppia di coordinate:");
		System.out.println("digita il numero della riga della carta da pescare");
		x=sc.nextInt();
		System.out.println("digita il numero della colonna della carta da pescare");
		y=sc.nextInt();
		}
		Tile t=new Tile(Board.b.pescaTile(x,y));
		shelf.inserisciTile(colSel,t);
		shelf.StampaMatrice();
		}
		}
		if(s==2) {
		System.out.println("digita il numero della colonna della carta da pescare");
		y=sc.nextInt();
		for(int i=0;i<ncarte;i++){
		Board.b.printBoard();	
		System.out.println("digita il numero della riga della carta da pescare");
		x=sc.nextInt();
		while(!Board.b.puoPescare(x,y)) {
		    System.out.println("La carta in posizione (" + x + ", " + y + ") non è pescabile.");
		    System.out.println("Inserisci un'altra coppia di coordinate:");
		    System.out.println("digita il numero della riga della carta da pescare");
		    x=sc.nextInt();
		    System.out.println("digita il numero della colonna della carta da pescare");
		    y=sc.nextInt();
		    }
		Tile c=new Tile(Board.b.pescaTile(x,y));
		shelf.inserisciTile(colSel,c);
		shelf.StampaMatrice();
		}
	}
	}

	  private void assignRandomTileObject() {
	        int tileObjectNumber = assignRandomTileObjectNumber();
	        this.tileObject = new TileObject(tileObjectNumber);
	        System.out.println("Questa è la carta obiettivo personale di: "+ this.Username);
	        tileObject.printTileObject();
	    }// responsabile della generazione e assegnazione effettiva dell'oggetto TileObject casuale al giocatore corrente

	    private int assignRandomTileObjectNumber() {
	        List<Integer> tileObjectOrder = TileObject.generateRandomTileObjectOrder();
	        return tileObjectOrder.get(COUNTER % 4);//viene utilizzato per ottenere l'elemento corrispondente all'indice calcolato da counter % 4 dalla lista tileObjectOrder
	    }//generatore casuale delle Carte Obiettivo Personale
	    	
	
	@Override
	public String toString() {
		String p= this.Username;
		return p;
		
	}
	
	public void personalGoalPoints() {//conta e somma punti personal goal
		int counter=0;
		for(int i=0; i<6; i++) {
			for (int j=0; j<5; j++) {
				if(this.shelf.getTile(i, j).equals(this.tileObject.getType(i, j))) {
					counter++;
				}
			}
		}
		switch(counter){
		case 1:
			this.points+=1;
			break;
		case 2:
			this.points+=2;
			break;
		case 3:
			this.points+=4;
			break;
		case 4:
			this.points+=6;
			break;
		case 5:
			this.points+=9;
			break;
		case 6:
			this.points+=12;
			break;
		default:
			points+=0;
			break;
		}
	}
	}