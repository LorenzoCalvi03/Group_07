package tile;

/**
 * La classe Tile rappresenta una tessera del gioco. Ogni tessera ha un tipo
 * definito dall'enumerazione Type. Fornisce metodi per impostare e ottenere il
 * tipo della tessera.
 */
public class Tile {
	private Type type;

	/**
	 * Costruttore di default della classe Tile. Inizializza il tipo della tessera a
	 * null.
	 */
	public Tile() {
		type = null;
	}

	/**
	 * Costruttore di copia della classe Tile. Crea una nuova tessera con lo stesso
	 * tipo di un'altra tessera specificata.
	 * 
	 * @param t La tessera da cui copiare il tipo.
	 */
	public Tile(Tile t) {
		this.type = t.type;
	}

	/**
	 * Imposta il tipo della tessera con il tipo specificato.
	 * 
	 * @param t Il tipo da impostare.
	 */
	public void setType(Type t) {
		this.type = t;
	}

	/**
	 * Restituisce il tipo della tessera.
	 * 
	 * @return Il tipo della tessera.
	 */
	public Type getType() {
		return this.type;
	}

	/**
	 * Restituisce una rappresentazione testuale della tessera. Se il tipo non è
	 * impostato, restituisce "-".
	 * 
	 * @return Stringa che rappresenta la tessera.
	 */
	public String toString() {
		if (this.type != null) {
			return this.type.toString();
		} else {
			return " -";
		}

	}

}