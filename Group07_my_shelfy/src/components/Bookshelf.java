
package components;
import java.util.*;

public class Bookshelf {
	private int rows=5;
	private int columns=4;
	private int LimiteCarte=3;
	private int [] conteggioCarte;
	private String[][] schemaMatrice = new String[rows][columns];
	
	public Bookshelf() // Bookshelf constructor, initializing private rows and columns
	{
		for (int i = 0; i < rows; ++i)
			for (int j = 0; j < columns; ++j)
				schemaMatrice[i][j] = new String();
	}
	public void StampaMatrice() {
		for(int riga = 0; riga<rows; riga++) {
			for(int colonna = 0; colonna< columns; colonna++) {
				System.out.println(schemaMatrice[riga][colonna]+ " ");
			}
			System.out.println();
	    }
		System.out.println();
	}
	
	public void inizializzaMatrice() {
		for(int riga = 0; riga<rows; riga++) {
			for(int colonna = 0; colonna< columns; colonna++) {
				schemaMatrice[riga][colonna]= "-";
			}
		}
	}
	
	public int getColumns(){
		int colSel;
		do {
		Scanner sc= new Scanner(System.in);
		System.out.println("In che colonna vuoi inserire le carte?");
		colSel=sc.nextInt();// per colSel s'intende la colonna selezionata dal giocatore
		
		if(colSel<0 || colSel>4) {
			System.out.println("Colonna inesistente, seleziona una colonna giusta");
			sc.close();
		}
		}while(colSel<0 || colSel>4);
		
		return colSel;	
	    }		
		
     public int countEmptyspace () {
			int colSel=getColumns();
			int emptySpaces=0;
			
			for(int i=0; i<schemaMatrice.length; i++) {
				if (schemaMatrice[i][colSel]== "-") {
					emptySpaces++;
				}
			}
			return emptySpaces;	
		}
      public int nTile () {
			int TileDaInserire;
			do {
			Scanner sc= new Scanner(System.in);
			System.out.println("quante carte vuoi inserire? (compreso tra 1 e 3)");
			TileDaInserire=sc.nextInt();
			
			if(TileDaInserire<1 || TileDaInserire>3) {
				System.out.println("per le regole del gioco, si possono raccogliere solo Tile da 1 a 3");
				sc.close();
			}
			}while(TileDaInserire<1 || TileDaInserire>3);
			
			return TileDaInserire;
		}
     public boolean emptySpace () {
 			boolean emptySpaces=true;
 			
 			for(int i=0; i<schemaMatrice.length; i++) {
 				for(int j=0;i<schemaMatrice[0].length;j++) {

 				if (schemaMatrice[i][j].getType()==null ) {
 					emptySpaces=true;
 				}else {
 					return false;
 				}
 				}
 			}
 			return emptySpaces;	
 		}
		}