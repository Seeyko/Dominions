package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Renovation (Remodel)
 * 
 * Eartez une carte de votre main.
 * Recevez une carte coÃ»tant jusqu'a  2 Pieces de plus que la carte ecartee.
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
		Card carteGagne;
		int randomChoisir;
		if(p.getHand().size() > 0){
			
			Card carteEcarte = p.getHand().remove(p.chooseCard("Choisissez une carte a ecarter", p.getHand(), false));
			int cost = carteEcarte.getCost();
			
			for (int h = cost ; h < cost+2; h++) {
				curList = p.getGame().getCardsByCost(h);
				cartesAChoisir.addAll(curList);
			
			}
			//On choisit une carte au hasard parmit ecarteAChoisir
			randomChoisir = (int) (Math.random() * (cartesAChoisir.size() -1));
			carteGagne = cartesAChoisir.get(randomChoisir);
			p.getHand().add(carteGagne);
			p.getGame().removeFromSupply(carteGagne.getName());
			
			p.getGame().pause(1000, "Vous avez recu " + carteGagne.getName());
		}else p.getGame().pause(1000, "Votre main est vide on ne peut rien faire.");
						
	}
}