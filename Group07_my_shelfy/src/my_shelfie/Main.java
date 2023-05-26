package my_shelfie;

import java.util.*;
import components.Bookshelf;
import components.Board;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Board board = new Board();
		int numPlayer;
		do {
			System.out.println("Quanti giocatori siete?: ");
			 numPlayer = sc.nextInt();
			 if(numPlayer<2 || numPlayer>4) {
				 System.out.println("Inserimento errato: minimo 2 giocatori, massimo 4 giocatori");
			 }
		}
		while(numPlayer<2 || numPlayer>4);
		GameMaster.g.set_players(numPlayer);
		sc.nextLine();
		board.fill();
		board.printBoard();
		
		System.out.println("Immettere nome utente1: ");
		Player player1 =new Player(sc.nextLine());
		System.out.println("Immettere nome utente2: ");
		Player player2 =new Player(sc.nextLine());
		if (numPlayer == 3) {
			System.out.println("Immettere nome utente3: ");
		    Player player3 = new Player(sc.nextLine());
		}else if (numPlayer == 4) {
			System.out.println("Immettere nome utente3: ");
		    Player player3 = new Player(sc.nextLine());
		    System.out.println("Immettere nome utente4: ");
		    Player player4 = new Player(sc.nextLine());
		}
		System.out.println("Primo turno: ");
	}
}


