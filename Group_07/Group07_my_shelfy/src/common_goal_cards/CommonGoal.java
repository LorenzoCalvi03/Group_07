package common_goal_cards;

import java.util.Random;



/**
 *Costruttore che imposta il tipo della carta Common Goal.
 * t è il tipo della carta Common Goal
 */
public class CommonGoal {
	private TypeCG type;

	public CommonGoal(TypeCG t) {
		type = t;
	}

	
	/**
	 * Costruttore di default che crea una carta Common Goal senza tipo.
	 */
	public CommonGoal() {
		type = null;
	}

	
	/**
	 *Costruttore che crea una nuova carta Common Goal
	 *con lo stesso tipo di un'altra carta.
	 *cg è la carta Common Goal da copiare
	 */
	public CommonGoal(CommonGoal cg) {
		this.type = cg.type;
	}

	/**
	 *Imposta il tipo della carta Common Goal.
	 *t è il tipo della carta Common Goal
	 */
	public void setType(TypeCG t) {
		this.type = t;
	}

	/**
	 * Restituisce il tipo della carta Common Goal.
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
