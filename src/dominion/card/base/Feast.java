package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Festin (Feast)
 * 
 * Ecartez cette carte.
 * Choisissez une carte coutant jusqu'a  5 Pieces.
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
				
		p.getGame().getTrash().add(p.getInPlay().remove(this.getName()));
		
		
		for (int i = 0 ; i < 5; i++) {
			curList = p.getGame().getCardsByCost(i);
			cartesAChoisir.addAll(curList);
		}
		
		p.gain(p.chooseCard("Choisissez une carte parmis celles-ci : ", cartesAChoisir, true));
	}
}