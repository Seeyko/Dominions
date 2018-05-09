package dominion.card.base;
import java.util.*;

import javax.print.attribute.standard.MediaSize.Other;

import dominion.*;
import dominion.card.*;

/**
 * Carte Chambre du conseil (Council Room)
 * 
 * +4 Cartes.
 * +1 Achat.
 * Tous vos adversaires piochent 1 carte.
 */
public class CouncilRoom extends ActionCard {

	public CouncilRoom() {
		super("Council Room", 5);
	}
	
	public CouncilRoom(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		for(int i = 0; i < 4; i++) {
			p.drawCard_AndAddInHand();
		}
		p.incrementBuys(1);

		for(Player adv: p.otherPlayers()) {
			p.getGame().pause(500, adv + " pioche une carte...");
			adv.drawCard_AndAddInHand();
		}
	}
	
}