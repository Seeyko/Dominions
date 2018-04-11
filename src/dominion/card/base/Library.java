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
		int Oui_Non = 0;
		while(p.getHand().size() < 7) {
			cartePioche = p.drawCard_AndAddInHand();

			if(cartePioche instanceof ActionCard) {
				System.out.println("Vous venez de piochez une carte action : " + cartePioche.getName());
				System.out.println("Voulez vous la mettre de cot� ? (1 = Oui, 0 = Non");
				Scanner sc = new Scanner(System.in);
				Oui_Non = sc.nextInt();
				if(Oui_Non == 1) {
					p.getDiscard().add(p.getHand().remove(cartePioche.getName()));
				}
			}
		}
	}
}