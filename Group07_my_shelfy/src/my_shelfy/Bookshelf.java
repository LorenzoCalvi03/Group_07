package my_shelfy;
import java.util.*;

public class Bookshelf {
	private int rows=6;
	private int columns=5;
	 private
	    Bookshelf[][] schemaMatrice = new Bookshelf[rows][columns];
	
	public Bookshelf() // Bookshelf constructor, initializing private rows and columns
	{
		for (int i = 0; i < rows; ++i)
			for (int j = 0; j < columns; ++j)
				schemaMatrice[i][j] = new Bookshelf();
	}
	
	private int getColumns(){
		int colSel;
		do {
		Scanner sc = new Scanner(System.in);
		System.out.println("In che colonna vuoi inserire le carte? (compreso tra 1 e 6)");
		colSel=sc.nextInt();// per colSel s'intende la colonna selezionata dal giocatore
		
		if(colSel<1 && colSel>6) {
			System.out.println("Colonna inesistente, seleziona una colonna giusta");
		}
		}while(colSel<1 && colSel>6);
		
		
		
	
	}

}
