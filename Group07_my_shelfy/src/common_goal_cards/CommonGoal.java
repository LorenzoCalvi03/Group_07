package common_goal_cards;

import java.util.Random;

public class CommonGoal {
	private TypeCG type;

	public CommonGoal(TypeCG t) {
		type = t;
	}

	public CommonGoal() {
		type = null;
	}

	public CommonGoal(CommonGoal cg) {
		this.type = cg.type;
	}

	/**
	 * Set type with Type enum
	 * 
	 * @param type
	 */
	public void setType(TypeCG t) {
		this.type = t;
	}

	/**
	 * Get Type (enum Type)
	 * 
	 * @return Type
	 */
	public TypeCG getType() {
		return this.type;
	}

	public String toString() {
		if (this.type != null) {
			return this.type.toString();
		} else {
			return "Null";
		}

	}

}
