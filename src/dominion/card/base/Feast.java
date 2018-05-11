package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Festin (Feast)
 * 
 * Ecartez cette carte.
 * Choisissez une carte coutant jusqu'à 5 Pieces.
 */
public class Feast extends ActionCard {

	public Feast() {
		super("Feast", 4);
	}
	
	public Feast(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		// TODO Auto-generated method stub
		CardList curList = new CardList();
		CardList cartesAChoisir = new CardList();
				
		String carteGagner = "";
		
		p.getGame().getTrash().add(p.getInPlay().remove(this.getName()));
		
		for (int i = 1 ; i < 6; i++) {
			curList = p.getGame().getCardsByCost(i);
			cartesAChoisir.addAll(curList);
		}
		
		carteGagner = p.chooseCard("Choose a card (ENTER TO PASS)", cartesAChoisir, true);
		p.gain(p.getGame().removeFromSupply(carteGagner));
		p.getGame().pause(1000, "You received a " + carteGagner);	
		
	}
}