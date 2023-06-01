package common_goal_cards;

import java.util.ArrayList;
import java.util.Random;

public class PilaCommonGoals {

	public static ArrayList<CommonGoal> pila = new ArrayList<CommonGoal>();
	public static int MAX_CARDS = 12;

	
	/**
	 * Costruttore della classe PilaCommonGoals.
	 * Inizializza la pila con tutte le carte Common Goal disponibili.
	 */
	public PilaCommonGoals() {
		pila.add(new CommonGoal(TypeCG.A));
		pila.add(new CommonGoal(TypeCG.B));
		pila.add(new CommonGoal(TypeCG.C));
		pila.add(new CommonGoal(TypeCG.D));
		pila.add(new CommonGoal(TypeCG.E));
		pila.add(new CommonGoal(TypeCG.F));
		pila.add(new CommonGoal(TypeCG.G));
		pila.add(new CommonGoal(TypeCG.H));
		pila.add(new CommonGoal(TypeCG.I));
		pila.add(new CommonGoal(TypeCG.L));
		pila.add(new CommonGoal(TypeCG.M));
		pila.add(new CommonGoal(TypeCG.N));
	}

	
	/**
	 * Pesca una carta dalla pila in modo casuale.
	 * restituisce la carta Common Goal pescata
	 */
	public static CommonGoal pescaCarta() {
		Random r = new Random();
		int position = r.nextInt(pila.size());
		CommonGoal cg = new CommonGoal(pila.get(position));
		pila.remove(position);
		return cg;
	}
}
