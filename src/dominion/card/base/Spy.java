package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Espion (Spy)
 * 
 * +1 Carte.
 * +1 Action.
 * Tous les joueurs (vous aussi) dévoilent la première carte de leur deck. 
 * Vous décidez ensuite si chaque carte dévoilée est défaussée ou replacée sur son deck.
 */
public class Spy extends AttackCard {

	public Spy() {
		super("Spy", 4);
	}
	
	public Spy(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		p.drawCard_AndAddInHand();
		p.incrementActions(1);
		
		int random;
		Player adversaire;
		Card carteRetirer;
		String def_dev;
		
		for(int i = 0; i < p.getGame().numberOfPlayers(); i++) {
			adversaire = p.getGame().getPlayer(i);
			carteRetirer = adversaire.drawCard();
			if(carteRetirer != null) {
				if(!PlayerHasMoatInHand(adversaire)){
					p.getGame().pause(1000, "Player : " + adversaire.getName() + " has the card : " + carteRetirer.getName());
					def_dev = p.choose("Discard (y) or put this card on the deck (n)?", new ArrayList<String>(Arrays.asList("y", "n")), false);
				
					if(def_dev .equalsIgnoreCase("y")) {
						p.getGame().pause(500,"Discarding the card");
						adversaire.gain(carteRetirer);
					}else if(def_dev.equalsIgnoreCase("n")) {
						p.getGame().pause(500,"Putting the card on the deck");
						adversaire.getDraw().add(carteRetirer);
					}
				}
			}
		}
	}
}