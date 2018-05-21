package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Cave (Cellar)
 * 
 * +1 Action.
 * Défaussez autant de cartes que vous voulez.
 * +1 Carte par carte défaussée.
 */
public class Cellar extends ActionCard {

	public Cellar() {
		super("Cellar", 2);
	}
	
	public Cellar(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		p.incrementActions(1);
		//nom random pour permettre de rentrer dans la boucle
		String cardName = "poupipoupipoupidou";
		int cpt = 0;
		while(!cardName.equals("")) {
			cardName = p.chooseCard("Discard a card (ENTER TO FINISH) ", p.cardsInHand(), true);
				if(!cardName.equals("")) {
					
					p.getGame().pause(500, "Discarding card", ".", ".", ".");
					
					p.gain(p.getHand().remove(cardName));
					cpt++;
				}
		}
		while(cpt > 0) {
			p.drawCard_AndAddInHand();
			cpt--;
		}
	}
}