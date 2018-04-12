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

	public Cellar(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		p.incrementActions(1);
		String cardName = "poupipoupipoupidou";
		while(!cardName.equals("")) {
			cardName = p.chooseCard("Choississez une carte a defausser", p.cardsInHand(), true);
			try{
				if(!cardName.equals("")) {
					p.gain(p.getHand().remove(cardName));
					p.drawCard_AndAddInHand();
				}
			} catch (Exception e) {
				System.out.println("Error : card = " + cardName);
			}
		}
	}
}