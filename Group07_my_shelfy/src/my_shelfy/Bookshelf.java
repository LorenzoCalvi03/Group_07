package my_shelfy;

public class Bookshelf {
	private int rows=6;
	private int columns=5;
	 private
	    Bookshelf[][] schema_matrice = new Bookshelf[rows][columns];
	
	public Bookshelf() // Bookshelf constructor, initializing private rows and columns
	{
		for (int i = 0; i < rows; ++i)
			for (int j = 0; j < columns; ++j)
				schema_matrice[i][j] = new Bookshelf();
	}
	
	private void 

}
