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

	public Mine() {
		super("Mine", 4);
	}
	
	public Mine(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		Card carteTresor;
		String carteTresorName;
		String carteGagner = "";
		CardList curList = new CardList();
		CardList cartesAChoisir = new CardList();
		
		carteTresorName = p.chooseCard("Choose a Treasure card to remove from your hand", p.getTreasureCards(), false);
		
		carteTresor = p.getHand().remove(carteTresorName);
		
		p.getGame().getTrash().add(carteTresor);
			
		for (int h = 0; h < carteTresor.getCost() + 4; h++) {
			curList = p.getGame().getCardsByCostAndTypes(h, CardType.Treasure);
			cartesAChoisir.addAll(curList);	
		}
				
		p.getGame().pause(1000, "Search for card with a cost of " + carteTresor.getCost() + " maximum", ".", ".", ".");	
		
		carteGagner = p.chooseCard("Choose a card (ENTER TO PASS)", cartesAChoisir, true);
			
		p.getHand().add(p.getGame().removeFromSupply(carteGagner));
			
		p.getGame().pause(1000, "You received " + carteGagner);
				
	}
}
