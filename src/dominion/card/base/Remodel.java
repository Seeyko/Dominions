package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Rénovation (Remodel)
 * 
 * Écartez une carte de votre main.
 * Recevez une carte coûtant jusqu'à 2 Pièces de plus que la carte écartée.
 */
public class Remodel extends ActionCard {

	public Remodel(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		for(Card carteEcarte : p.getHand()) {
			if(carteEcarte instanceof TreasureCard) {
				p.getDiscard().add(carteEcarte);
				p.getDiscard().add(p.getGame().getCardsByCost(carteEcarte.getCost()+2).get(0));
			}
		}		
	}
}