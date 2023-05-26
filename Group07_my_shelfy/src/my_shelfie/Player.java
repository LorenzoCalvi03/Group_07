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
	private CommonGoal commonGoal1;
	private CommonGoal commonGoal2;
	
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
		this.commonGoal1 = CommonGoal.generateRandomCommonGoal();
		this.commonGoal2 = CommonGoal.generateRandomCommonGoal();
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
		shelf.inserisciTile(colSel,t);  
		
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
	    
	    public CommonGoal getCommonGoal1() {//metodo per prendere le commonGoal, per poi usare questo metodo nel main
	    	return commonGoal1;
	    }
	    
	    public CommonGoal getCommonGoal2() {//metodo per prendere le commonGoal, per poi usare questo metodo nel main
	    	return commonGoal2;
	    }
	    
	
	
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

