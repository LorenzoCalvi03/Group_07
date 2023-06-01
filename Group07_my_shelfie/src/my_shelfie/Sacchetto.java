package my_shelfie;

import java.util.ArrayList;
import java.util.Random;

import tile.Tile;
import tile.Type;

/**
 * La classe Sacchetto rappresenta il sacchetto di tessere del gioco. Contiene
 * una lista di tessere disponibili per essere pescate durante il gioco.
 */
public class Sacchetto {
	/**
	 * La lista di tessere nel sacchetto.
	 */

	public static ArrayList<Tile> sacchetto = new ArrayList<Tile>();
	/**
	 * Il numero massimo di tessere nel sacchetto.
	 */
	public static int MAX_TILES = 22;

	/**
	 * Costruttore della classe Sacchetto. Crea e aggiunge le tessere di diversi
	 * tipi al sacchetto.
	 */
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

	/**
	 * Pesca una tessera casualmente dal sacchetto. La tessera pescata viene rimossa
	 * dal sacchetto.
	 * 
	 * @return La tessera pescata.
	 */
	public static Tile pescaTessera() {
		Random r = new Random();
		int position = r.nextInt(sacchetto.size());
		Tile t = new Tile(sacchetto.get(position));
		sacchetto.remove(position);
		return t;
	}

}
