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
		super("ThroneRoom", 4);
	}
	
	public ThroneRoom(String name, int cost) {
		super(name, cost);
	}

	@Override
	public void play(Player p) {
		String cardName = p.chooseCard("Choisissez une carte action de votre main", p.getActionCards(), true);		
		p.playCard(cardName);
		p.playCard(cardName);
	}
}