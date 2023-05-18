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
		public String toString(){
			if(this.type != null) {
				return this.type.toString();
				}
			else 
			{
				return "Null";
			}
			
		}
		
}