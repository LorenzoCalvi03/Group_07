package my_shelfy;

import java.util.ArrayList;
import java.util.Random;

public class Sacchetto {
	public static ArrayList<Tile> sacchetto = new ArrayList<Tile>();
	public static int MAX_TILES = 22;

	public Sacchetto() {
		for (int i = 0; i < MAX_TILES; i++) {
			Tile t = new Tile();
			t.setType(Type.PINK);
			sacchetto.add(t);
		}
		for (int i = 0; i < MAX_TILES; i++) {
			Tile t = new Tile();
			t.setType(Type.BLUE);
			sacchetto.add(t);
		}
		for (int i = 0; i < MAX_TILES; i++) {
			Tile t = new Tile();
			t.setType(Type.GREEN);
			sacchetto.add(t);
		}
		for (int i = 0; i < MAX_TILES; i++) {
			Tile t = new Tile();
			t.setType(Type.WHITE);
			sacchetto.add(t);
		}
		for (int i = 0; i < MAX_TILES; i++) {
			Tile t = new Tile();
			t.setType(Type.AZURE);
			sacchetto.add(t);
		}
		for (int i = 0; i < MAX_TILES; i++) {
			Tile t = new Tile();
			t.setType(Type.ORANGE);
			sacchetto.add(t);
		}
	}

	public static Tile pescaTessera() {
		Random r = new Random();
		int position = r.nextInt(sacchetto.size());
		Tile t = new Tile(sacchetto.get(position));
		sacchetto.remove(position);
		return t;
		//sacchetto.
	}

}
