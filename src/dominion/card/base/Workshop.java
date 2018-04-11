package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Atelier (Workshop)
 * 
 * Recevez une carte coûtant jusqu'à 4 Pièces.
 */
public class Workshop extends ActionCard {

	public Workshop(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		CardList curList = new CardList();
		CardList cartesAChoisir = new CardList();
		for (int i = 0 ; i < 4; i++) {
			curList = p.getGame().getCardsByCost(i);
			cartesAChoisir.addAll(curList);
			
		}
		int randomChoisir = (int) (Math.random() * (cartesAChoisir.size() -1));
		p.getHand().add(cartesAChoisir.get(randomChoisir));
		
	}
}