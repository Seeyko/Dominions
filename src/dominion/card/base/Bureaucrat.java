package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Bureaucrate (Bureaucrat)
 * 
 * Recevez une carte Argent; placez-la sur votre deck.
 * Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck (sinon ils dévoilent leur main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).
 */
public class Bureaucrat extends AttackCard {

	public Bureaucrat(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		Card carteARetirez;
		Player adversaire;
		p.gain(p.getGame().removeFromSupply("Silver"));
		for(int i = 0; i < p.otherPlayers().size(); i++) {
			adversaire = p.otherPlayers().get(i);
			
			if(!PlayerHasMoatInHand(adversaire)){
				System.out.println("Recherche de carte Tresor dans la main de " + adversaire.getName() + "...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(adversaire.getTreasureCards().size() != 0) {
					carteARetirez = adversaire.getTreasureCards().remove(0);
					adversaire.totalCards().add(carteARetirez);
					System.out.println("carte trouv� : " + carteARetirez + " on la retire et la place sur le deck...");
					try {
					    Thread.sleep(1000);
					 } catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println(adversaire.getName() + " n'as pas de carte tr�sor en main, voila sa main : " + adversaire.getHand());
				}
			}
		}
	}
}