package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Chapelle (Chapel)
 * 
 * Écartez jusqu'à 4 cartes de votre main.
 */
public class Chapel extends ActionCard {

	public Chapel() {
		super("Chapel", 2);
	}
	
	public Chapel(String name, int cost) {
		super(name, cost);
	}
	
	@Override
	public void play(Player p) {
		String cardName = "poupipoupipoupidou";
		int nbCarteAJetez = 0;
		while(!cardName.equalsIgnoreCase("") && nbCarteAJetez < 4 && p.getHand().size() > 0) {
			cardName = p.chooseCard((4 - nbCarteAJetez) + " card to discard.\n>>>Choose a card to discard (ENTER TO PASS)", p.cardsInHand(), true);
				
				p.getGame().pause(1000, "Discarding the card");
				
				//Ecartement de la carte
				p.getGame().getTrash().add(p.getHand().remove(cardName));
				nbCarteAJetez++;

				p.getGame().pause(1000, "Card " + cardName + " discard");				
			
		}
	}
}