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

	public Adventurer(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		CardList carteTresor = new CardList();
		CardList carteADefaussez = new CardList();
		
		for(int i = 0; i < p.totalCards().size() && carteTresor.size() < 2; i++) {
			System.out.println("Retourne une carte du deck...");
			try {
			    Thread.sleep(1000);
			 } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(p.totalCards().get(i));
			if(p.totalCards().get(i) instanceof TreasureCard) {
				System.out.println(carteTresor.size() + " carte Tr�sor trouv�.");
				carteTresor.add(p.totalCards().remove(i));
			}else carteADefaussez.add(p.totalCards().remove(i));
		}
		p.getGame().getTrash().addAll(carteADefaussez);
		p.getHand().addAll(carteTresor);		
	}
}