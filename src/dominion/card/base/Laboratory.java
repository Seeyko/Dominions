package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Laboratoire (Laboratory)
 * 
 * +2 Cartes.
 * +1 Action.
 */
public class Laboratory extends ActionCard {

	public Laboratory() {
		super("Laboratory", 5);
	}
	
	public Laboratory(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		p.drawCard_AndAddInHand();
		p.drawCard_AndAddInHand();
		p.incrementActions(1);
	}
}