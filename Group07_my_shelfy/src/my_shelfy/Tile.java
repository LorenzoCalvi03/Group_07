package my_shelfy;

public class Tile {
		private Type type;
		
		public Tile() {
			type = null;
		}
		
		public Tile(Tile t) {
			this.type= t.type;
		}
		
		public void setType(Type t) {
			this.type = t;
		}
		
		public Type getType() {
			return this.type;
		}
		@Override
		public String toString() {
			return (this.type).toString();
		}
		
}