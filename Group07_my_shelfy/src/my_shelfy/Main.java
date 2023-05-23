package My_shelfie;
import java.util.*;
public class Main {
<<<<<<< Updated upstream
=======
	public static void main() {
		StartingInterface i = new StartingInterface();
		
	}
>>>>>>> Stashed changes

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Board board = new Board();
		
		System.out.println("Quanti giocatori siete?: ");
		Game_Master.g.set_players(sc.nextInt());
		
		board.fill();
		
		for (int i = 0; i < Game_Master.g.cols; ++i)
		{	
			for (int j = 0; j < Game_Master.g.rows; ++j)
			{
				System.out.print(board.get_tile(i, j).get_object().get_type() + "\t");
			}
			System.out.println();
		}
		sc.close();
	}
}
