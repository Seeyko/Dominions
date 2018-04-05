package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Bureaucrate (Bureaucrat)
 * 
 * Recevez une carte Argent; placez-la sur votre deck.
 * Tous vos adversaires d√©voilent une carte Victoire et la placent sur leur deck (sinon ils d√©voilent leur main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).
 */
public class Bureaucrat extends AttackCard {

	public Bureaucrat(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		Card carteARetirez;
		p.totalCards().add(p.getGame().removeFromSupply("Silver"));
		for(int i = 0; i < p.otherPlayers().size(); i++) {
			System.out.println("Recherche de carte Tresor dans la main de " + p.otherPlayers().get(i).getName() + "...");
			try {
			    Thread.sleep(1000);
			 } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(p.otherPlayers().get(i).getTreasureCards().size() != 0) {
				carteARetirez = p.otherPlayers().get(i).getTreasureCards().remove(0);
				p.otherPlayers().get(i).totalCards().add(carteARetirez);
				System.out.println("carte trouvÈ : " + carteARetirez + " on la retire et la place sur le deck...");
				try {
				    Thread.sleep(1000);
				 } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println(p.otherPlayers().get(i).getName() + " n'as pas de carte trÈsor en main, voila sa main : " + p.otherPlayers().get(i).getHand());
			}
		}
	}
}