package my_shelfie;

import java.util.*;
import components.Bookshelf;
import components.Board;
import common_goal_cards.CommonGoal;
import common_goal_cards.TypeCG;

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
		CommonGoal goal1 = player1.getCommonGoal1();
		System.out.println("Common Goal 1 per " + player1.getUsername() + ": " + goal1);
		CommonGoal goal2 = player1.getCommonGoal2();
		System.out.println("Common Goal 2 per " + player1.getUsername() + ": " + goal2);// Genera le due common goal per ogni giocatore
		
		System.out.println("Immettere nome utente2: ");
		Player player2 =new Player(sc.nextLine());
		CommonGoal goal3 = player2.getCommonGoal1();
		System.out.println("Common Goal 1 per " + player2.getUsername() + ": " + goal3);
		CommonGoal goal4 = player2.getCommonGoal2();
		System.out.println("Common Goal 2 per " + player2.getUsername() + ": " + goal4);
		
		if (numPlayer == 3) {
		    Player player3 = new Player(sc.nextLine());
		    CommonGoal goal5 = player3.getCommonGoal1();
			System.out.println("Common Goal 1 per " + player3.getUsername() + ": " + goal5);
			CommonGoal goal6 = player3.getCommonGoal2();
			System.out.println("Common Goal 2 per " + player3.getUsername() + ": " + goal6);
		}else if (numPlayer == 4) {
		    Player player3 = new Player(sc.nextLine());
		    CommonGoal goal5 = player3.getCommonGoal1();
			System.out.println("Common Goal 1 per " + player3.getUsername() + ": " + goal5);
			CommonGoal goal6 = player3.getCommonGoal2();
			System.out.println("Common Goal 2 per " + player3.getUsername() + ": " + goal6);
		    Player player4 = new Player(sc.nextLine());
		    CommonGoal goal7 = player4.getCommonGoal1();
			System.out.println("Common Goal 1 per " + player4.getUsername() + ": " + goal7);
			CommonGoal goal8 = player4.getCommonGoal2();
			System.out.println("Common Goal 2 per " + player4.getUsername() + ": " + goal8);
		}

		System.out.println("Primo turno: ");

	}
}


