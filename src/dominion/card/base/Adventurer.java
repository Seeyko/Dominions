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
		super("Adventuer", 6);
	}
	public Adventurer(String name, int cost) {
		super(name, cost);
	}

	@Override
	public void play(Player p) {
		CardList carteTresor = new CardList();
		CardList carteADefaussez = new CardList();
		Card cartePiocher;
		
		while((cartePiocher = p.drawCard()) != null && carteTresor.size() < 2){
			
			p.getGame().pause(1000);
			
			System.out.println("Carte retourne : " + cartePiocher.getName());
			
			//Test si la carte piocher et de type tresor
			if(cartePiocher.getTypes().contains(CardType.Treasure)) {
				System.out.println("C'est une carte tresor !");
				carteTresor.add(cartePiocher);
				
				p.getGame().pause(1000, (carteTresor.size() + " carte Tresor trouve."));
				
			}else carteADefaussez.add(cartePiocher);

			p.getGame().pause(1000);

		}
		
		p.getDiscard().addAll(carteADefaussez);
		p.getDiscard().addAll(carteTresor);			
	}
	
	
}