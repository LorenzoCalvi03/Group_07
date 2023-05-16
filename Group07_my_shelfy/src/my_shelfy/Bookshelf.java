package my_shelfy;
import java.util.*;

public class Bookshelf {
	private int rows=5;
	private int columns=4;
	 private
	    Bookshelf[][] schemaMatrice = new Bookshelf[rows][columns];
	
	public Bookshelf() // Bookshelf constructor, initializing private rows and columns
	{
		for (int i = 0; i < rows; ++i)
			for (int j = 0; j < columns; ++j)
				schemaMatrice[i][j] = new Bookshelf();
	}
	
	public int getColumns(){
		int colSel;
		do {
		Scanner sc= new Scanner(System.in);
		System.out.println("In che colonna vuoi inserire le carte?");
		colSel=sc.nextInt();// per colSel s'intende la colonna selezionata dal giocatore
		
		if(colSel<rows && colSel>columns) {
			System.out.println("Colonna inesistente, seleziona una colonna giusta");
			sc.close();
		}
		}while(colSel<rows && colSel>columns);
		
		return colSel;	
	}
		
		
		public int countEmptyspace (Bookshelf[][] schemaMatrice, int colSel) {
			int emptySpaces=0;
			
			for(int i=0; i<schemaMatrice.length; i++) {
				if (schemaMatrice[i][colSel]== null) {
					emptySpaces++;
				}
			}
			System.out.println("La colonna ha"+emptySpaces+" spazi vuoti");
			return emptySpaces;
		}

		
		public int nTile () {
			int TileDaInserire;
			do {
			Scanner sc= new Scanner(System.in);
			System.out.println("quante carte vuoi inserire? (compreso tra 1 e 3)");
			TileDaInserire=sc.nextInt();
			
			if(TileDaInserire<1 && TileDaInserire>3) {
				System.out.println("per le regole del gioco, si possono raccogliere solo Tile da 1 a 3");
				sc.close();
			}
			}while(TileDaInserire<1 && TileDaInserire>3);
			
			return TileDaInserire;
		}
		
	}
	//possiamo sviluppare metodi che data una colonna ti restituiscano gli spazi vuoti, con gli oppptuni controlli
	
	
	
	
    /*
	public static List<int[]> getFreePositions(Bookshelf[][] schemaMatrice){
		List<int[]> freePositions = new ArrayList<>();
		
		for(int i=0; i< rows; i-- ) {
			
			
		}
	}

	*/
	
	
	
	
	/*
	public static void fillColumns(Bookshelf[][] schemaMatrice , int colSel ) {
		
		for(int i=0; i<rows; i++) {
			if(rows[i])
			schemaMatrice[i][colSel]
		}
	}
	*/
	
