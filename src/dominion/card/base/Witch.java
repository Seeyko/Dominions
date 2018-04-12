package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Sorcière (Witch)
 * 
 * +2 Cartes.
 * Tous vos adversaires recoivent une carte Curse.
 */
public class Witch extends AttackCard {

	public Witch(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		p.drawCard_AndAddInHand();
		p.drawCard_AndAddInHand();
		for(Player adversaire: p.otherPlayers()) {
			if(!PlayerHasMoatInHand(adversaire)){
				adversaire.gain("Curse");
			}
		}
	}
}