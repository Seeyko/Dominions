package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Bibliothèque (Library)
 * 
 * Piochez jusqu'à ce que vous ayez 7 cartes en main. Chaque carte Action piochée peut être mise de côté. Défaussez les cartes mises de côté lorsque vous avez terminé de piocher.
 */
public class Library extends ActionCard {

	public Library(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		Card cartePioche;
		CardList carteDeCote = new CardList();
		String veutMettreDeCote;
		while(p.getHand().size() < 7) {
			cartePioche = p.drawCard_AndAddInHand();

			if(cartePioche.getTypes().contains(CardType.Action)) {
				
				System.out.println("Vous venez de piochez une carte action : " + cartePioche.getName());
				
				veutMettreDeCote = p.choose("Voulez vous la mettre de cote ?", new ArrayList<String>(Arrays.asList("Oui", "Non")), false);
				
				if(veutMettreDeCote.equalsIgnoreCase("Oui")) {
					
					carteDeCote.add(cartePioche);
					
					p.getGame().pause(500, "Carte" + cartePioche + " ajoutez a la defausse.");
				}
			}
		}
		p.getDiscard().addAll(carteDeCote);
	}
}