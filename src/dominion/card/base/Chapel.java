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
			cardName = p.chooseCard("Il vous reste " + (4 - nbCarteAJetez) + " carte a defausser.\n>>>Choississez une carte a defausser (ENTRER POUR PASSER)", p.cardsInHand(), true);
			try{
				
				p.getGame().pause(1000, "Ecartement de la carte ");
				
				//Ecartement de la carte
				p.getGame().getTrash().add(p.getHand().remove(cardName));
				nbCarteAJetez++;

				p.getGame().pause(1000, "Carte " + cardName + " ecarter");				
			} catch (Exception e) {
				System.out.println("Erreur ecartement de la carte " + p.getHand().getCard(cardName));
			}
		}
	}
}