package tile;
/** Questo enumerativo offre i 6 tipi di tessera
 * 
 * @author Filippo Bonfanti
 *
 */
public enum Type {	//enumerativo per i 6 tipi di tessera oggetto
	
	PINK,
	BLUE,
	WHITE,
	AZURE,
	GREEN,
	ORANGE;
	
	@Override
	public String toString() {
		switch (this) {
		case PINK:
			return "PINK";
		
		case BLUE:
			return "BLUE";
			
		case WHITE:
			return "WHITE";
		
		case AZURE:
			return "AZURE";
		
		case GREEN:
			return "GREEN";
		
		case ORANGE:
			return "ORANGE";
		
		default:
			return null;
		}
	}
	
}

