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
		Card carteGagne;
		int randomChoisir;
		if(p.getHand().size() > 0){
			int randomEcartement = (int) (Math.random() * (p.getHand().size()-1));
		
			Card carteEcarte = p.getHand().remove(randomEcartement);
			int cost = carteEcarte.getCost();
			
			for (int h = cost ; h < cost+2; h++) {
				curList = p.getGame().getCardsByCost(h);
				cartesAChoisir.addAll(curList);
			
			}
			//On choisit une carte au hasard parmit @carteAChoisir
			randomChoisir = (int) (Math.random() * (cartesAChoisir.size() -1));
			carteGagne = cartesAChoisir.get(randomChoisir);
			p.getHand().add(carteGagne);
			p.getGame().removeFromSupply(carteGagne.getName());
			System.out.println("Vous avez recu " + carteGagne.getName());
		}else System.out.println("Votre main est vide on ne peut rien faire.");
						
	}
}