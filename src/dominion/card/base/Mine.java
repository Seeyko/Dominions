package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Mine
 * 
 * Écartez une carte Trésor de votre main. Recevez une carte Trésor coûtant jusqu'à 3 Pièces de plus ; ajoutez cette carte à votre main.
 */
public class Mine extends ActionCard {

	public Mine(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		for(Card carteTresor : p.getHand()) {
			if(carteTresor instanceof TreasureCard) {
				p.getDiscard().add(carteTresor);
				p.getHand().add(p.getGame().getCardsByCost(carteTresor.getCost()+3).get(0));
			}
		}
	}
}