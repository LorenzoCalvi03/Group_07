package my_shelfie;

import java.util.*;
import components.Bookshelf;
import components.Board;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Board board = new Board();
		System.out.println("Quanti giocatori siete?: ");
		int NumPlayer = sc.nextInt();
		GameMaster.g.set_players(NumPlayer);
		sc.nextLine();
		board.fill();

		for (int i = 0; i < GameMaster.g.cols; ++i) {
			for (int j = 0; j < GameMaster.g.rows; ++j) {
				if(board.getTile(i, j) != null) {
					System.out.print(board.getTile(i, j).toString()+"\t");
				}
				else {
					System.out.print("");
				}
			}
			System.out.println(" ");
		}
		
		System.out.println("Immettere nomi utente: ");
		Player player1 =new Player(sc.nextLine());
		Player player2 =new Player(sc.nextLine());
		if (NumPlayer == 3) {
		    Player player3 = new Player(sc.nextLine());
		}else if (NumPlayer == 4) {
		    Player player3 = new Player(sc.nextLine());
		    Player player4 = new Player(sc.nextLine());
		}
		System.out.println("Primo turno: ");
		System.out.println();
	}
}


