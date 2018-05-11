package dominion.card.base;
import java.util.*;
import java.util.concurrent.TimeUnit;

import dominion.*;
import dominion.card.*;

/**
 * Carte Aventurier (Adventurer)
 * 
 * Dévoilez des cartes de votre deck jusqu'à ce que 2 cartes Trésor soient dévoilées. Ajoutez ces cartes Trésor à votre main et défaussez les autres cartes dévoilées.
 */
public class Adventurer extends ActionCard {

	public Adventurer() {
		super("Adventurer", 6);
	}
	public Adventurer(String name, int cost) {
		super(name, cost);
	}

	@Override
	public void play(Player p) {
		CardList carteTresor = new CardList();
		CardList carteADefaussez = new CardList();
		Card cartePiocher;
		
		while(carteTresor.size() < 2 && (cartePiocher = p.drawCard()) != null){
			
			p.getGame().pause(1000, "Show a card : " + cartePiocher.getName());
			
			//Test si la carte piocher et de type tresor
			if(cartePiocher.getTypes().contains(CardType.Treasure)) {
				
				carteTresor.add(cartePiocher);
				p.getGame().pause(500, (carteTresor.size() + " Treasure card found"));
				
			}else if(!cartePiocher.getTypes().contains(CardType.Treasure)){
				carteADefaussez.add(cartePiocher);
			}
			
		}
		p.getHand().addAll(carteTresor);
		p.getDiscard().addAll(carteADefaussez);
	}
	
	
}