package my_shelfy;

import java.util.ArrayList;
import java.util.Random;

public class Sacchetto {
	public static ArrayList<Tile> sacchetto = new ArrayList<Tile>();
	public static int MAX_TILES = 22;

	public Sacchetto() {
		for (int i = 0; i < MAX_TILES; i++) {
			Tile t = new Tile();
			t.setType(Type.BOOK);
			sacchetto.add(t);
		}
		for (int i = 0; i < MAX_TILES; i++) {
			Tile t = new Tile();
			t.setType(Type.CAT);
			sacchetto.add(t);
		}
		for (int i = 0; i < MAX_TILES; i++) {
			Tile t = new Tile();
			t.setType(Type.FRAME);
			sacchetto.add(t);
		}
		for (int i = 0; i < MAX_TILES; i++) {
			Tile t = new Tile();
			t.setType(Type.GAME);
			sacchetto.add(t);
		}
		for (int i = 0; i < MAX_TILES; i++) {
			Tile t = new Tile();
			t.setType(Type.PLANT);
			sacchetto.add(t);
		}
		for (int i = 0; i < MAX_TILES; i++) {
			Tile t = new Tile();
			t.setType(Type.TROPHIE);
			sacchetto.add(t);
		}
	}

	public static Tile pescaTessera() {
		Random r = new Random();
		int position = 10;
		Tile t = new Tile(sacchetto.get(position));
		sacchetto.remove(position);
		return t;
	}

}
