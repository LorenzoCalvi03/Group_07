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
	
	public static int[] countEmptyspacePercolumn (Bookshelf[][] schemaMatrice) {
		int[] emptySpacesPercolumn = new int[schemaMatrice[0].length];
		for(int col=0; col<schemaMatrice[0].length;col++) {
			for(int row=0; row<schemaMatrice.length; row++) {
			if (schemaMatrice[row][col]== null) {
		    System.out.println("La colonna"+col+"ha"+emptySpacesPercolumn+" spazi vuoti");
				emptySpacesPercolumn[col]++;
			}
		 }
		}
		return emptySpacesPercolumn;
	}
	
	public static void fillcolumn {
		//questo metodo deve ricevere il numero di carte, e deve verificare se quella colonna è libera
		
	}
	
	
	
	
	
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
	
}
