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

	public Workshop() {
		super("WorkShop", 3);
	}
	
	public Workshop(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		CardList curList = new CardList();
		CardList cartesAChoisir = new CardList();
		String carteGagner;
		for (int i = 0 ; i < 4; i++) {
			curList = p.getGame().getCardsByCost(i);
			cartesAChoisir.addAll(curList);
		}
		
		p.getGame().pause(1000, "Search for card with a cost of 4", ".", ".", ".");
		
		carteGagner = p.chooseCard("Choose a card (ENTER TO PASS)", cartesAChoisir, true);
		p.gain(p.getGame().removeFromSupply(carteGagner));;
		
		p.getGame().pause(1000, "You received " + carteGagner);
	}
}