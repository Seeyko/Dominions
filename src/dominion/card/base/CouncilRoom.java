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

	public CouncilRoom(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		for(int i = 0; i < 4; i++) {
			if(i == 0) {
				p.incrementBuys(1);
				for(int j = 0; j < p.otherPlayers().size(); j++) {
					p.otherPlayers().get(i).drawCard();
				}
			}
			p.drawCard();
		}
	}
}