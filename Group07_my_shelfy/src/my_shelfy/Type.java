package my_shelfy;

public enum Type {
	
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

