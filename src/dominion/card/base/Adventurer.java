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
	}

	@Override
	public void play(Player p) {
		CardList carteTresor = new CardList();
		CardList carteADefaussez = new CardList();
		Card cartePiocher;
		
		while((cartePiocher = p.drawCard()) != null && carteTresor.size() < 2){
			System.out.println("Retourne une carte du deck...");
			
			try {
			    Thread.sleep(1000);
			 } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Carte retourne : " + cartePiocher.getName());
			
			if(cartePiocher.getTypes().contains(CardType.Treasure)) {
				System.out.println("C'est une carte tresor !");
				carteTresor.add(cartePiocher);
				System.out.println(carteTresor.size() + " carte Tresor trouve.");
				try {
				    Thread.sleep(1000);
				 } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else carteADefaussez.add(cartePiocher);
			try {
			    Thread.sleep(1000);
			 } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		p.getDiscard().addAll(carteADefaussez);
		p.getDiscard().addAll(carteTresor);			
	}
	
	
}