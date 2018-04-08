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
			for(int j = 0 ; j < curList.size(); j++) {
				cartesAChoisir.add(curList.get(j));
			}
		}
		p.gain(p.chooseCard("Choisissez une carte parmis celles-ci : ", cartesAChoisir, false));
	}
}