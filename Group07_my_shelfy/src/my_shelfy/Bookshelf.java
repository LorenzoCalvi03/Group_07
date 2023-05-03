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
	
	private int get_columns(){
		do {
		Scanner sc = new Scanner(System.in);
		System.out.println("In che colonna vuoi inserire le carte? (compreso tra 1 e 6)");
		int col_sel=sc.nextInt();// per col_sel s'intende la colonna selezionata dal giocatore
		
		if(col_sel<1 && col_sel>6) {
			System.out.println("Colonna inesistente, seleziona una colonna giusta");
		}
		}while(col_sel>1 && col_sel<6)
		
	}

}
