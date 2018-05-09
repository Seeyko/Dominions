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
		super("Mine", 5);
	}
	
	public Mine(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		Card carteTresor;
		String carteGagner = "";
		int random;
		CardList curList = new CardList();
		CardList cartesAChoisir = new CardList();
		for(int i = 0; i < p.getHand().size(); i++) {
			carteTresor = p.getHand().get(i);
			if(carteTresor.getTypes().contains(CardType.Treasure)) {
				p.getGame().getTrash().add(p.getHand().remove(carteTresor.getName()));
				for (int h = carteTresor.getCost(); h < carteTresor.getCost() + 3; h++) {
					curList = p.getGame().getCardsByCost(h);
					cartesAChoisir.addAll(curList);
				}
				
				carteGagner = p.chooseCard("Choose a card (ENTER TO PASS)", cartesAChoisir, true);
				p.gain(p.getGame().removeFromSupply(carteGagner));;
				p.getGame().pause(1000, "Vous avez recu " + carteGagner);			}
		}
	}
}