package my_shelfy;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Board board = new Board();
		System.out.println("Quanti giocatori siete?: ");
		GameMaster.g.set_players(sc.nextInt());
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
		sc.close();
	}
}
