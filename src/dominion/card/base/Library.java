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

	public Library() {
		super("Library", 5);
	}
	
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

			if(cartePioche != null) {
				if(cartePioche.getTypes().contains(CardType.Action)) {
				
					p.getGame().pause(1000, "You have draw an action card : " + cartePioche.getName());
				
					veutMettreDeCote = p.choose("Do you want to put it in the discard instead of your hand?", new ArrayList<String>(Arrays.asList("y", "n")), false);
				
					if(veutMettreDeCote.equalsIgnoreCase("y")) {
					
						carteDeCote.add(p.getHand().remove(cartePioche.getName()));
					
						p.getGame().pause(500, cartePioche + " add to the discard");
					}
				}
			}
		}
		p.getDiscard().addAll(carteDeCote);
	}
}