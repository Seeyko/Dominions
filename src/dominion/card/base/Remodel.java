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
		CardList curList = new CardList();
		CardList cartesAChoisir = new CardList();
		
		int randomChoisir;
		int randomEcartement = (int) (Math.random() * (p.getHand().size()-1));
		Card carteEcarte = p.getHand().remove(randomEcartement);
		int cost = carteEcarte.getCost();
		
		for (int h = 0 ; h < cost; h++) {
			curList = p.getGame().getCardsByCost(h);
			cartesAChoisir.addAll(curList);
			
		}
		//On choisit une carte au hasard parmit @carteAChoisir
		randomChoisir = (int) (Math.random() * (cartesAChoisir.size() -1));
		p.getHand().add(cartesAChoisir.get(randomChoisir));
			
				
	}
}