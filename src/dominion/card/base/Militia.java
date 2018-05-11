package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Milice (Militia)
 * 
 * 2 Pieces.
 * Tous vos adversaires defaussent leurs cartes de fa�on a n'avoir que 3 cartes en main.
 */
public class Militia extends AttackCard {

	public Militia() {
		super("Militia", 4);
	}
	
	public Militia(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		p.incrementMoney(2);
		Player adversaire;
		for(int i = 0; i < p.otherPlayers().size(); i++) {
			adversaire  = p.otherPlayers().get(i);
			if(!PlayerHasMoatInHand(adversaire)){
				while(adversaire.getHand().size() > 3) {
					
					p.getGame().pause(500, adversaire.getName() + " is discarding a card", ".", ".");
					adversaire.gain(adversaire.getHand().remove(0));
				}
			}
		}
		
	}
}