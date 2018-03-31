package dominion.card.common;
import dominion.*;
import dominion.card.*;

/**
 * Carte Argent (Silver)
 * 
 * 2 Pièces
 */
public class Silver extends TreasureCard {
	public Silver() { super("Silver",2);	}
	
	public int treasureValue() {
		return 0;
	}

	@Override
	public void play(Player p) {
		p.incrementMoney(2);		
	}
}
