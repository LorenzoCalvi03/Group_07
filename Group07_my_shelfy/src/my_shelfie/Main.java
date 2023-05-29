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
		System.out.println("Common goal 1: "+ GameMaster.g.commongoal1.toString());
		System.out.println("Common goal 2: "+ GameMaster.g.commongoal2.toString());
      	List<Player> players = new ArrayList<Player>();

	    for (int i = 1; i <= numPlayer; i++) {
	        System.out.println("Immettere nome utente" + i + ": ");
	        Player player = new Player(sc.nextLine());
	        players.add(player);
	    }
	    
	    // Genera l'ordine casuale dei giocatori
	    Collections.shuffle(players);

	    System.out.println("Ordine casuale dei giocatori: ");
	    for (int i = 0; i < players.size(); i++) {
	        System.out.println("Giocatore " + (i + 1) + ": " + players.get(i).getUsername());
	    }
	    
	    System.out.println("Il primo giocatore pesca");
	    for (int i = 0; i < players.size(); i++) {
	        System.out.println("Giocatore " + (i + 1) + " pesca: ");
	        players.get(i).pescaCarte();
	    }

	}

}


