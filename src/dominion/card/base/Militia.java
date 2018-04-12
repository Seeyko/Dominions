package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Milice (Militia)
 * 
 * 2 Pièces.
 * Tous vos adversaires défaussent leurs cartes de façon à n'avoir que 3 cartes en main.
 */
public class Militia extends AttackCard {

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
					adversaire.gain(adversaire.getHand().remove(0));
				}
			}
		}
		
	}
}