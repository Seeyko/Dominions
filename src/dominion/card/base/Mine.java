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
		Card carteTresor;
		int random;
		CardList curList = new CardList();
		CardList cartesAChoisir = new CardList();
		for(int i = 0; i < p.getHand().size(); i++) {
			carteTresor = p.getHand().get(i);
			if(carteTresor instanceof TreasureCard) {
				p.getDiscard().add(p.getHand().remove(carteTresor.getName()));
				for (int h = 0 ; h < 5; h++) {
					curList = p.getGame().getCardsByCost(h);
					cartesAChoisir.addAll(curList);
					
				}
				//On choisit une carte au hasard parmit @carteAChoisir
				random = (int) (Math.random() * (cartesAChoisir.size() -1));
				p.getHand().add(cartesAChoisir.get(random));
			}
		}
	}
}