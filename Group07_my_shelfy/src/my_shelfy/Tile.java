package my_shelfy;

public class Tile {
		private Type type;
		
		public Tile() {
			type = null;
		}
		
		public Tile(Tile t) {
			this.type= t.type;
		}
		
		/** Set type with Type enum
		 * 
		 * @param type
		 */
		public void setType(Type t) {
			this.type = t;
		}
		
		/**Get Type (enum Type)
		 * 
		 * @return Type
		 */
		public Type getType() {
			return this.type;
		}
		@Override
		public String toString() {
			return (this.type).toString();
		}
		
}