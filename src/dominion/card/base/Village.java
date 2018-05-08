package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Village
 * 
 * +1 Carte.
 * +2 Actions.
 */
public class Village extends ActionCard {

	public Village() {
		super("Village", 3);
		// TODO Auto-generated constructor stub
	}
	
	public Village(String name, int cost) {
		super(name, cost);
	}
	
	@Override
	public void play(Player p) {
		p.drawCard_AndAddInHand();
		p.incrementActions(2);
	}
}