package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Renovation (Remodel)
 * 
 * Eartez une carte de votre main.
 * Recevez une carte coûtant jusqu'a� 2 Pieces de plus que la carte ecartee.
 */
public class Remodel extends ActionCard {

	public Remodel() {
		super("Remodel", 4);
	}
	
	public Remodel(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		CardList curList = new CardList();
		CardList cartesAChoisir = new CardList();
		String carteGagne;
		int randomChoisir;
		if(p.getHand().size() > 0){
			
			Card carteEcarte = p.getHand().remove(p.chooseCard("Choose a card to put in your discard", p.getHand(), false));
			int cost = carteEcarte.getCost();
			
			for (int h = 0 ; h < cost+3; h++) {
				curList = p.getGame().getCardsByCost(h);
				cartesAChoisir.addAll(curList);
			
			}
			//On choisit une carte au hasard parmit ecarteAChoisir
			p.getGame().pause(1000, "Search for card with a cost of 4", ".", ".", ".");
			
			carteGagne = p.chooseCard("Choose a card (ENTER TO PASS)", cartesAChoisir, true);
			p.gain(p.getGame().removeFromSupply(carteGagne));;
			
			p.getGame().pause(1000, "You received " + carteGagne);
		}else p.getGame().pause(1000, "Your hand is empty we can't do anything.");
						
	}
}