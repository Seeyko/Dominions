package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Salle du trône (Throne Room)
 * 
 * Choisissez 1 carte Action de votre main.
 * Jouez-la deux fois.
 */
public class ThroneRoom extends ActionCard {

	public ThroneRoom() {
		super("Throne Room", 4);
	}
	
	public ThroneRoom(String name, int cost) {
		super(name, cost);
	}

	@Override
	public void play(Player p) {
		String cardName = p.chooseCard("Choose an action card to play : (ENTER TO PASS)", p.getActionCards(), true);		
		
		if(!cardName.equals("")) {
			p.playCard(cardName);
		
			//On recupere la carte joué.
			p.getHand().add(p.getInPlay().remove(cardName));
			p.playCard(cardName);
		}
	}
}