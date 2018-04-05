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

	public Chapel(String name, int cost) {
		super(name, cost);
	}
	
	@Override
	public void play(Player p) {
		String cardName = "poupipoupipoupidou";
		int nbCarteAJetez = 0;
		while(cardName != "" && nbCarteAJetez < 4) {
			cardName = p.chooseCard("Il vous reste " + (4 - nbCarteAJetez) + " carte a d�fausser.\nChoississez une carte a d�fausser", p.cardsInHand(), true);
			try{
				p.getGame().getTrash().add(p.getHand().remove(cardName));
				nbCarteAJetez++;
			} catch (Exception e) {
				System.out.println(p.getHand().getCard(cardName));
			}
		}
	}
}