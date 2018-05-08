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

	public Bureaucrat() {
		super("Bureaucrat", 4);
	}
	
	public Bureaucrat(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		Card carteARetirez;
		Player adversaire;
		p.gain("Silver");
		for(int i = 0; i < p.otherPlayers().size(); i++) {
			adversaire = p.otherPlayers().get(i);
			
			if(!PlayerHasMoatInHand(adversaire)){
				
				//Animation
				p.getGame().pause(1000, ("Recherche de carte Tresor dans la main de " + adversaire.getName()) ,"." , "." , ".");
				
				if(adversaire.getVictoryCards().size() != 0) {
					
					carteARetirez = adversaire.getVictoryCards().get(0);
					if(carteARetirez != null){
						adversaire.getHand().remove(carteARetirez.getName());
						System.out.println("carte trouve : " + carteARetirez.getName() + " on la retire et la place sur le deck...");
					}
					adversaire.gain(carteARetirez);
					
					
					p.getGame().pause(1000);
					
				} else {
					System.out.println(adversaire.getName() + " n'as pas de carte tresor en main, voila sa main : " + adversaire.getHand());
					
					p.getGame().pause(1000);

				}
			}
		}
	}
}